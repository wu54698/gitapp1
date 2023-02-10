package iSpancar.dforum.repository;

import iSpancar.dforum.model.PostMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostMain, Integer>, JpaSpecificationExecutor<PostMain> {

	PostMain findFirstByUuidAndIsOP(String uuid, Boolean op);

	int countByUuid(String uuid);

	List<PostMain> findPostMainByUuid(String uuid);
}
