package tn.gestionressources.Entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Enumerated(EnumType.STRING)
    Level level;
    @Enumerated(EnumType.STRING)
    Bloc bloc;
    String location;
    int nbp;
    @Enumerated(EnumType.STRING)
    Status status = Status.Waiting;
    @ManyToMany(mappedBy = "Studygroups",cascade = CascadeType.ALL)
    private Set<Ressource> Ressources;
    @ManyToOne
    @JoinColumn(name = "local_id_local")
    private Local local;
}
