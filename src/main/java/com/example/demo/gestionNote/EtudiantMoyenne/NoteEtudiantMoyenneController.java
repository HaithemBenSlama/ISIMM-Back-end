package com.example.demo.gestionNote.EtudiantMoyenne;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

}
