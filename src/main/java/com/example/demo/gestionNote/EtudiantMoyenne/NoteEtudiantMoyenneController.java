package com.example.demo.gestionNote.EtudiantMoyenne;

import com.example.demo.entities.Etudiant;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/isimm/chargeNote/EtudiantMoyenne")
@CrossOrigin(origins = "*")
public class NoteEtudiantMoyenneController {

    @Autowired
    private NoteEtudiantMoyenneServices noteService;

    @GetMapping("/notes/{idEtudiant}/{idSemestre}")
    public List<Map<String, String>> findSectionsByEtudiantId(@PathVariable Long idEtudiant, @PathVariable Long idSemestre ) {
        return noteService.findSectionsByEtudiantId(idEtudiant, idSemestre);
    }

    @GetMapping("/bulletin/{etudiantId}/{semestreId}")
    public ResponseEntity<Etudiant> getEtudiantByIdAndSemesterId(@PathVariable Long etudiantId, @PathVariable Long semestreId) {
        Etudiant etudiant = noteService.findEtudiantByIdAndSemesterId(etudiantId, semestreId).orElse(null);
        if(etudiant == null){
            throw new IllegalStateException("Etudiant n'existe pas");
        }

        return ResponseEntity.ok(etudiant);

    }

}
