package com.example.demo.gestionNote.EnseignantReclamation;


import com.example.demo.entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/chargeNote/EnseignantReclamation")
public class NoteEnseignantReclamationController {
    private final NoteEnseignantReclamationServices reclamationServices;

    @Autowired
    public NoteEnseignantReclamationController(NoteEnseignantReclamationServices reclamationServices) {
        this.reclamationServices = reclamationServices;
    }

    @GetMapping(path = "/enseignant/{enseignantId}")
    public Optional<Reclamation> getReclamationsByEnseignant(@PathVariable("enseignantId") Long enseignantId){
        return reclamationServices.getReclamationsByEnseignant(enseignantId);
    }

    @GetMapping(path = "/matiere/{idMatiere}")
    public Optional<Reclamation> getReclamationsByMatiere(@PathVariable("idMatiere") Long idMatiere){
        return reclamationServices.getReclamationsByMatiere(idMatiere);
    }

    @GetMapping(path = "/statut/{statut}")
    public Optional<Reclamation> getReclamationsByStatut(@PathVariable("statut") String statut){
        return reclamationServices.getReclamationsByStatut(statut);
    }
}
