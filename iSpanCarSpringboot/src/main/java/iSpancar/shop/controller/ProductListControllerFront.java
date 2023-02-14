package iSpancar.shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.model.ShopDetailImgsBean;
import iSpancar.shop.service.ShopDetailService;

@Controller
public class ProductListControllerFront {

	@Autowired
	private ShopDetailService service;

	//前台未寫分頁前的正常頁面
	@GetMapping("/iSpancarShop.ProductListAllShopPage")
	public String processQueryAllShopPage1(Model m) {
		
		List<ShopDetailBean> list = service.findAll();
		
		//精選商品
				List<ShopDetailBean> randomProductList = service.findAll();
				Random random = new Random();
				
				ArrayList<ShopDetailBean> newProudctList = new ArrayList<ShopDetailBean>();
				
				for (int i = 0; i < 1; i++) {
					  int number = random.nextInt(randomProductList.size());
					  ShopDetailBean randomPData = randomProductList.get(number);

					  if (!newProudctList.contains(randomPData)) {
						  newProudctList.add(randomPData);
					  } else {
					    i--;
					  }
					}
		
		m.addAttribute("selectRandomProduct", newProudctList);
		m.addAttribute("queryallproduct", list);
		return "SHOP_DETAIL/iSpanCarShopFront";
	}
	
	//具有分頁功能的主頁面---------
	@GetMapping("/iSpancarShop.ProductListAllShopPage.{pageNo}")
		public String processQueryAllShopPage(@PathVariable("pageNo") int pageNo, Model m) {
			//精選商品
			List<ShopDetailBean> randomProductList = service.findAll();
			Random random = new Random();
			
			ArrayList<ShopDetailBean> newProudctList = new ArrayList<ShopDetailBean>();
			
			for (int i = 0; i < 1; i++) {
				  int number = random.nextInt(randomProductList.size());
				  ShopDetailBean randomPData = randomProductList.get(number);

				  if (!newProudctList.contains(randomPData)) {
					  newProudctList.add(randomPData);
				  } else {
				    i--;
				  }
				}
			//分頁功能的部分
			int pageSize = 9;
		    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		    Page<ShopDetailBean> page = service.findAllByPage(pageable);

		    m.addAttribute("selectRandomProduct", newProudctList);
		    m.addAttribute("nowPage", pageNo);
		    m.addAttribute("totalPages", page.getTotalPages());
		    m.addAttribute("queryallproduct", page.getContent());

		    return "SHOP_DETAIL/iSpanCarShopFront";
		}
	
		
	//前台模糊搜尋功能---------
	@GetMapping("/iSpancarShop.SearchResultShopPage")
	public String processSearchResultShopPage(@RequestParam("productname") String productname,Model m) {
		List<ShopDetailBean> list = service.findByProductname(productname);
		
		m.addAttribute("queryallproduct",list);
		return "SHOP_DETAIL/iSpanCarShopFront";
	}
	
	//尚未實現的回傳筆數---------
//	@GetMapping("/iSpancarShop.SearchResultCount")
//	public String processSearchResultCount(@RequestParam("productname") String productname,Model m) {
//		List<ShopDetailBean> list = service.findByProductname(productname);
//		
//		m.addAttribute("queryallproduct",list);
//		return "SHOP_DETAIL/iSpanCarShopFront";
//	}
	
	//依據類型篩選產品---------	
	@GetMapping("/iSpancarShop.SearchByType")
	public String processSearchByType(@RequestParam("type") String type,Model m) {
		List<ShopDetailBean> list = service.findByType(type);
		
		//精選商品
		List<ShopDetailBean> randomProductList = service.findAll();
		Random random = new Random();
		
		ArrayList<ShopDetailBean> newProudctList = new ArrayList<ShopDetailBean>();
		
		for (int i = 0; i < 1; i++) {
			  int number = random.nextInt(randomProductList.size());
			  ShopDetailBean randomPData = randomProductList.get(number);

			  if (!newProudctList.contains(randomPData)) {
				  newProudctList.add(randomPData);
			  } else {
			    i--;
			  }
			}

		m.addAttribute("selectRandomProduct", newProudctList);
		m.addAttribute("queryallproduct",list);
		return "SHOP_DETAIL/iSpanCarShopFront";
	}
	
