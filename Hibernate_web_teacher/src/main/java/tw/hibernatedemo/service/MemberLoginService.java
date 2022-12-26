package tw.hibernatedemo.service;

import tw.hibernatedemo.model.ForumMember;
import tw.hibernatedemo.model.MemberDao;

public class MemberLoginService {
	
	private MemberDao mDao;
	
	public MemberLoginService() {
		this.mDao = new MemberDao();
	}
	
	public ForumMember checkLogin(String username, String pwd) {
		ForumMember member = mDao.findByNameAndPwd(username, pwd);
		
		if( member!= null) {
			return member;
		}
		
		return null;
	}

}
