package cart.service;

import java.util.List;

import cart.model.CartBean;
import cart.model.CartDao;


public class CartService {


	private CartDao cDao;
	
	public CartService() {
		this.cDao=new CartDao();
	}
	
	public  List<CartBean>  findAllById(String memberId) {
		List<CartBean> list= cDao.findAllById(memberId);
		return list;
	}
	
	public  List<CartBean> findAllCart()  {
		 List<CartBean> allCart= cDao.findAllCart();
		return allCart;
	}
	
	public CartBean insertCartBean(CartBean ctBean) {
		CartBean cartBean= cDao.insertCartBean(ctBean);
		return cartBean;

	}
	
	public void deletecartById(String cartId) {
		 cDao.deletecartById(cartId);
	}
	
	public void deleteCartByMemberId(String memberId) {
		cDao.deleteCartByMemberId(memberId);
	}
	
	public void updateQuantityByCartId(String quantity, String cartId) {
		cDao.updateQuantityByCartId(quantity,cartId);
	}
}
