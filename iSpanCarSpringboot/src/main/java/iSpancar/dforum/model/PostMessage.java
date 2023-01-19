package iSpancar.dforum.model;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private ForumMember member;

	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;

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

	public ForumMember getMember() {
		return member;
	}

	public void setMember(ForumMember member) {
		this.member = member;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
