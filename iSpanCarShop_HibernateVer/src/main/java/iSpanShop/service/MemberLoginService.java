package iSpanShop.service;

import iSpanShop.model.Member;
import iSpanShop.model.MemberDao;

public class MemberLoginService {
	
	private MemberDao mDao;
	
	public MemberLoginService() {
		this.mDao = new MemberDao();
	}
	
	public Member checkLogin(String username, String pwd) {
		Member member = mDao.findByNameAndPwd(username, pwd);
		
		if( member!= null) {
			return member;
		}
		
		return null;
	}

}
