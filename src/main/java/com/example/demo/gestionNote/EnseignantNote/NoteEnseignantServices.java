package com.example.demo.gestionNote.EnseignantNote;

import com.example.demo.Doa.*;
import com.example.demo.entities.*;
import com.example.demo.entities.enums.TypeDevoir;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.*;

@Service
@AllArgsConstructor
public class NoteEnseignantServices {
    private final NoteRepository noteRepository;
    private final MatiereRepository matiereRepository;
    private final EnseignantRepository enseignantRepository;
    private final EtudiantRepository etudiantRepository;
    private final SemestreRepository semestreRepository;
    public List<Map<String,Object>> getListeStudentAndNotes(int type,Long id_enseignant,Long group_id, Long id_semestre, Long id_matiere) {
        List<Map<String,Object>> s;
        if(type==2)
            s= noteRepository.noteFindListeEtudiantAndNotesForTp(id_enseignant,group_id,id_semestre,id_matiere);
        else if (type==1) {
            s=noteRepository.noteFindListeEtudiantAndNotesForTd(id_enseignant,group_id,id_semestre,id_matiere);
        } else
            s=noteRepository.noteFindListeEtudiantAndNotesForSection(id_enseignant,group_id,id_semestre,id_matiere);

        return s;
    }

    public void registerReclamation(NotesRequest request){

    }

    public void addNotesTp(NotesRequest<ObjectNoteTp> request) {
        Enseignant enseignant = enseignantRepository.findById(request.getIdEnseignant()).orElse(null);
        Matiere matiere = matiereRepository.findById(request.getIdMatiere()).orElse(null);
        Semestre semestre = semestreRepository.findById(request.getIdSemestre()).orElse(null);

        for (ObjectNoteTp e:request.getList()){
            Etudiant etudiant = etudiantRepository.findById(e.getIdEtudiant()).orElse(null);

            if(e.getNoteTp() != null && e.getIdNote() != null){
                Note n = noteRepository.findById(e.getIdNote()).orElse(null);
                if(n == null){
                    throw new IllegalStateException("Note n'existe pas");
                }
                n.setNote(Float.parseFloat(e.getNoteTp()));
                noteRepository.save(n);
            }

            if(e.getNoteTp() != null && e.getIdNote() == null){
                Note n = new Note(matiere,etudiant,enseignant, TypeDevoir.TP,Float.parseFloat(e.getNoteTp()),new Date(),semestre);
                noteRepository.save(n);
            }
        }
    }

    public void addNotesTd(NotesRequest<ObjectNoteTd> request) {
        Enseignant enseignant = enseignantRepository.findById(request.getIdEnseignant()).orElse(null);
        Matiere matiere = matiereRepository.findById(request.getIdMatiere()).orElse(null);
        Semestre semestre = semestreRepository.findById(request.getIdSemestre()).orElse(null);

        for (ObjectNoteTd e:request.getList()){
            Etudiant etudiant = etudiantRepository.findById(e.getIdEtudiant()).orElse(null);

            if(e.getNoteOral() != null && e.getIdNote() != null){
                Note n = noteRepository.findById(e.getIdNote()).orElse(null);
                if(n == null){
                    throw new IllegalStateException("Note n'existe pas");
                }
                n.setNote(e.getNoteOral());
                noteRepository.save(n);
            }

            if(e.getNoteOral() != null && e.getIdNote() == null){
                Note n = new Note(matiere,etudiant,enseignant, TypeDevoir.ORAL,e.getNoteOral(),new Date(),semestre);
                noteRepository.save(n);
            }
        }
    }

    public void addNotesSection(NotesRequest<ObjectNoteSection> request) {
        Enseignant enseignant = enseignantRepository.findById(request.getIdEnseignant()).orElse(null);
        Matiere matiere = matiereRepository.findById(request.getIdMatiere()).orElse(null);
        Semestre semestre = semestreRepository.findById(request.getIdSemestre()).orElse(null);

        for (ObjectNoteSection e:request.getList()){
            Etudiant etudiant = etudiantRepository.findById(e.getIdEtudiant()).orElse(null);
            if(e.getIdNoteDs() != null && e.getIdNoteDs() != null){
                System.out.println(e.getIdNoteDs());
                System.out.println(e.getNoteDs());
                Note n = noteRepository.findById(e.getIdNoteDs()).orElse(null);
                if(n == null){
                    throw new IllegalStateException("Note n'existe pas 1");
                }
                n.setNote(e.getNoteDs());
                noteRepository.save(n);
            }
            if(e.getNoteExam() != null && e.getIdNoteExam() != null){
                Note n = noteRepository.findById(e.getIdNoteExam()).orElse(null);
                if(n == null){
                    throw new IllegalStateException("Note n'existe pas 2");
                }
                n.setNote(e.getNoteExam());
                noteRepository.save(n);
            }

            if(e.getNoteDs() != null && e.getIdNoteDs() == null){
                Note n = new Note(matiere,etudiant,enseignant, TypeDevoir.DS,e.getNoteDs(),new Date(),semestre);
                noteRepository.save(n);
            }
            if(e.getNoteExam() != null && e.getIdNoteExam() == null){
                Note n = new Note(matiere,etudiant,enseignant, TypeDevoir.EXAM,e.getNoteExam(),new Date(),semestre);
                noteRepository.save(n);
            }
        }
    }
}
