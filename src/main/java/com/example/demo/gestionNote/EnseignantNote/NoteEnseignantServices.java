package com.example.demo.gestionNote.EnseignantNote;

import com.example.demo.Doa.EnseignantRepository;
import com.example.demo.Doa.MatiereRepository;
import com.example.demo.Doa.NoteRepository;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Matiere;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteEnseignantServices {
    private final NoteRepository noteRepository;
    private final MatiereRepository matiereRepository;
    private final EnseignantRepository enseignantRepository;
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
}
