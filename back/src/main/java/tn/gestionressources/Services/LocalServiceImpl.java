package tn.gestionressources.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.gestionressources.Entities.Local;
import tn.gestionressources.Repository.LocalRepository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class LocalServiceImpl implements ILocalService{
   LocalRepository LocalRepository;

    @Override
    public List<Local> GetAll() {
        return LocalRepository.findAll();
    }

    @Override
    public Local GetOne(Long idLocal) {
        return LocalRepository.findById(idLocal).get();
    }

    @Override
    public Local Add(Local l) {
        return LocalRepository.save(l);
    }

    @Override
    public void Delete(Long idLocal) {
        LocalRepository.deleteById(idLocal);
    }

    @Override
    public Local Update(Local Local) {
        return LocalRepository.save(Local);
    }


    @Override
    public List<Local> AllAvliableLocal() {
        List<Local> locals = LocalRepository.findAll();
        List<Local> locals_avaliables = new ArrayList<>();
        for (Local local : locals) {
            if (local.getAvailability() == Boolean.TRUE){
                locals_avaliables.add(local);
            }
        }
        return locals_avaliables;
    }


    public Map<Long,Integer> getstatsalle() {
        Map<Long, Integer> stats = new HashMap<>();
        List<Local> locals = LocalRepository.findAll();
        for (Local local : locals) {
            stats.put(local.getIdLocal(), local.getTotal_group_study());
        }
        return stats;
    }

    @Override
    public Map<String, Integer> getavaliablesstats() {
        int dispo = 0;
        int not_dispo = 0;
        Map<String, Integer> stats = new HashMap<>();
        List<Local> locals = LocalRepository.findAll();
        for (Local local : locals) {
            if(local.getAvailability() == Boolean.TRUE)
                dispo++;
            else
                not_dispo++;
        }
        stats.put("avliables",dispo);
        stats.put("not avliables",not_dispo);
        return stats;
    }
    public List<String> getAllLocalNames() {
        List<Local> locals = LocalRepository.findAll();
        List<String> localNames = new ArrayList<>();
        for (Local local : locals) {
            localNames.add(local.getName());
        }
        return localNames;
    }
    @Override
    public Long getIdByName(String name) {
        Local local = LocalRepository.findByName(name);
        if (local != null) {
            return local.getIdLocal();
        } else {
            return null;
        }
    }
}
