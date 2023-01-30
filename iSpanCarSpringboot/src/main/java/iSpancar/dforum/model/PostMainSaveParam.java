package iSpancar.dforum.model;

public class PostMainSaveParam {

	private Integer id;

	private String body;

	private String title;

	private String uuid;

	private Integer category;

	private Boolean best;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getBest() {
		return best;
	}

	public void setBest(Boolean best) {
		this.best = best;
	}
}
