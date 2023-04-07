package com.example.demo.gestionNote.EtudiantReclamation;


import com.example.demo.Doa.EnseignantRepository;
import com.example.demo.Doa.EtudiantRepository;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Reclamation;
import com.example.demo.entities.enums.TypeDevoir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public List<Map<String,Object>> getReclamationsByEnseignant(@PathVariable("etudiantId") Long etudiantId){
        return reclamationServices.getReclamationsByEtudiant(etudiantId);
    }

    @PostMapping(path = "/addReclamation",consumes = "application/json")
    public void registerReclamation( @RequestBody  ReclamationRequest request){
        Long idEnseignant = reclamationServices.getEnseignantIdByCodeMatiere(request.getCodeMatiere(), request.getIdEtudiant(), request.getTypeNote());
        request.afficher();
        System.out.println("idEnseignant = "+ idEnseignant);

        reclamationServices.saveReclamation(request.getIdEtudiant(), idEnseignant, request.getMessage(), request.getStatut(),request.getCodeMatiere(), request.getTypeNote());
    }

//    @GetMapping(path = "/ens")
//    public Long getReclamationsByEns(){
//        return reclamationServices.getReclamationsByEns();
//    }



//    @GetMapping(path = "/ens/{id}")
//    public Optional getEnseignant(@PathVariable("id") Long id){
//        return reclamationServices.getEnseignant(id);
//    }
}

class ReclamationRequest {
    private String idEtudiant;
    private String message;
    private String statut;
    private String codeMatiere;
    private String typeNote;

    // getters and setters

    public Long getIdEtudiant() {
        return Long.parseLong(idEtudiant);
    }

    void afficher(){
        System.out.println("idEtudiant = "+ idEtudiant);
    }

    public String getMessage() {
        return message;
    }

    public String getStatut() {
        return statut;
    }

    public int getCodeMatiere() {
        return Integer.parseInt(codeMatiere);
    }

    public TypeDevoir getTypeNote() {
        return TypeDevoir.values()[Integer.parseInt(typeNote)];
    }
}