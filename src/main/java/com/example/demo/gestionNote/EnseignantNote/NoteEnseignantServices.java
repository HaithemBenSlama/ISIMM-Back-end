package com.example.demo.gestionNote.EnseignantNote;

import com.example.demo.Doa.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class NoteEnseignantServices {
    private final NoteRepository noteRepository;
    public List<Map<String,Object>> getListeStudentAndNotes(int type,Long id_enseignant,Long group_id, Long id_semestre, Long id_matiere) {
        List<Map<String,Object>> s;
        if(type==2)
            s= noteRepository.noteFindListeEtudiantAndNotesForTp(id_enseignant,group_id,id_semestre,id_matiere);
        else
            s=noteRepository.noteFindListeEtudiantAndNotesForSection(id_enseignant,group_id,id_semestre,id_matiere);
        return s;
    }
}
