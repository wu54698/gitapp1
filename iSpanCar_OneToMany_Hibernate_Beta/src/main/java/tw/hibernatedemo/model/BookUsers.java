package tw.hibernatedemo.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "bookUsers")
public class BookUsers {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookusers", cascade = CascadeType.ALL)
	@OrderBy("publicYear desc") //拿資料順序
	private Set<Books> books = new LinkedHashSet<>();
	
	public BookUsers() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Set<Books> getBooks() {
		return books;
	}


	public void setBooks(Set<Books> books) {
		this.books = books;
	}

}
