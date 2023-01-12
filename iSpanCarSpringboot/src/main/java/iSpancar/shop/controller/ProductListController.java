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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.model.ShopDetailDao;

@Controller
public class ProductListController {

	@Autowired
	private ShopDetailDao sDao;

	@GetMapping("/ProductListAll")
	public String processQueryAll(Model m) {

		List<ShopDetailBean> list = sDao.findAllProduct();
		m.addAttribute("queryallproduct", list);

		return "SHOP_DETAIL/iSpanProductList";
	}

	@PostMapping("/DeleteShopDetail.controller")
	@ResponseBody
	public String processDelete(@RequestParam("productno") String productno) {
		System.out.println("-------");
		try {
			System.out.println("trytrytry");
			List<ShopDetailBean> list = sDao.findByProductno(productno);
			for (ShopDetailBean sdb : list) {
				sDao.deleteProduct(sdb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "delete";
	}
	@PostMapping("/InsertShopDetail.controller")
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
            		
            		sDao.insertProduct(shopDetailBean);
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
	
	@GetMapping("/SendIdToUpdate.controller")
	public String processSendIdToUpdateAction(@RequestParam("productno") String productno,Model m) {
		try {
			List<ShopDetailBean> list = sDao.findByProductno(productno);
			m.addAttribute("sentno",list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "SHOP_DETAIL/UpdateProduct_form";
	}
	
	@PostMapping("/UpdateShopDetail.controller")
	public String processUpdateAction(@RequestParam("productno") String productno,@RequestParam("productname") String productname, @RequestParam("price") String price,@RequestParam("stock") String stock,@RequestParam("productinfo") String productinfo,@RequestParam("productimage") MultipartFile mf, Model success) {
		try {
			Integer productnoint = Integer.parseInt(productno);
			Integer priceint = Integer.parseInt(price);
			Integer stockint = Integer.parseInt(stock);
			
			String imgname = mf.getOriginalFilename();
			byte[] bytes = mf.getBytes();
			SerialBlob productImg = new SerialBlob(bytes);
				ShopDetailBean sBean = new ShopDetailBean(productnoint,productname,priceint,stockint,productinfo,productImg,imgname);
				sDao.updateProduct(sBean);
//				success.addAttribute("success",success);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "SHOP_DETAIL/UpdateProductSucess";
	}
        }


