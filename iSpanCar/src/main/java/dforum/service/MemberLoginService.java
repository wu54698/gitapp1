package dforum.service;

import dforum.model.ForumMember;
import dforum.model.DforumMemberDao;

public class MemberLoginService {
	
	private DforumMemberDao mDao;
	
	public MemberLoginService() {
		this.mDao = new DforumMemberDao();
	}
	
	public ForumMember checkLogin(String username, String pwd) {
		ForumMember member = mDao.findByNameAndPwd(username, pwd);
		
		if( member!= null) {
			return member;
		}
		
		return null;
	}

}
