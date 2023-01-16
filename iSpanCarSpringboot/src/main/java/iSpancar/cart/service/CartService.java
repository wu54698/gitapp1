package iSpancar.cart.service;

import java.util.List;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iSpancar.cart.model.CartBean;
import iSpancar.cart.model.CartDao;

@Service
@TransactionScoped
public class CartService {

	@Autowired
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
