package sn.fenix.ipsl.hardcore.repository;
import sn.fenix.ipsl.hardcore.model.Document;
import sn.fenix.ipsl.hardcore.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.fenix.ipsl.hardcore.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserModelAndDocument(UserModel userModel, Document document);

    List<Like> findAllByDocument(Document document);

}