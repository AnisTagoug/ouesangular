package tn.gestionressources.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.gestionressources.Entities.Ressource;

public interface RessourceRepository extends JpaRepository<Ressource,Long> {
}
