package iSpancar.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import iSpancar.member.model.MemberBean;
import iSpancar.member.model.MemberLoginDate;

public interface LoginDateRepository extends JpaRepository<MemberLoginDate, Integer> {
	
	public MemberLoginDate findByMemberloginbean(MemberBean memberBean);
	
	@Modifying
	@Query(value = "delete from memberlogindate where accountnumber = ?1",nativeQuery = true)
	public void deleteByAccountNumber(String accountNumber);
}
