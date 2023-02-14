package iSpancar.shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.model.ShopDetailImgsBean;
import iSpancar.shop.service.ShopDetailService;

@Controller
@RequestMapping("/backstage")
public class ProductListController {

	@Autowired
	private ShopDetailService service;

	@GetMapping("/iSpancarShop.ProductListAll")
	public String processQueryAll(Model m) {

		List<ShopDetailBean> list = service.findAll();
		m.addAttribute("queryallproduct", list);
		System.out.println(list);
		return "SHOP_DETAIL/iSpanProductList";
	}
	
	@GetMapping("/iSpancarShop.Shop_Cart.controller")
	public String processToShopCart(Model m) {

		return "iSpancarShop.DetailShopPage";
		
	}

	//刪除
	@PostMapping("/iSpancarShop.DeleteShopDetail.controller")
	@ResponseBody
	public String processDelete(@RequestParam("productno") String productno) {
		System.out.println("-------");
		try {
			List<ShopDetailBean> list = service.findByProductno(productno);
			for (ShopDetailBean sdb : list) {
				service.delete(sdb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "delete";
	}
	
	//新增
	@PostMapping("/iSpancarShop.InsertShopDetail.controller")
    public String processInsertAction(@RequestParam("productname") String productname,@RequestParam("type") String type,
    		@RequestParam("spec") String spec,@RequestParam("price") int price,@RequestParam("stock") int stock,
    		@RequestParam("uptime") String uptime,@RequestParam("productinfo") String productinfo,
    		@RequestParam("productimage") MultipartFile mf,@RequestParam("manyimgs") List<MultipartFile> mfs) {
		
                try {
                	String imgname = mf.getOriginalFilename();
            		byte[] bytes = mf.getBytes();
            		Blob imageblob = null;
            		if(bytes.length==0) {
            			
            		}else {
            			imageblob = new SerialBlob(bytes);
            		}
            		ShopDetailBean shopDetailBean = new ShopDetailBean(productname,type,spec,price,stock,uptime,
            										productinfo,imageblob,imgname);
            		
            		List<ShopDetailImgsBean> list = new ArrayList<ShopDetailImgsBean>();
            		for(MultipartFile multiImgs : mfs) {
            			byte[] multiImgBytes = multiImgs.getBytes();
            			Blob multiImageBlob = null;
            			if (multiImgBytes.length == 0) {
            			} else {
            				multiImageBlob = new SerialBlob(multiImgBytes);
            				ShopDetailImgsBean shopDetailImgsBean = new ShopDetailImgsBean();
            				shopDetailImgsBean.setManyimgs(multiImageBlob);
            				shopDetailImgsBean.setProductno(shopDetailBean);
            				list.add(shopDetailImgsBean);
            				shopDetailBean.setImagesBean(list);
            			}
            		}
            		service.insertProduct(shopDetailBean);
                
                } catch (IOException e) {
        			e.printStackTrace();
        		} catch (SerialException e) {
        			e.printStackTrace();
        		} catch (SQLException e) {
        			e.printStackTrace();
        		} catch (ParseException e) {
        			e.printStackTrace();
        		}
        		return "SHOP_DETAIL/InsertProductSuccess";
        	}
	
	//依productno 送值到修改頁面
	@PostMapping("/iSpancarShop.SendIdToUpdate.controller")
	public String processSendIdToUpdateAction(@RequestParam("productno") String productno,Model m) {
		List<ShopDetailBean> list = service.findByProductno(productno);
		int productNumber = Integer.parseInt(productno);
		List<ShopDetailImgsBean> multiImg = service.findMultiImgsByProductno(productNumber);
		
		m.addAttribute("sentno",list);
		m.addAttribute("multiImgList",multiImg);
		return "SHOP_DETAIL/UpdateProduct_form";
	}
	
	//修改
	@PostMapping("/iSpancarShop.UpdateShopDetail.controller")
	public String processUpdateAction(@RequestParam("productno") String productno,@RequestParam("productname") String productname, 
			@RequestParam("type") String type,@RequestParam("spec") String spec,@RequestParam("price") String price,
			@RequestParam("stock") String stock,@RequestParam("uptime") String uptime,@RequestParam("productinfo") String productinfo,
			@RequestParam("productimage") MultipartFile mf, @RequestParam("manyimgs") List<MultipartFile> mfs) {
		try {
			System.out.println(productname);
			Integer productnoint = Integer.parseInt(productno);
			Integer priceint = Integer.parseInt(price);
			Integer stockint = Integer.parseInt(stock);
			String imgname = mf.getOriginalFilename();
			byte[] bytes = mf.getBytes();
			SerialBlob productImg = new SerialBlob(bytes);
			
			List<ShopDetailBean> list = service.findByProductno(productno);
//				抓原值並帶入驗證判斷式
			ShopDetailBean ogBean = new ShopDetailBean();
				for(ShopDetailBean sdb :list) {
					ogBean.setProductno(sdb.getProductno());
					ogBean.setProductname(sdb.getProductname());
					ogBean.setType(sdb.getType());
					ogBean.setType(sdb.getSpec());
					ogBean.setPrice(sdb.getPrice());
					ogBean.setStock(sdb.getStock());
					ogBean.setUptime(sdb.getUptime());
					ogBean.setProductinfo(sdb.getProductinfo());
					ogBean.setProductimage(sdb.getProductimage());
					ogBean.setProductimagename(sdb.getProductimagename());
					ogBean.setImagesBean(sdb.getImagesBean());
				}
				
//				修改加入新的多圖方法，用boolean來判斷multipartFile的size是否為0，因為不修改圖，multipartFile的size為0
				List<ShopDetailImgsBean> imgsList = new ArrayList<ShopDetailImgsBean>();
				boolean checkNotNull = true;
				for(MultipartFile multipartFile : mfs) {
					if(multipartFile.getSize() != 0) {
						checkNotNull = false;
						}
				}
				if(checkNotNull) {
				}else {
					service.deleteMultiImgsByProductno(productnoint);
					
					for(MultipartFile multiImg : mfs) {
						byte[] multiImgBytes = multiImg.getBytes();
								
						Blob multiImgBlob = null;
						if(multiImgBytes.length == 0) {
						}else {
							multiImgBlob = new SerialBlob(multiImgBytes);
							ShopDetailImgsBean sImgBean= new ShopDetailImgsBean();
							sImgBean.setManyimgs(multiImgBlob);
							sImgBean.setProductno(ogBean); //因為關聯需要productno，ogBean有productno
							imgsList.add(sImgBean);	
						}
					}
				}	
				//若輸入空值，則抓取舊有的數值
				String NewProductname = (productname.equals("")) ? ogBean.getProductname() : productname;
				String NewType = (type.equals("")) ? ogBean.getType() : type;
				String NewSpec = (spec.equals("")) ? ogBean.getSpec() : spec;
				Integer NewPrice = (priceint.equals("")) ? ogBean.getPrice() : priceint;
				Integer NewStock = (stockint.equals("")) ? ogBean.getStock() : stockint;
				String NewUptime = (uptime.equals("")) ? ogBean.getUptime() : uptime;
				String NewProductinfo = (productinfo.equals("")) ? ogBean.getProductinfo() : productinfo;
				Blob NewProductimage = 	(bytes.length==0) ? ogBean.getProductimage(): productImg;
				String NewProductimagename = (imgname.equals("")) ? ogBean.getProductimagename() : imgname;
				List<ShopDetailImgsBean> NewMultiImg = (checkNotNull) ? ogBean.getImagesBean() : imgsList;
				
				ShopDetailBean bean = new ShopDetailBean(productnoint,NewProductname,NewType,NewSpec,NewPrice,
									NewStock,NewUptime,NewProductinfo,NewProductimage,NewProductimagename,NewMultiImg);
				service.updateByProductno(bean);
				
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "SHOP_DETAIL/UpdateProductSucess";
	}
	
	//跳轉至新增頁面
	@GetMapping("/iSpancarShop.insertpage")
    public String forward() {
        return "forward:/WEB-INF/jsp/SHOP_DETAIL/iSpanShopInsert.jsp";
    }
	
	//多圖取出
		@GetMapping("/showMultiImges.controller/{imgsno}")
		@ResponseBody
		public byte[] showMultiShopDetailImgAction(@PathVariable("imgsno") String imgsno) {
			
			//imgsno為圖片主鍵，所以透過主鍵找出對應之productno下的多圖，一張一張顯示出來
			int imageNumber = Integer.parseInt(imgsno);
			ShopDetailImgsBean singleImageBean = service.findsingleImgByImgno(imageNumber);

				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx抓值xxxxxxxxxxxx:" + singleImageBean.getImgsno());
				try {
					InputStream is;
					is = singleImageBean.getManyimgs().getBinaryStream();
					return IOUtils.toByteArray(is);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			return null;
		}
}
        


