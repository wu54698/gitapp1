package iSpancar.dforum.model;

import javax.persistence.*;
import java.util.Date;

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
	private Date time ;

	@Column(name = "isOP")
	private boolean isOP ;

	@ManyToOne
	@JoinColumn(name = "memberid")
	private ForumMember member;
	
	@ManyToOne
	@JoinColumn(name = "threadid")
	private Thread thread;

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
