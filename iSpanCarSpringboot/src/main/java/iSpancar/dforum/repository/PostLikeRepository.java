package iSpancar.dforum.repository;

import iSpancar.dforum.model.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Integer> {

	PostLike findFirstByDataIdAndTypeAndLikedAndMember(Integer dataId, Integer type, Integer liked, String member);

	List<PostLike> findPostLikeByDataIdAndTypeAndMember(Integer dataId, Integer type, String member);
}
