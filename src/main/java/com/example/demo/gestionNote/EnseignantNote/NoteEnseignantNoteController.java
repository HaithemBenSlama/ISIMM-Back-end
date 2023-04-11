package com.example.demo.gestionNote.EnseignantNote;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public void addNotesSection( @RequestBody NotesRequest<ObjectNoteSection> request){
        noteEnseignantServices.addNotesSection(request);

    }

    @PostMapping(path = "/addNotesTd",consumes = "application/json")
    public void addNotesTd( @RequestBody NotesRequest<ObjectNoteTd> request){
        noteEnseignantServices.addNotesTd(request);
    }

    @PostMapping(path = "/addNotesTp",consumes = "application/json")
    public void addNotesTp( @RequestBody NotesRequest<ObjectNoteTp> request){
        noteEnseignantServices.addNotesTp(request);
    }
}

class ObjectNoteTd{
    private String cinEtudiant;
    private Long idEtudiant;
    private Long idNote;
    private Float noteOral;
    private String nomEtudiant;
    private String prenomEtudiant;
    private int typeNote;

    public String getCinEtudiant() {
        return cinEtudiant;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public Long getIdNote() {
        return idNote;
    }

    public Float getNoteOral() {
        return noteOral;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public int getTypeNote() {
        return typeNote;
    }

    @Override
    public String toString() {
        return "ObjectNoteTd{" +
                "cinEtudiant='" + cinEtudiant + '\'' +
                ", idEtudiant=" + idEtudiant +
                ", idNote=" + idNote +
                ", noteOral=" + noteOral +
                ", nomEtudiant='" + nomEtudiant + '\'' +
                ", prenomEtudiant='" + prenomEtudiant + '\'' +
                ", typeNote=" + typeNote +
                '}';
    }
}

class ObjectNoteTp{
    private String cinEtudiant;
    private Long idEtudiant;
    private Long idNote;
    private String noteTp;
    private String nomEtudiant;
    private String prenomEtudiant;
    private int typeNote;

    public String getCinEtudiant() {
        return cinEtudiant;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public Long getIdNote() {
        return idNote;
    }

    public String getNoteTp() {
        return noteTp;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public int getTypeNote() {
        return typeNote;
    }

    @Override
    public String toString() {
        return "ObjectNoteTp{" +
                "cinEtudiant='" + cinEtudiant + '\'' +
                ", idEtudiant=" + idEtudiant +
                ", idNote=" + idNote +
                ", noteTp=" + noteTp +
                ", nomEtudiant='" + nomEtudiant + '\'' +
                ", prenomEtudiant='" + prenomEtudiant + '\'' +
                ", typeNote=" + typeNote +
                '}';
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