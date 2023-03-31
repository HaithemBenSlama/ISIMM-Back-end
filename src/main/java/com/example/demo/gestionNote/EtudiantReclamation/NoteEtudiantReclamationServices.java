package com.example.demo.gestionNote.EtudiantReclamation;


import com.example.demo.Doa.ReclamationRepository;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Reclamation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteEtudiantReclamationServices {
    private ReclamationRepository reclamationRepository;

    public Optional<Reclamation> getReclamationsByEtudiant(Long etudiantId){
        return Optional.ofNullable(reclamationRepository.noteFindReclamationEtudiantByEtudiantId(etudiantId).orElseThrow(() -> new IllegalStateException("Reclamation n'existe pas")));
    }

    public Optional<Reclamation> getReclamationsByMatiere(Long etudiantId, Long codeMatiere){
        return Optional.ofNullable(reclamationRepository.noteFindReclamationEtudiantByMatiereId(etudiantId,codeMatiere).orElseThrow(() -> new IllegalStateException("Reclamation n'existe pas")));
    }

    public Optional<Reclamation> getReclamationsByStatut(Long etudiantId, String statut){
        return Optional.ofNullable(reclamationRepository.noteFindReclamationEtudiantByStatut(etudiantId,statut).orElseThrow(() -> new IllegalStateException("Reclamation n'existe pas")));
    }

    public Optional<Reclamation> getReclamationsByDate(Long etudiantId, Date date){
        return Optional.ofNullable(reclamationRepository.noteFindReclamationEtudiantByDate(etudiantId,date).orElseThrow(() -> new IllegalStateException("Reclamation n'existe pas")));
    }

//    public Optional getEnseignant(Long id){
//        return reclamationRepository.getEnseignant(id);
//    }

}
