package iSpancar.dforum.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "thread")
public class Thread {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "time")
	private Date time ;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


}
