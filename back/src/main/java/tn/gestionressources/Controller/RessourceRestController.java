package tn.gestionressources.Controller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.gestionressources.Entities.Ressource;
import tn.gestionressources.Repository.RessourceRepository;
import tn.gestionressources.Services.IRessourceService;

import java.util.List;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/Ressource")
public class RessourceRestController {
    IRessourceService RessourceService;
    // http://localhost:8089/Gestion-ressources/Ressource/retrieve-all-Ressources
    @GetMapping("/retrieve-all-Ressources")
    public List<Ressource> getRessources() {
        List<Ressource> listRessources = RessourceService.retrieveAllRessources();
        return listRessources;
    }
    // http://localhost:8089/Gestion-ressources/Ressource/retrieve-Ressource/8
    @GetMapping("/retrieve-Ressource/{idRessource}")
    public Ressource retrieveRessource(@PathVariable("idRessource") Long chId) {
        Ressource Ressource = RessourceService.retrieveRessource(chId);
        return Ressource;
    }
    // http://localhost:8089/Gestion-ressources/Ressource/add-Ressource
    @PostMapping("/add-Ressource")
    public Ressource addRessource(@RequestBody Ressource b) {
        Ressource Ressource = RessourceService.addRessource(b);
        return Ressource;
    }
    // http://localhost:8089/Gestion-ressources/Ressource/remove-Ressource/{Ressource-id}
    @DeleteMapping("/remove-Ressource/{idRessource}")
    public void removeRessource(@PathVariable("idRessource") Long chId) {
        RessourceService.removeRessource(chId);
    }
    // http://localhost:8089/Gestion-ressources/Ressource/modify-Ressource
    @PutMapping("/modify-Ressource")
    public Ressource modifyRessource(@RequestBody Ressource b) {
        Ressource Ressource = RessourceService.modifyRessource(b);
        return Ressource;
    }

}
