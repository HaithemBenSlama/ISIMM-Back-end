package com.example.demo.gestionNote.EtudiantReclamation;


import com.example.demo.Doa.EnseignantRepository;
import com.example.demo.Doa.EtudiantRepository;
import com.example.demo.Doa.ReclamationRepository;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Reclamation;
import com.example.demo.entities.enums.Groups;
import com.example.demo.entities.enums.TypeDevoir;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteEtudiantReclamationServices {
    private ReclamationRepository reclamationRepository;
    private EnseignantRepository enseignantRepository;

    private EtudiantRepository etudiantRepository;


    public List<Map<String,Object>> getReclamationsByEtudiant(Long etudiantId){
        return reclamationRepository.noteFindReclamationEtudiantByEtudiantId(etudiantId);
    }

    public List<Reclamation> getReclamationsByMatiere(Long etudiantId, Long codeMatiere){
        return reclamationRepository.noteFindReclamationEtudiantByMatiereId(etudiantId,codeMatiere);
    }

    public List<Reclamation> getReclamationsByStatut(Long etudiantId, String statut){
        return reclamationRepository.noteFindReclamationEtudiantByStatut(etudiantId,statut);
    }

    public List<Reclamation> getReclamationsByDate(Long etudiantId, Date date){
        return reclamationRepository.noteFindReclamationEtudiantByDate(etudiantId,date);
    }


    @Transactional
    public void saveReclamation(Long idEtudiant, Long idEnseignant, String message, String statut, int codeMatiere, TypeDevoir typeNote) {


        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElse(null);

        if(etudiant == null){
            throw new IllegalArgumentException("Invalid idEtudiant");
        }
        Enseignant enseignant = enseignantRepository.findById(idEnseignant).orElse(null);
        if(enseignant == null){
            throw new IllegalArgumentException("Invalid idEnseignant");
        }
        System.out.println(enseignant.getId() + " , " +etudiant.getId() +" , "+ codeMatiere+" , "+typeNote);
        Reclamation reclamation1 = reclamationRepository.noteFindReclamationExists(enseignant.getId(), etudiant.getId(), codeMatiere, typeNote);
        if(reclamation1 != null){
            throw new IllegalStateException("Reclamation du matiere ("+ codeMatiere + ") / "+typeNote + " existe deja");
        }


        Reclamation reclamation = new Reclamation(enseignant,new Date(),message,statut,codeMatiere,typeNote);
        reclamation.setEtudiant(etudiant);

        reclamationRepository.save(reclamation);
    }

    public Long getEnseignantIdByCodeMatiere(int codeMatiere, Long idEtudiant, TypeDevoir typeDevoir) {
        Groups group;
        if(typeDevoir == TypeDevoir.DS){
            group = Groups.SECTION;
        }else if(typeDevoir == TypeDevoir.EXAM){
            group = Groups.SECTION;
        }else{
            group = Groups.TP;
        }
        Long id =  enseignantRepository.noteFindEnseignantByCodeMatiere(codeMatiere, idEtudiant, group);
        if(id == null){
            throw new IllegalStateException("Vérifier votre code matiére/Type Devoir !");
        }
        return id;
    }

    public List<Map<String,Object>> getReclamationDetails(Long idReclamation){
        return reclamationRepository.noteFindReclamationDetails(idReclamation);
    }

//    public Long getReclamationsByEns() {
//        return enseignantRepository.noteFindEnseignantByCodeMatiere(5111,15L, );
//    }

//    public Optional getEnseignant(Long id){
//        return reclamationRepository.getEnseignant(id);
//    }

}
