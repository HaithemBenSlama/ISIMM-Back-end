package com.example.demo.gestionNote.EtudiantMoyenne;

import com.example.demo.Doa.EtudiantRepository;
import com.example.demo.Doa.NoteRepository;

import com.example.demo.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NoteEtudiantMoyenneServices {

    @Autowired
    private NoteRepository noteRepository;

    public List<Map<String, String>> findSectionsByEtudiantId(Long idEtudiant, Long idSemestre) {
        List<Object[]> result = noteRepository.findSectionsByEtudiantId(idEtudiant, idSemestre);
        List<Map<String, String>> mappedResult = new ArrayList<>();
        for (Object[] row : result) {
            Map<String, String> mappedRow = new LinkedHashMap<>();
            mappedRow.put("code_unite", String.valueOf(row[0]));
            mappedRow.put("unite_name", String.valueOf(row[1]));
            mappedRow.put("id_matiere", String.valueOf(row[2]));
            mappedRow.put("matiere", String.valueOf(row[3]));
            mappedRow.put("TP", String.valueOf(row[4]));
            mappedRow.put("ORAL", String.valueOf(row[5]));
            mappedRow.put("DS", String.valueOf(row[6]));
            mappedRow.put("EXAM", String.valueOf(row[7]));
            mappedRow.put("moyenne", String.valueOf(row[8]));
            mappedResult.add(mappedRow);
        }
        return mappedResult;
    }

    public List<Map<String, String>> findEtudiantByIdAndSemesterId(Long etudiantId, Long semestreId) {
        List<Object[]> result = noteRepository.findEtudiantByIdAndSemesterId(etudiantId, semestreId);
        List<Map<String, String>> mappedResult = new ArrayList<>();
        for (Object[] row : result) {
            Map<String, String> mappedRow = new LinkedHashMap<>();
            mappedRow.put("nom", String.valueOf(row[0]));
            mappedRow.put("prenom", String.valueOf(row[1]));
            mappedRow.put("cne", String.valueOf(row[2]));
            mappedRow.put("semestre", String.valueOf(row[3]));
            mappedRow.put("filiere", String.valueOf(row[4]));
            mappedRow.put("niveau", String.valueOf(row[5]));
            mappedRow.put("TP", String.valueOf(row[6]));
            mappedRow.put("TD", String.valueOf(row[7]));
            mappedRow.put("Année", String.valueOf(row[8]));
            mappedResult.add(mappedRow);
        }
        return mappedResult;
    }

}