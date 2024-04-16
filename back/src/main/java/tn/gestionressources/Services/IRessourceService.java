package tn.gestionressources.Services;

import tn.gestionressources.Entities.Ressource;

import java.util.List;

public interface IRessourceService {
    public List<Ressource> retrieveAllRessources();
    public Ressource retrieveRessource(Long idRessource);
    public Ressource addRessource(Ressource b);
    public void removeRessource(Long idRessource);
    public Ressource modifyRessource(Ressource Ressource);
}
