package dforum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "title")
	private String title ;
	
	@Column(name = "body")
	private String body ;

	@Column(name = "time")
	private java.sql.Timestamp time ;


	@Column(name = "isOP")
	private boolean isOP ;

	@ManyToOne
	@JoinColumn(name = "memberId")
	private ForumMember member;
	
	@ManyToOne
	@JoinColumn(name = "threadId")
	private Thread thread;

	public Post() {
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

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	public boolean isOP() {
		return isOP;
	}

	public void setOP(boolean isOP) {
		this.isOP = isOP;
	}

	public ForumMember getMember() {
		return member;
	}

	public void setMember(ForumMember member) {
		this.member = member;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}



}
