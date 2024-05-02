package tn.gestionressources.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idLocal;
    String name;
    Character Bloc;
    Boolean Availability =Boolean.TRUE;
    Integer Capacity;
    Integer total_group_study = 0;

    @JsonIgnore
    @OneToMany(mappedBy= "local")
    Set<Studygroup> studygroups;

}
