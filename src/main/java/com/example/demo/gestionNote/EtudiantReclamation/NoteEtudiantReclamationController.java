package com.example.demo.gestionNote.EtudiantReclamation;


import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/chargeNote/EtudiantReclamation")
public class NoteEtudiantReclamationController {
    private final NoteEtudiantReclamationServices reclamationServices;

    @Autowired
    public NoteEtudiantReclamationController(NoteEtudiantReclamationServices reclamationServices) {
        this.reclamationServices = reclamationServices;
    }


    @GetMapping(path = "/etudiant/{etudiantId}")
    public Optional<Reclamation> getReclamationsByEnseignant(@PathVariable("etudiantId") Long etudiantId){
        return reclamationServices.getReclamationsByEtudiant(etudiantId);
    }

//    @GetMapping(path = "/ens/{id}")
//    public Optional getEnseignant(@PathVariable("id") Long id){
//        return reclamationServices.getEnseignant(id);
//    }
}
