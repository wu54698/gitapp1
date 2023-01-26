package iSpancar.dforum.query;

import iSpancar.dforum.model.PostMain;
import iSpancar.member.model.MemberBean;

import java.util.Date;


public class PostMessageParam {

	private Integer id;
	

	private String content ;

	private Date time ;

	private MemberBean member;

	private MemberBean replyMember;

	private PostMain post;

	private boolean liked;

	private boolean disliked;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public PostMain getPost() {
		return post;
	}

	public void setPost(PostMain post) {
		this.post = post;
	}

	public MemberBean getReplyMember() {
		return replyMember;
	}

	public void setReplyMember(MemberBean replyMember) {
		this.replyMember = replyMember;
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
}
