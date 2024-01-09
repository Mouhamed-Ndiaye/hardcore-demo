package sn.fenix.ipsl.hardcore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommentaire;

    private String contenu;

    private LocalDateTime dateCommentaire = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_model_id")
    private UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

}
