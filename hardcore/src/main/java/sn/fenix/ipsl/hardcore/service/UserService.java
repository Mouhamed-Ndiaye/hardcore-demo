package sn.fenix.ipsl.hardcore.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sn.fenix.ipsl.hardcore.model.UserModel;
import sn.fenix.ipsl.hardcore.repository.UserModelRepository;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class UserService {

    @Autowired
    private UserModelRepository userModelRepository;



    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public List<UserModel> getUsers() {
        return userModelRepository.findAll();
    }

    public Optional<UserModel> getUser(final Long id) {
        return userModelRepository.findById(id);
    }

    public UserModel saveUser(UserModel userModel){
        String encodedPassword = passwordEncoder().encode(userModel.getPasswordUser());
        userModel.setPasswordUser(encodedPassword);
        return userModelRepository.save(userModel);
    }

    public void deleteUser(final Long idUser){
        userModelRepository.deleteById(idUser);
    }

    public Optional<UserModel> getUserByEmail(String email) {
        return userModelRepository.findByEmail(email);
    }


}
