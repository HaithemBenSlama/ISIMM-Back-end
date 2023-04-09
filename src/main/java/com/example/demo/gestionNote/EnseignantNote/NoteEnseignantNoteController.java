package com.example.demo.gestionNote.EnseignantNote;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/isimm/chargeNote/EnseignantNote")
@CrossOrigin
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

    @PostMapping(path = "/addNotesSection",consumes = "application/json")
    public void registerReclamation( @RequestBody NotesRequest request){
        for (ObjectNoteSection e:request.getList()){
            System.out.println(e.toString());
        }
    }
}

class ObjectNoteSection{
    private String cinEtudiant;
    private Long idEtudiant;
    private Long idNoteDs;
    private Long idNoteExam;
    private Float noteDs;
    private Float noteExam;
    private String nomEtudiant;
    private String prenomEtudiant;

    public String getCinEtudiant() {
        return cinEtudiant;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public Long getIdNoteDs() {
        return idNoteDs;
    }

    public Long getIdNoteExam() {
        return idNoteExam;
    }

    public Float getNoteDs() {
        return noteDs;
    }

    public Float getNoteExam() {
        return noteExam;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    @Override
    public String toString() {
        return "ObjectNoteSection{" +
                "cinEtudiant='" + cinEtudiant + '\'' +
                ", idEtudiant=" + idEtudiant +
                ", idNoteDs=" + idNoteDs +
                ", idNoteExam=" + idNoteExam +
                ", noteDs=" + noteDs +
                ", noteExam=" + noteExam +
                ", nomEtudiant='" + nomEtudiant + '\'' +
                ", prenomEtudiant='" + prenomEtudiant + '\'' +
                '}';
    }
}
class NotesRequest {
    private Long idEnseignant;
    private Long idMatiere;
    private int typeGroup;
    private ObjectNoteSection[] list;

    public Long getIdEnseignant() {
        return idEnseignant;
    }

    public Long getIdMatiere() {
        return idMatiere;
    }

    public int getTypeGroup() {
        return typeGroup;
    }

    public ObjectNoteSection[] getList() {
        return list;
    }
}