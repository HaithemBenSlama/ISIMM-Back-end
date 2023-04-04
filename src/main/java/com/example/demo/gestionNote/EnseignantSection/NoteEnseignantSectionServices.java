package com.example.demo.gestionNote.EnseignantSection;

import com.example.demo.Doa.EnseignantMatiereRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class NoteEnseignantSectionServices {
    private final EnseignantMatiereRepository enseignantMatiereRepository;

    // -------------------------------------- Haithem + Yassine + Nawar --------------------------------------
    public List<Map<String,Object>> getSectionAndClasses(Long userId) {
        List<Map<String,Object>> s= enseignantMatiereRepository.noteFindSectionAndClassesByEnseignantId(userId);
        return s;
    }

}
