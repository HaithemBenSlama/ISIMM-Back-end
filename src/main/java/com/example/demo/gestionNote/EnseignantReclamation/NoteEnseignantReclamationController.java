package com.example.demo.gestionNote.EnseignantReclamation;


import com.example.demo.entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public List<Map<String,Object>> getReclamationsByEnseignant(@PathVariable("enseignantId") Long enseignantId){
        return reclamationServices.getReclamationsByEnseignant(enseignantId);
    }

    @GetMapping(path = "/matiere/{enseignantId}/{idMatiere}")
    public List<Reclamation> getReclamationsByMatiere(@PathVariable("idMatiere") Long idMatiere, @PathVariable("enseignantId") Long enseignantId){
        return reclamationServices.getReclamationsByMatiere(idMatiere, enseignantId);
    }

    @GetMapping(path = "/statut/{enseignantId}/{statut}")
    public List<Reclamation> getReclamationsByStatut(@PathVariable("statut") String statut,@PathVariable("enseignantId") Long enseignantId){
        return reclamationServices.getReclamationsByStatut(statut,enseignantId);
    }

    @PostMapping(path = "/updateReclamation",consumes = "application/json")
    public void updateReclamationStatus(@RequestBody UpdateStatusBody request){
        reclamationServices.updateReclamationStatus(request.getIdReclamation(), request.getStatut());
    }


}


class UpdateStatusBody {
    private Long idReclamation;
    private String statut;

    // getters and setters

    public Long getIdReclamation() {
        return idReclamation;
    }

    public String getStatut() {
        return statut;
    }
}
