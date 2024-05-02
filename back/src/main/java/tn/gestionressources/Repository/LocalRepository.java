package tn.gestionressources.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.gestionressources.Entities.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {
    Local findByName(String name);

}
