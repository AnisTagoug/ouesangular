package tn.gestionressources.Services;

import tn.gestionressources.Entities.Ressource;
import tn.gestionressources.Repository.RessourceRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RessourceServiceImpl implements IRessourceService{
    RessourceRepository RessourceRepository;
    @Override
    public List<Ressource> retrieveAllRessources() {
        return RessourceRepository.findAll();
    }

    @Override
    public Ressource retrieveRessource(Long idRessource) {
        return RessourceRepository.findById(idRessource).get();
    }

    @Override
    public Ressource addRessource(Ressource b) {
        return RessourceRepository.save(b);
    }

    @Override
    public void removeRessource(Long idRessource) {
        RessourceRepository.deleteById(idRessource);
    }

    @Override
    public Ressource modifyRessource(Ressource Ressource) {
        return RessourceRepository.save(Ressource);
    }
}
