package iSpancar.member.dao;

import java.sql.Blob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import iSpancar.member.model.MemberBean;

public interface MemberRepository extends JpaRepository<MemberBean, String> {

	public MemberBean findByAccountnumberAndMemberpassword(String accountnumber,String memberpassword);
	
	//修改刪除須加上此註釋
	@Modifying
	@Query(value = "delete from memberposition where accountnumberposition = ?1",nativeQuery = true)
	public void deleteMemberPosition(String accountnumberposition);
}
