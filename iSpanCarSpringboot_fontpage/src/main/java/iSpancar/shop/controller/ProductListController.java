package iSpancar.shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.model.ShopDetailDao;
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

		List<ShopDetailBean> list = service.findAll();
		m.addAttribute("queryallproduct", list);

		return "SHOP_DETAIL/Shop_Cart";
	}

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
	@PostMapping("/iSpancarShop.InsertShopDetail.controller")
    public String processInsertAction(@RequestParam("productname") String productname,@RequestParam("type") String type,@RequestParam("spec") String spec
    				,@RequestParam("price") int price,@RequestParam("stock") int stock,@RequestParam("uptime") String uptime,@RequestParam("productinfo") String productinfo,@RequestParam("productimage") MultipartFile mf) {
		
                try {
                	String imgname = mf.getOriginalFilename();
            		byte[] bytes = mf.getBytes();
            		Blob imageblob = null;
            		if(bytes.length==0) {
            			
            		}else {
            			imageblob = new SerialBlob(bytes);
            		}
            		ShopDetailBean shopDetailBean = new ShopDetailBean(productname,type,spec,price,stock,uptime,productinfo,imageblob,imgname);
            		
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
	
	@PostMapping("/iSpancarShop.SendIdToUpdate.controller")
	public String processSendIdToUpdateAction(@RequestParam("productno") String productno,Model m) {
		List<ShopDetailBean> list = service.findByProductno(productno);
		m.addAttribute("sentno",list);
		return "SHOP_DETAIL/UpdateProduct_form";
	}
	
	@PostMapping("/iSpancarShop.UpdateShopDetail.controller")
	public String processUpdateAction(@RequestParam("productno") String productno,@RequestParam("productname") String productname, @RequestParam("type") String type,@RequestParam("spec") String spec,@RequestParam("price") String price,@RequestParam("stock") String stock,@RequestParam("uptime") String uptime,@RequestParam("productinfo") String productinfo,@RequestParam("productimage") MultipartFile mf, Model success) {
		try {
			System.out.println("------------------------------------");
			System.out.println(productname);
			System.out.println("------------------------------------");
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
					ogBean.setProductname(sdb.getProductname());
					ogBean.setType(sdb.getType());
					ogBean.setType(sdb.getSpec());
					ogBean.setPrice(sdb.getPrice());
					ogBean.setStock(sdb.getStock());
					ogBean.setUptime(sdb.getUptime());
					ogBean.setProductinfo(sdb.getProductinfo());
					ogBean.setProductimage(sdb.getProductimage());
					ogBean.setProductimagename(sdb.getProductimagename());
				}
				String NewProductname = (productname.equals("")) ? ogBean.getProductname() : productname;
				String NewType = (type.equals("")) ? ogBean.getType() : type;
				String NewSpec = (spec.equals("")) ? ogBean.getSpec() : spec;
				Integer NewPrice = (priceint.equals("")) ? ogBean.getPrice() : priceint;
				Integer NewStock = (stockint.equals("")) ? ogBean.getStock() : stockint;
				String NewUptime = (uptime.equals("")) ? ogBean.getUptime() : uptime;
				String NewProductinfo = (productinfo.equals("")) ? ogBean.getProductinfo() : productinfo;
				Blob NewProductimage = 	(bytes.length==0) ? ogBean.getProductimage(): productImg;
				String NewProductimagename = (imgname.equals("")) ? ogBean.getProductimagename() : imgname;
				
				ShopDetailBean bean = new ShopDetailBean(productnoint,NewProductname,NewType,NewSpec,NewPrice,NewStock,NewUptime,NewProductinfo,NewProductimage,NewProductimagename);
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
	
	@GetMapping("/iSpancarShop.insertpage")
    public String forward() {
        return "forward:/WEB-INF/jsp/SHOP_DETAIL/iSpanShopInsert.jsp";
    }
	
}
        


