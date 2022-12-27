package dforum.service;

import dforum.model.ForumMember;
import dforum.model.MemberDao;

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
