package tn.gestionressources.Entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Studygroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idGroup;
    @JsonFormat(pattern="yyyy-MM-dd")
    Date date_debut;
    String Topic;
    Level level;
    String location;
    @ManyToMany(mappedBy = "Studygroups",cascade = CascadeType.ALL)
    private Set<Ressource> Ressources;
}
