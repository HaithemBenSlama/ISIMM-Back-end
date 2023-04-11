package com.example.demo.gestionNote.EnseignantNote;


import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/isimm/chargeNote/EnseignantNote")
@CrossOrigin("*")
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
    public void addNotesSection( @RequestBody NotesRequest<ObjectNoteSection> request) throws MessagingException {
        noteEnseignantServices.addNotesSection(request);

    }

    @PostMapping(path = "/addNotesTd",consumes = "application/json")
    public void addNotesTd( @RequestBody NotesRequest<ObjectNoteTd> request) throws MessagingException {
        noteEnseignantServices.addNotesTd(request);
    }

    @PostMapping(path = "/addNotesTp",consumes = "application/json")
    public void addNotesTp( @RequestBody NotesRequest<ObjectNoteTp> request) throws MessagingException {
        noteEnseignantServices.addNotesTp(request);
    }
}

class ObjectNoteTd{
    private Long idEtudiant;
    private Long idNote;
    private Float noteOral;


    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public Long getIdNote() {
        return idNote;
    }

    public Float getNoteOral() {
        return noteOral;
    }

}

class ObjectNoteTp{
    private Long idEtudiant;
    private Long idNote;
    private Float noteTp;


    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public Long getIdNote() {
        return idNote;
    }

    public Float getNoteTp() {
        return noteTp;
    }





}
class ObjectNoteSection{
    private Long idEtudiant;
    private Long idNoteDs;
    private Long idNoteExam;
    private Float noteDs;
    private Float noteExam;


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



}
class NotesRequest <T>{
    private Long idEnseignant;
    private Long idMatiere;
    private int typeGroup;
    private T[] list;
    private Long idSemestre;

    public Long getIdSemestre(){
        return idSemestre;
    }

    public Long getIdEnseignant() {
        return idEnseignant;
    }

    public Long getIdMatiere() {
        return idMatiere;
    }

    public int getTypeGroup() {
        return typeGroup;
    }

    public T[] getList() {
        return list;
    }


    @Override
    public String toString() {
        return "NotesRequest{" +
                "idEnseignant=" + idEnseignant +
                ", idMatiere=" + idMatiere +
                ", typeGroup=" + typeGroup +
                ", list=" + Arrays.toString(list) +
                ", idSemestre=" + idSemestre +
                '}';
    }
}