	//商品價格由低到高---------
	@GetMapping("/iSpancarShop.ProductListByLowPrice")
	public String processQueryByLowpriceAllShopPage(Model m) {
		
		List<ShopDetailBean> list = service.findByPriceLow();
		
		//精選商品
				List<ShopDetailBean> randomProductList = service.findAll();
				Random random = new Random();
				
				ArrayList<ShopDetailBean> newProudctList = new ArrayList<ShopDetailBean>();
				
				for (int i = 0; i < 1; i++) {
					  int number = random.nextInt(randomProductList.size());
					  ShopDetailBean randomPData = randomProductList.get(number);

					  if (!newProudctList.contains(randomPData)) {
						  newProudctList.add(randomPData);
					  } else {
					    i--;
					  }
					}
		
		m.addAttribute("selectRandomProduct", newProudctList);
		m.addAttribute("queryallproduct", list);
		return "SHOP_DETAIL/iSpanCarShopFront";
	}
	
	//商品價格由高到低---------
	@GetMapping("/iSpancarShop.ProductListByHighPrice")
	public String processQueryByHighPriceAllShopPage(Model m) {
		
		List<ShopDetailBean> list = service.findByPriceHigh();
		
		//精選商品
		List<ShopDetailBean> randomProductList = service.findAll();
		Random random = new Random();
		
		ArrayList<ShopDetailBean> newProudctList = new ArrayList<ShopDetailBean>();
		
		for (int i = 0; i < 1; i++) {
			int number = random.nextInt(randomProductList.size());
			ShopDetailBean randomPData = randomProductList.get(number);
			
			if (!newProudctList.contains(randomPData)) {
				newProudctList.add(randomPData);
			} else {
				i--;
			}
		}
		
		m.addAttribute("selectRandomProduct", newProudctList);
		m.addAttribute("queryallproduct", list);
		return "SHOP_DETAIL/iSpanCarShopFront";
	}
	
	
	
	
	//商品詳細頁面---------
	@GetMapping("/iSpancarShop.DetailShopPage")
	public String processDetailShopPage(@RequestParam("productname") String productname, Model m) {
		List<ShopDetailBean> list = service.findByProductname(productname);
		//抓取list當中的productno來完成Service的多圖
		int productno = list.get(0).getProductno();
//		int promductNumber = Integer.parseInt(productno);
		List<ShopDetailImgsBean> multiimgs = service.findMultiImgsByProductno(productno);
//		int imgsnoControllerTest = multiimgs.get(0).getImgsno();
//		System.out.println("CCCCCCCCCCCCCCCCCCCCImgsnoCCCCCCCCCimgsno=" + imgsnoControllerTest);
		
		//這邊取你喜歡的商品
		List<ShopDetailBean> randomProductList = service.findAll();
		Random random = new Random();
		
		ArrayList<ShopDetailBean> newProudctList = new ArrayList<ShopDetailBean>();
		
		for (int i = 0; i < 2; i++) {
			  int number = random.nextInt(randomProductList.size());
			  ShopDetailBean randomPData = randomProductList.get(number);

			  if (!newProudctList.contains(randomPData)) {
				  newProudctList.add(randomPData);
			  } else {
			    i--;
			  }
			}
		m.addAttribute("productdetail",list);
		m.addAttribute("multiimgs",multiimgs);
		m.addAttribute("selectRandomProduct", newProudctList);
		return "SHOP_DETAIL/iSpanCarShopFrontDetail";
	}
	
//	//前台分頁666---------
//	@GetMapping("/queryByPage/{pageNo}")
//	@ResponseBody
//	public Page<ShopDetailBean> processQueryByPageAction(@PathVariable("pageNo") int pageNo){
//		int pageSize = 9;
//		Pageable pageable = PageRequest.of(pageNo-1, pageSize, Sort.Direction.DESC, "price");
//		Page<ShopDetailBean> page = service.findAllByPage(pageable);
//	
//		return page;
//	}
	
	//圖片---------
	@GetMapping("productimgfront.controller")
	@ResponseBody
	public byte[] processProductImgAction(@RequestParam("productno") String productno) {
		try {
			System.out.println("----------------controllercontrollercontrollercontroller-------------");
			ShopDetailBean sBean = service.findImgByProductno(productno);
			System.out.println("----------------OUTOUTOUTcontrollercontrollercontrollercontroller-------------");
			InputStream is = sBean.getProductimage().getBinaryStream();
			
			return IOUtils.toByteArray(is);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//多圖取出
	@GetMapping("/showMultiImgesF.controller/{imgsno}")
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

	
	//快速測試用---------
	@GetMapping("/iSpancarShop.rtrtr")
	public String forward2() {
		return "forward:/WEB-INF/jsp/Cart/cartMaybe.jsp";
	}
	
}
        


