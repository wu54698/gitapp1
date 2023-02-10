package tw.hibernatedemo.service;

import tw.hibernatedemo.model.Member;
import tw.hibernatedemo.model.MemberDao;

public class MemberLoginService {
	
	private MemberDao mDao;
	
	public MemberLoginService() {
		this.mDao = new MemberDao();
	}
	
	public Member checkLogin(String username, String pwd) {
		Member member = mDao.findByNameAndPwd(username, pwd);
		
		if( member != null ) {
			return member;
		}
		return null;
	}
	
	
}
