package com.example.demo.gestionNote.EnseignantReclamation;

import com.example.demo.Doa.ReclamationRepository;
import com.example.demo.entities.Reclamation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteEnseignantReclamationServices {

    private ReclamationRepository reclamationRepository;

    public List<Reclamation> getReclamationsByEnseignant(Long enseignantId){
        return reclamationRepository.noteFindReclamationEnseignantByEnseignantId(enseignantId);
    }

    public List<Reclamation> getReclamationsByMatiere(Long idMatiere, Long enseignantId){
        return reclamationRepository.noteFindReclamationEnseignantByCodeMatiere(idMatiere, enseignantId);
    }

    public List<Reclamation> getReclamationsByStatut(String statut, Long enseignantId){
        return reclamationRepository.noteFindReclamationEnseignantByStatut(statut, enseignantId);
    }


}
