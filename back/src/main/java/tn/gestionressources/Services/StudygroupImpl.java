package tn.gestionressources.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.gestionressources.Entities.Studygroup;
import tn.gestionressources.Repository.StudygroupRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudygroupImpl implements IStudygroupService {
    StudygroupRepository studygroupRepository;


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
}