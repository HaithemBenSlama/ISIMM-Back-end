package com.example.demo.gestionNote.EnseignantReclamation;

import com.example.demo.Doa.ReclamationRepository;
import com.example.demo.entities.Reclamation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteEnseignantReclamationServices {

    private ReclamationRepository reclamationRepository;

    public Optional<Reclamation> getReclamationsByEnseignant(Long enseignantId){
        return Optional.ofNullable(reclamationRepository.noteFindReclamationEnseignantByEnseignantId(enseignantId).orElseThrow(() -> new IllegalStateException("Reclamation n'existe pas")));
    }

    public Optional<Reclamation> getReclamationsByMatiere(Long idMatiere){
        return Optional.ofNullable(reclamationRepository.noteFindReclamationEnseignantByCodeMatiere(idMatiere).orElseThrow(() -> new IllegalStateException("Matiere n'existe pas")));
    }

    public Optional<Reclamation> getReclamationsByStatut(String statut){
        return Optional.ofNullable(reclamationRepository.noteFindReclamationEnseignantByStatut(statut).orElseThrow(() -> new IllegalStateException("Statut n'existe pas")));
    }
}
