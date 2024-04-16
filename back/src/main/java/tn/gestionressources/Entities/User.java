package tn.gestionressources.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUser;
    String nom;
    String prenom;
    String mail;
    Long num_tel;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Ressource>Ressources;
}
