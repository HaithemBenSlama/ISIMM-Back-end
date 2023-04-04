package com.example.demo.gestionNote.EnseignantSection;

import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/chargeNote/EnseignantSection")
public class NoteEnseignantSectionController {

    private final NoteEnseignantSectionServices noteEnseignantSectionServices;

    @Autowired
    public NoteEnseignantSectionController(NoteEnseignantSectionServices enseignantSectionServices){
        this.noteEnseignantSectionServices=enseignantSectionServices;
    }


    // -------------------------------------- Haithem + Yassine + Nawar --------------------------------------
    @GetMapping(path="/{id_enseignant}")
    public List<Map<String,Object>> getSectionAndClasses(@PathVariable("id_enseignant") Long userId) {
        return noteEnseignantSectionServices.getSectionAndClasses(userId);
    }

    
    // -------------------------------------- Mazen + Ibrahim --------------------------------------



    // ------------------------------------- Belhassen ---------------------------------------------





}
