package tn.gestionressources.Repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.gestionressources.Entities.Studygroup;

public interface StudygroupRepository extends JpaRepository<Studygroup, Long> {
}
