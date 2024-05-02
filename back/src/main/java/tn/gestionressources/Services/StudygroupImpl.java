package tn.gestionressources.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.gestionressources.Entities.Local;
import tn.gestionressources.Entities.Studygroup;
import tn.gestionressources.Repository.LocalRepository;
import tn.gestionressources.Repository.StudygroupRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudygroupImpl implements IStudygroupService {
    StudygroupRepository studygroupRepository;
    LocalRepository localRepository;

    @Override
    public Studygroup addStudyGroup(Studygroup studygroup) {
        return studygroupRepository.save(studygroup);
    }

    @Override
    public List<Studygroup> getAllStudyGroup() {
        return (List<Studygroup>) studygroupRepository.findAll() ;
    }

    @Override
    public Studygroup getStudygroupById(long idStudyGroup) {
        return studygroupRepository.findById(idStudyGroup).get();
    }

    @Override
    public void deleteStudyGroup(long idStudyGroup) {
        studygroupRepository.deleteById(idStudyGroup);

    }


    @Override
    public Studygroup updateStudygroup(Long id ,Studygroup studygroup)  {
        Optional<Studygroup> optUpdate = studygroupRepository.findById(id);
        if (optUpdate.isPresent()){
            Studygroup sessioExist = optUpdate.get();
            sessioExist.setTopic(studygroup.getTopic());
            sessioExist.setDate_debut(studygroup.getDate_debut());
            sessioExist.setLocation(studygroup.getLocation());

            return studygroupRepository.save(sessioExist);

        }else {
            return  null;
        }

    }
    @Override
    public Studygroup incrementNbpIfUnderFive(long idStudyGroup) {
        Optional<Studygroup> optionalStudygroup = studygroupRepository.findById(idStudyGroup);
        if (optionalStudygroup.isPresent()) {
            Studygroup studygroup = optionalStudygroup.get();
            if (studygroup.getNbp() < 5) {
                studygroup.setNbp(studygroup.getNbp() + 1);
                return studygroupRepository.save(studygroup);
            }
        }
        return null; // or throw an exception if needed
    }
    @Override
    public Studygroup createStudygroupWithLocal(Studygroup studygroup, long localId) {
        Optional<Local> optionalLocal = localRepository.findById(localId);
        if (optionalLocal.isPresent()) {
            Local local = optionalLocal.get();
            studygroup.setLocal(local);
            local.getStudygroups().add(studygroup);
            return studygroupRepository.save(studygroup);
        } else {
            // Handle the case where the Local with the given ID does not exist
            return null;
        }
    }
    @Override
    public List<String> getAllStudyNames() {
        List<Studygroup> locals = studygroupRepository.findAll();
        List<String> localNames = new ArrayList<>();
        for (Studygroup local : locals) {
            localNames.add(local.getTopic());
        }
        return localNames;
    }
}
