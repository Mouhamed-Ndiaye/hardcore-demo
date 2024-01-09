package sn.fenix.ipsl.hardcore.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String firstName;
    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordUser;

    @Enumerated(EnumType.STRING)
    private Universite universite;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;



}
