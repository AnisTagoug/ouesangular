package tn.gestionressources.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.gestionressources.Entities.Ressource;
import tn.gestionressources.Entities.Studygroup;
import tn.gestionressources.Services.IStudygroupService;

import java.util.List;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/Studygroup")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

public class StudyGroupRestController {
    IStudygroupService studygroupService;
    @GetMapping("/retrieve-all-StudyGroup")
    public List<Studygroup> getStudyGroup() {
        List<Studygroup> studygroupList = studygroupService.getAllStudyGroup();
        return studygroupList;
    }
    @GetMapping("/retrieve-studygroup/{studygroup-id}")
        public Studygroup getStudygroupById(@PathVariable("studygroup-id") Long studgroupid) {
        Studygroup studygroup = studygroupService.getStudygroupById(studgroupid);
        return studygroup;
    }
    @PostMapping("/addStudyGroup")
    public Studygroup addStudygroup(@RequestBody  Studygroup studygroup){
        Studygroup  studyGroup = studygroupService.addStudyGroup(studygroup);
        return studyGroup;
    }
    @DeleteMapping("/remove-studygroup/{studygroup-id}")
    public void removeStudygroup(@PathVariable("studygroup-id") Long s){
        studygroupService.deleteStudyGroup(s);
    }

    @PutMapping("/modify-studygroup/{idGroup}")
    public ResponseEntity<?> update(@PathVariable("idGroup") Long sid, @RequestBody Studygroup updateSession) {
        Studygroup session = studygroupService.updateStudygroup(sid, updateSession);
        if (session != null) {
            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune session trouvée avec l'ID : " + sid);
        }
    }
    @PutMapping("/increment-nbp/{studygroup-id}")
    public ResponseEntity<?> incrementNbpIfUnderFive(@PathVariable("studygroup-id") Long studygroupId) {
        Studygroup updatedStudygroup = studygroupService.incrementNbpIfUnderFive(studygroupId);
        if (updatedStudygroup != null) {
            return ResponseEntity.ok(updatedStudygroup);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Studygroup not found or nbp cannot be incremented.");
        }
    }
    @PostMapping("/create-studygroup-with-local/{local-id}")
    public ResponseEntity<?> createStudygroupWithLocal(@RequestBody Studygroup studygroup, @PathVariable("local-id") Long localId) {
        Studygroup createdStudygroup = studygroupService.createStudygroupWithLocal(studygroup, localId);
        if (createdStudygroup != null) {
            return ResponseEntity.ok(createdStudygroup);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Local not found or studygroup could not be created with the given local ID.");
        }
    }
    @GetMapping("/names")
    public List<String> getAllLocalNames() {
        List<String> localNames = studygroupService.getAllStudyNames();
        return localNames;
    }
}
