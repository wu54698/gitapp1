package iSpancar.dforum.controller;

import iSpancar.dforum.model.Category;
import iSpancar.dforum.model.PostLike;
import iSpancar.dforum.model.PostMain;
import iSpancar.dforum.model.PostMainSaveParam;
import iSpancar.dforum.model.PostMessage;
import iSpancar.dforum.model.Result;
import iSpancar.dforum.model.Thread;
import iSpancar.dforum.query.PostMessageParam;
import iSpancar.dforum.query.PostQuery;
import iSpancar.dforum.repository.PostLikeRepository;
import iSpancar.dforum.repository.PostMessageRepository;
import iSpancar.dforum.repository.PostRepository;
import iSpancar.dforum.repository.ThreadRepository;
import iSpancar.dforum.service.CategoryService;
import iSpancar.dforum.service.WebContextService;
import iSpancar.member.model.MemberBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/dforum")
public class PortalPostController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostMessageRepository postMessageRepository;

	@Autowired
	private WebContextService webContextService;

	@Autowired
	private PostLikeRepository postLikeRepository;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ThreadRepository threadRepository;

	@GetMapping("/category")
	public Result categorys() {
		List<Category> categories = categoryService.findAll();
		return Result.ok(categories);
	}

	/**
	 * 貼文列表查詢
	 *
	 * @param postQuery
	 * @return
	 */
	@GetMapping("/post")
	public Result postList(PostQuery postQuery) {
		Specification<PostMain> where = new Specification<>() {
			/**
			 * 定義查詢條件
			 * @param root 根對象 封裝查詢條件
			 * @param criteriaQuery 基本的查詢
			 * @param criteriaBuilder 創建查詢條件
			 * @return
			 */
			@Override
			public Predicate toPredicate(Root<PostMain> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<>();

				// 1頂級樓層
				list.add(criteriaBuilder.equal(root.get("isOP"), true));


				if (postQuery.isBest() != null) {
					list.add(criteriaBuilder.equal(root.get("best"), postQuery.isBest()));
				}

				if (StringUtils.hasText(postQuery.getTitle())) {
					list.add(criteriaBuilder.like(root.get("title"), "%" + postQuery.getTitle() + "%"));
				}

				if (postQuery.getCategoryId() != null) {
					list.add(criteriaBuilder.equal(root.get("categoryId"), postQuery.getCategoryId()));
				}

				if (postQuery.getLikeCountStart() != null && postQuery.getLikeCountEnd() != null) {
					list.add(criteriaBuilder.between(root.get("likeCount"), postQuery.getLikeCountStart(), postQuery.getLikeCountEnd()));
				}

				Predicate[] arr = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(arr));
			}
		};

		PageRequest of = PageRequest.of(postQuery.getPageNum(), postQuery.getPageSize(),
				Sort.by(Sort.Direction.DESC, "head", "id"));
		Page<PostMain> page = postRepository.findAll(where, of);
		for (PostMain postMain : page.getContent()) {
			postMain.setBody(null);
			postMain.setPostMessages(Collections.emptyList());
		}
		return Result.ok(page);
	}


	/**
	 * 貼文詳情查詢
	 *
	 * @param uuid
	 * @return
	 */
	@GetMapping("/post/{uuid}")
	public Result postDetail(@PathVariable String uuid,
							 @RequestParam(required = false) Integer postId,
							 @RequestParam int pageSize,
							 @RequestParam int pageNum) {
		MemberBean loginUser = webContextService.getCurrUser();

		Specification<PostMain> where = new Specification<>() {
			/**
			 * 定義查詢條件
			 * @param root 根對象 封裝查詢的條件對象
			 * @param criteriaQuery 基本的查詢
			 * @param criteriaBuilder 創建查詢條件
			 * @return
			 */
			@Override
			public Predicate toPredicate(Root<PostMain> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<>();
				list.add(criteriaBuilder.equal(root.get("uuid"), uuid));

				if (postId != null) {
					list.add(criteriaBuilder.equal(root.get("id"), postId));
				}

				Predicate[] arr = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(arr));
			}
		};

		PageRequest of = PageRequest.of(pageNum, pageSize, Sort.sort(PostMain.class).by(PostMain::getId).ascending());
		Page<PostMain> page = postRepository.findAll(where, of);

		// 查詢當前登陸人是否有點讚的紀錄
		List<PostMain> content = page.getContent();
		if (loginUser != null) {
			for (PostMain postMain : content) {
				// 貼文喜歡查詢
				Integer id = postMain.getId();
				List<PostLike> postLikes = postLikeRepository.findPostLikeByDataIdAndTypeAndMember(id, 1, loginUser.getAccountnumber());
				for (PostLike postLike : postLikes) {
					if (postLike.getLiked() == 1) {
						postMain.setLiked(true);
					} else if (postLike.getLiked() == 2) {
						postMain.setDisliked(true);
					}
				}

				// 貼文留言喜歡查詢
				List<PostMessage> postMessages = postMain.getPostMessages();
				for (PostMessage postMessage : postMessages) {
					Integer msgId = postMessage.getId();
					List<PostLike> msgLikes = postLikeRepository.findPostLikeByDataIdAndTypeAndMember(msgId, 2, loginUser.getAccountnumber());
					for (PostLike msgLike : msgLikes) {
						if (msgLike.getLiked() == 1) {
							postMessage.setLiked(true);
						} else if (msgLike.getLiked() == 2) {
							postMessage.setDisliked(true);
						}
					}
				}
			}
		}


		return Result.ok(page);
	}


	/**
	 * 貼文樓層留言
	 *
	 * @param postMessage
	 */
	@PostMapping("/post/message")
	public Result message(@RequestBody PostMessageParam postMessage) {
		postMessage.setTime(new Date());
		MemberBean loginUser = webContextService.getCurrUser();
		if (loginUser == null) {
			return Result.fail("no login");
		}
		postMessage.setMember(loginUser);
		PostMessage createMessage = new PostMessage();
		BeanUtils.copyProperties(postMessage, createMessage);
		postMessageRepository.save(createMessage);
		final String uuid = postRepository.findById(createMessage.getPost().getId()).get().getUuid();

		incPostMainCountData(uuid, loginUser);
		return Result.ok(postMessage);
	}

	/**
	 * 修改主樓層的統計數據
	 *
	 * @param uuid
	 */
	private PostMain incPostMainCountData(String uuid, MemberBean loginUser) {
		// 0.修改互動數量
		PostMain postMain = postRepository.findFirstByUuidAndIsOP(uuid, true);
		postMain.setInteractiveCount(postMain.getInteractiveCount() + 1);

		// 1.樓層數量
		int floorCount = postRepository.countByUuid(uuid);
		postMain.setFloorCount(floorCount);

		// 2.人氣數量
		List<PostMain> allPostMessage = postRepository.findPostMainByUuid(uuid);
		// 帖子用戶
		Set<String> postUsers = allPostMessage.stream().map(PostMain::getMember).map(MemberBean::getAccountnumber).collect(Collectors.toSet());
		// 留言版用戶
		List<PostMessage> postMessageByPost = postMessageRepository.findPostMessageByPost(postMain);
		Set<String> messageUsers = postMessageByPost.stream().map(PostMessage::getMember).map(MemberBean::getAccountnumber).collect(Collectors.toSet());
		postUsers.addAll(messageUsers);
		postMain.setPopularityCount(postUsers.size());
		postMain.setLastReplyTime(new Date());
		postMain.setLastReplay(loginUser);
		// 3.保存
		postRepository.save(postMain);
		return postMain;
	}


	/**
	 * 點讚 or倒讚
	 *
	 * @param postLike
	 */
	@PostMapping("/like")
	public Result postLike(@RequestBody PostLike postLike) {
		MemberBean loginUser = webContextService.getCurrUser();
		if (loginUser == null) {
			return Result.fail("no login");
		}

		// 刪除
		PostLike oldLike = postLikeRepository.findFirstByDataIdAndTypeAndLikedAndMember(postLike.getDataId(), postLike.getType(), postLike.getLiked(), loginUser.getAccountnumber());
		boolean delete = oldLike != null;

		if (!delete) {
			postLike.setMember(loginUser.getAccountnumber());
			postLike.setTime(new Date());
			postLikeRepository.save(postLike);
		} else {
			postLikeRepository.delete(oldLike);
		}

		// 如果是留言，獲取到貼文
		Integer dataId = postLike.getDataId();
		PostMain post;
		if (postLike.getType() == 2) {
			PostMessage postMessage = postMessageRepository.findById(dataId).get();
			post = postMessage.getPost();
		} else {
			post = postRepository.findById(dataId).get();
		}

		final String uuid = post.getUuid();
		incPostMainCountData(uuid, loginUser);
		// 喜歡數量+1
		if (delete) {
			if (postLike.getLiked() == 1) {
				post.setLikeCount(post.getLikeCount() - 1);
				postRepository.save(post);
			}
			if (postLike.getLiked() == 2) {
				post.setDisLikeCount(post.getDisLikeCount() - 1);
				postRepository.save(post);
			}
		} else {
			if (postLike.getLiked() == 1) {
				post.setLikeCount(post.getLikeCount() + 1);
				postRepository.save(post);
			}
			if (postLike.getLiked() == 2) {
				post.setDisLikeCount(post.getDisLikeCount() + 1);
				postRepository.save(post);
			}
		}
		return Result.ok(postLike);
	}


	/**
	 * 跟貼文
	 *
	 * @param postMainSaveParam
	 * @return
	 */
	@PostMapping("/post")
	@Transactional(rollbackFor = Exception.class)
	protected Result save(@RequestBody PostMainSaveParam postMainSaveParam) {

		Thread saveThread = categoryService.findById(postMainSaveParam.getCategory()).map((cat) -> {
			Thread thread = new Thread();
			thread.setCategory(cat);
			thread.setTime(new Date());
			threadRepository.save(thread);
			return thread;
		}).orElse(null);
		PostMain post = new PostMain();
		post.setOP(false);
		post.setUuid(postMainSaveParam.getUuid());
		MemberBean currUser = webContextService.getCurrUser();
		if (currUser == null) {
			return Result.fail("no login");
		}
		post.setMember(currUser);
		post.setTime(new Date());
		String body = postMainSaveParam.getBody();
		post.setBody(body);
		// body not blank set image
		if (StringUtils.hasText(post.getBody())) {
			Document parse = Jsoup.parse(post.getBody());
			Elements imgs = parse.select("img");
			if (imgs != null && !imgs.isEmpty()) {
				post.setImage(imgs.get(0).toString());
			}
			String text = parse.text();
			post.setBodySimple(text.substring(0, Math.min(text.length(), 300)));
		}
		post.setTitle(postMainSaveParam.getTitle());
		post.setThread(saveThread);
		post.setFloorCount(1);
		post.setHead(0);
		post.setLikeCount(0);
		post.setDisLikeCount(0);
		post.setInteractiveCount(1);
		post.setPopularityCount(1);
		post.setLastReplay(currUser);
		post.setLastReplyTime(new Date());
		post.setCategoryId(postMainSaveParam.getCategory());
		post.setQuestion(postMainSaveParam.getQuestion());
		postRepository.save(post);

		// 原帖人气计算
		this.incPostMainCountData(post.getUuid(), currUser);
		return Result.ok(post);
	}


	/**
	 * 发新帖
	 *
	 * @param postMainSaveParam
	 * @return
	 */
	@PostMapping("/post/new")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	protected Result create(@RequestBody PostMainSaveParam postMainSaveParam) {
		Thread saveThread = categoryService.findById(postMainSaveParam.getCategory()).map((cat) -> {
			Thread thread = new Thread();
			thread.setCategory(cat);
			thread.setTime(new Date());
			threadRepository.save(thread);
			return thread;
		}).orElse(null);
		PostMain post = new PostMain();
		post.setOP(true);
		post.setId(postMainSaveParam.getId());
		if (postMainSaveParam.getId() == null) {
			String uuid = UUID.randomUUID().toString();
			post.setUuid(uuid);
		}
		MemberBean currUser = webContextService.getCurrUser();
		if (currUser == null) {
			return Result.fail("no login");
		}
		post.setMember(currUser);
		post.setTime(new Date());
		String body = postMainSaveParam.getBody();
		post.setBody(body);
		// body not blank set image
		if (StringUtils.hasText(post.getBody())) {
			Document parse = Jsoup.parse(post.getBody());
			Elements imgs = parse.select("img");
			if (imgs != null && !imgs.isEmpty()) {
				post.setImage(imgs.get(0).toString());
			}
			String text = parse.text();
			post.setBodySimple(text.substring(0, text.length() > 300 ? 300 : text.length()));
		}
		post.setTitle(postMainSaveParam.getTitle());
		post.setThread(saveThread);
		post.setBest(postMainSaveParam.getBest());
		post.setHead(0);
		post.setFloorCount(1);
		post.setLikeCount(0);
		post.setDisLikeCount(0);
		post.setInteractiveCount(1);
		post.setPopularityCount(1);
		post.setLastReplay(currUser);
		post.setLastReplyTime(new Date());
		post.setCategoryId(postMainSaveParam.getCategory());
		post.setQuestion(postMainSaveParam.getQuestion());
		postRepository.save(post);

		return Result.ok("操作成功！");
	}
}
