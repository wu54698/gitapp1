package iSpancar.dforum.query;

public class PostQuery {

	private int pageNum;

	private int pageSize;

	private String title;

	private Boolean best;

	private Integer likeCountStart;

	private Integer likeCountEnd;

	private Integer categoryId;

	public Boolean isBest() {
		return best;
	}

	public void setBest(Boolean best) {
		this.best = best;
	}

	public Integer getLikeCountStart() {
		return likeCountStart;
	}

	public void setLikeCountStart(Integer likeCountStart) {
		this.likeCountStart = likeCountStart;
	}

	public Integer getLikeCountEnd() {
		return likeCountEnd;
	}

	public void setLikeCountEnd(Integer likeCountEnd) {
		this.likeCountEnd = likeCountEnd;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Boolean getBest() {
		return best;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
