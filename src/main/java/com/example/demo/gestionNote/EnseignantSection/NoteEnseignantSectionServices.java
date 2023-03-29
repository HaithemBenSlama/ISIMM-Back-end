package com.example.demo.gestionNote.EnseignantSection;

import com.example.demo.Doa.SectionRepository;
import com.example.demo.entities.Section;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteEnseignantSectionServices {
    private final SectionRepository sectionRepository;

    public Section getSection(Long userId) {
        Section s=sectionRepository.noteFindSectionByIdEnseignant(userId).orElseThrow(()->new IllegalStateException(("Enseignant n'existe pas")));
        return s;
    }
}
