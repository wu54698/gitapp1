package iSpancar.cart.service;

import java.util.List;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iSpancar.cart.model.CartBean;
import iSpancar.cart.model.CartDao;
import iSpancar.cart.model.CartRepository;

@Service
//@TransactionScoped
@Transactional
public class CartService {

	@Autowired
	private CartRepository cRepo;
	

	public  List<CartBean>  findAllById(String memberId) {
		List<CartBean> list= cRepo.findAllById(memberId);
		return list;
	}
	
	public  List<CartBean> findAllCart()  {
		 List<CartBean> allCart= cRepo.findAll();
		return allCart;
	}
	
	public CartBean insertCartBean(CartBean ctBean) {
		CartBean cartBean= cRepo.save(ctBean);
		return cartBean;

	}
	
	public void deletecartById(String cartId) {
		cRepo.deleteById(cartId);
	}
	
	public void deleteCartByMemberId(String memberId) {
		cRepo.deleteByMemberId(memberId);
	}
	
	public void updateQuantityByCartId(String quantity, String cartId) {
		cRepo.updateQuantityByCartId(quantity,cartId);
	}
	
	
}
