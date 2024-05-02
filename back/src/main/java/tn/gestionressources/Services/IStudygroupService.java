package tn.gestionressources.Services;

import tn.gestionressources.Entities.Studygroup;

import java.util.List;

public interface IStudygroupService {
    Studygroup addStudyGroup(Studygroup studygroup);

    List<Studygroup> getAllStudyGroup();

    Studygroup getStudygroupById(long idStudyGroup);

    void deleteStudyGroup(long isStudygroup);

    Studygroup updateStudygroup(Long id,Studygroup studygroup);
    public Studygroup incrementNbpIfUnderFive(long idStudyGroup);
    public Studygroup createStudygroupWithLocal(Studygroup studygroup, long localId);
    public List<String> getAllStudyNames();
}
