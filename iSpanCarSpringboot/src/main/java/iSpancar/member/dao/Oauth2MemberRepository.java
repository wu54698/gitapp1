package iSpancar.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import iSpancar.member.model.Oauth2MemberBean;

public interface Oauth2MemberRepository extends JpaRepository<Oauth2MemberBean,String>{
	
	
	
}
