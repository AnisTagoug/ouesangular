package tn.gestionressources.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.gestionressources.Entities.Local;
import tn.gestionressources.Services.ILocalService;


import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/Local")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

public class LocalRestController {
    ILocalService LocalService;
    @GetMapping("")
    public List<Local> GetAll() {
        List<Local> listLocal = LocalService.GetAll();
        return listLocal;
    }

    @GetMapping("/{Local-id}")
    public Local GetOne(@PathVariable("Local-id") Long LId) {
        Local Local = LocalService.GetOne(LId);
        return Local;
    }

    @PostMapping("")
    public Local Add(@RequestBody Local l) {
        Local Local = LocalService.Add(l);
        return Local;
    }

    @DeleteMapping("/{Local-id}")
    public void Delete (@PathVariable("Local-id") Long LId) {
        LocalService.Delete(LId);
    }
    @PutMapping("/update")
    public Local Update(@RequestBody Local l) {
        Local Local = LocalService.Update(l);
        return Local;
    }

    @GetMapping("/avliables")
    public List<Local> AllAvliableLocal() {
        List<Local> listLocal = LocalService.AllAvliableLocal();
        return listLocal;
    }

    @GetMapping("/stats")
    public Map<Long,Integer> stats() {
        Map<Long,Integer> stats = LocalService.getstatsalle();
        return stats;
    }

    @GetMapping("/stats_avliables")
    private Map<String,Integer> stats_avliables() {
        Map<String ,Integer> stats = LocalService.getavaliablesstats();
        return stats;
    }
    @GetMapping("/names")
    public List<String> getAllLocalNames() {
        List<String> localNames = LocalService.getAllLocalNames();
        return localNames;
    }
    @GetMapping("/idByName/{name}")
    public Long getIdByName(@PathVariable("name") String name) {
        return LocalService.getIdByName(name);
    }
}
