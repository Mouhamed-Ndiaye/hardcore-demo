package sn.fenix.ipsl.hardcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.fenix.ipsl.hardcore.model.UserModel;

import java.util.Optional;

public interface UserModelRepository extends JpaRepository<UserModel, Long>  {

    Optional<UserModel> findByEmail(String email);



}
