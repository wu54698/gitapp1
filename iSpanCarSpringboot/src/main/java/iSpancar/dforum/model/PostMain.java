package iSpancar.dforum.model;

import iSpancar.member.model.MemberBean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class PostMain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "post_uuid")
	private String uuid;

	@Column(name = "title")
	private String title;

	@Column(name = "body", columnDefinition = "varchar(max)")
	private String body;

	@Column(name = "bodySimple", length = 500)
	private String bodySimple;

	@Column(name = "time")
	private Date time;

	/**
	 * 是否為頂級帖
	 */
	@Column(name = "isOP")
	private boolean isOP;

	@Column(name = "image", columnDefinition = "varchar(max)")
	private String image;

	@Column(name = "best")
	private Boolean best;

	@Column(name = "likeCount")
	private Integer likeCount;

	@Column(name = "disLikeCount")
	private Integer disLikeCount;

	/**
	 * 樓層數量
	 */
	@Column(name = "floorCount")
	private Integer floorCount;

	/**
	 * 互動數量
	 */
	@Column(name = "interactiveCount")
	private Integer interactiveCount;

	/**
	 * 人氣數量
	 */
	@Column(name = "popularityCount")
	private Integer popularityCount;

	/**
	 * 最新回復
	 */
	@Column(name = "lastReplyTime")
	private Date lastReplyTime;

	/**
	 * 最新回復人
	 */
	@ManyToOne
	@JoinColumn(name = "lastReplyId")
	private MemberBean lastReplay;

	@ManyToOne
	@JoinColumn(name = "memberId")
	private MemberBean member;

	@Column(name = "categoryId")
	private Integer categoryId;

	@ManyToOne
	@JoinColumn(name = "threadId")
	private Thread thread;

	@Transient
	private boolean liked;

	@Transient
	private boolean disliked;


	@OneToMany(mappedBy = "post", cascade = CascadeType.DETACH)
	private List<PostMessage> postMessages;

	public PostMain() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public boolean isOP() {
		return isOP;
	}

	public void setOP(boolean isOP) {
		this.isOP = isOP;
	}

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean isBest() {
		return best;
	}

	public void setBest(Boolean best) {
		this.best = best;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public String getBodySimple() {
		return bodySimple;
	}

	public void setBodySimple(String bodySimple) {
		this.bodySimple = bodySimple;
	}

	public Boolean getBest() {
		return best;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getFloorCount() {
		return floorCount;
	}

	public void setFloorCount(Integer floorCount) {
		this.floorCount = floorCount;
	}

	public Integer getInteractiveCount() {
		return interactiveCount;
	}

	public void setInteractiveCount(Integer interactiveCount) {
		this.interactiveCount = interactiveCount;
	}

	public Integer getPopularityCount() {
		return popularityCount;
	}

	public void setPopularityCount(Integer popularityCount) {
		this.popularityCount = popularityCount;
	}

	public Date getLastReplyTime() {
		return lastReplyTime;
	}

	public void setLastReplyTime(Date lastReplyTime) {
		this.lastReplyTime = lastReplyTime;
	}

	public MemberBean getLastReplay() {
		return lastReplay;
	}

	public void setLastReplay(MemberBean lastReplay) {
		this.lastReplay = lastReplay;
	}

	public List<PostMessage> getPostMessages() {
		return postMessages;
	}

	public void setPostMessages(List<PostMessage> postMessages) {
		this.postMessages = postMessages;
	}

	public boolean getLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public boolean getDisliked() {
		return disliked;
	}

	public void setDisliked(boolean disliked) {
		this.disliked = disliked;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getDisLikeCount() {
		return disLikeCount;
	}

	public void setDisLikeCount(Integer disLikeCount) {
		this.disLikeCount = disLikeCount;
	}

	public boolean isLiked() {
		return liked;
	}

	public boolean isDisliked() {
		return disliked;
	}
}
