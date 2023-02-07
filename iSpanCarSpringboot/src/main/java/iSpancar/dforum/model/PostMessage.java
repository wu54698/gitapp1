package iSpancar.dforum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import iSpancar.member.model.MemberBean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post_message")
public class PostMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "content")
	private String content ;

	@Column(name = "time")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date time ;

	@ManyToOne
	@JoinColumn(name = "memberId")
	private MemberBean member;

	@ManyToOne
	@JoinColumn(name = "replyMemberId")
	private MemberBean replyMember;

	@ManyToOne
	@JoinColumn(name = "postId")
	@JsonIgnore
	private PostMain post;

	@Transient
	private boolean liked;

	@Transient
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
