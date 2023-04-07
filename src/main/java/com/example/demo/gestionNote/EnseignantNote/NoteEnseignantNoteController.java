package com.example.demo.gestionNote.EnseignantNote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/chargeNote/EnseignantNote")
public class NoteEnseignantNoteController {

    private final NoteEnseignantServices noteEnseignantServices;

    @Autowired
    public NoteEnseignantNoteController(NoteEnseignantServices noteEnseignantServices) {
        this.noteEnseignantServices = noteEnseignantServices;
    }

    @GetMapping(path="/{group_type}/{id_enseignant}/{group_id}/{id_semestre}/{id_matiere}")
    public List<Map<String,Object>> getSectionAndClasses(@PathVariable("group_type") int type,
                                                         @PathVariable("id_enseignant") Long userId,
                                                         @PathVariable("group_id") Long groupId,
                                                         @PathVariable("id_semestre") Long semId,
                                                         @PathVariable("id_matiere") Long matiereId) {
        return noteEnseignantServices.getListeStudentAndNotes(type,userId,groupId,semId,matiereId);
    }
}
