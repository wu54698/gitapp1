package iSpancar.shop.model;

import java.sql.Blob;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ShopDetailImagesRepository extends JpaRepository<ShopDetailImgsBean, Integer> {
	
	//新增多圖
		@Modifying
		@Query(value = "insert into shopimgs values (?1, ?2, ?3)", nativeQuery = true)
		public ShopDetailImgsBean addMultiImgs(int imgsno ,int productno, Blob manyimgs);
		
		//查詢該產品的多圖
		@Modifying
		@Query(value = "select * from shopimgs where productno =?1", nativeQuery = true)
		public List<ShopDetailImgsBean> findMultiImageByProductno(int productno);
		
		//用產品編號刪除多圖
		@Modifying
		@Query(value = "delete from shopimgs where productno =?1", nativeQuery = true)
		public void deleteByProductno(int productno);
		
	}


