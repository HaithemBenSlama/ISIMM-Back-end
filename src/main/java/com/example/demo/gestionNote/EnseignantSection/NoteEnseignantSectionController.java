package com.example.demo.gestionNote.EnseignantSection;

import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/chargeNote/EnseignantSection")
public class NoteEnseignantSectionController {

    private final NoteEnseignantSectionServices enseignantSectionServices;

    @Autowired
    public NoteEnseignantSectionController(NoteEnseignantSectionServices enseignantSectionServices){
        this.enseignantSectionServices=enseignantSectionServices;
    }

    @GetMapping(path="{enseignantId}")
    public Section getSection(@PathVariable("enseignantId") Long userId){
        return enseignantSectionServices.getSection(userId);
    }



}
