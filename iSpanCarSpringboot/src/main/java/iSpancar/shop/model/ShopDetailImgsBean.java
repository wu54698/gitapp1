package iSpancar.shop.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shopimgs")
@Component
public class ShopDetailImgsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "imgsno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imgsno;
	
	@JoinColumn(name = "productno")
	@ManyToOne
	@JsonIgnore
	private ShopDetailBean shopDetailBean;
	
	@Column(name = "manyimgs")
	@JsonIgnore
	private Blob manyimgs;

	public ShopDetailImgsBean() {
	}

	public ShopDetailImgsBean(int imgsno, ShopDetailBean shopDetailBean, Blob manyimgs) {
		super();
		this.imgsno = imgsno;
		this.shopDetailBean = shopDetailBean;
		this.manyimgs = manyimgs;
	}

	public int getImgsno() {
		return imgsno;
	}

	public void setImgsno(int imgsno) {
		this.imgsno = imgsno;
	}

	public ShopDetailBean getProductno() {
		return shopDetailBean;
	}

	public void setProductno(ShopDetailBean shopDetailBean) {
		this.shopDetailBean = shopDetailBean;
	}

	public Blob getManyimgs() {
		return manyimgs;
	}

	public void setManyimgs(Blob manyimgs) {
		this.manyimgs = manyimgs;
	}
	
	
	
	
	

}
