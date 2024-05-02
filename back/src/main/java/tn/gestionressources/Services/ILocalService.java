package tn.gestionressources.Services;


import tn.gestionressources.Entities.Local;

import java.util.List;
import java.util.Map;

public interface ILocalService {
    public List<Local> GetAll();

    public Local GetOne(Long idLocal);

    public Local Add(Local l);

    public void Delete(Long idLocal);

    public Local Update(Local Local);

    public List<Local> AllAvliableLocal();

    public Map<Long,Integer> getstatsalle();

    public  Map<String,Integer> getavaliablesstats();
    public List<String> getAllLocalNames();
    public Long getIdByName(String name);
}
