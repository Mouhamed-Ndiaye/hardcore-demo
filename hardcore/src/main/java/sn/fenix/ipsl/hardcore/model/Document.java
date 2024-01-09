package sn.fenix.ipsl.hardcore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocument;

    private String titre;

    private String description;

    @Column(unique = true,nullable = false)
    private String fileName;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Enumerated(EnumType.STRING)
    private Filiere filiere;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    private LocalDateTime dateDocument = LocalDateTime.now();


}
