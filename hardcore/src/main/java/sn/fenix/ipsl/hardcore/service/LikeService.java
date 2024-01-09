package sn.fenix.ipsl.hardcore.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.fenix.ipsl.hardcore.model.Document;
import sn.fenix.ipsl.hardcore.model.Like;
import sn.fenix.ipsl.hardcore.model.UserModel;
import sn.fenix.ipsl.hardcore.repository.LikeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;
    public boolean userLikedDocument(UserModel userModel, Document document) {
        return likeRepository.findByUserModelAndDocument(userModel, document).isPresent();
    }

    public void likeDocument(UserModel userModel, Document document) {
        if (!userLikedDocument(userModel, document)) {
            Like like = new Like();
            like.setUserModel(userModel);
            like.setDocument(document);
            like.setLikedAt(LocalDateTime.now());
            likeRepository.save(like);
        }
    }

    public int getLikesCount(Document document) {
        return likeRepository.findAllByDocument(document).size();
    }

    public List<UserModel> getUsersWhoLikedDocument(Document document) {
        List<Like> likes = likeRepository.findAllByDocument(document);
        return likes.stream().map(Like::getUserModel).collect(Collectors.toList());
    }
}
