package com.example.demo.Doa;

import com.example.demo.entities.EnseignantMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public interface EnseignantMatiereRepository extends JpaRepository<EnseignantMatiere, Long> {

    // -------------------------------------- Haithem + Yassine + Nawar --------------------------------------
    @Query("SELECT NEW map(em.idEnseignantMatiere AS idEnseignantMatiere, " +
            "em.groupId AS groupId, em.groupType AS groupType, m.code AS codeMatiere, " +
            "CASE WHEN em.groupType = 2 THEN t.name ELSE NULL END AS nameTP, " +
            "CASE WHEN em.groupType = 1 THEN td.name ELSE NULL END AS nameTD, " +
            "em.session AS session, em.matiere.idMatiere AS idMatiere, " +
            "m.name AS nameMatiere, s.idSection AS idSection, " +
            "s.name AS nameSection, em.semestre.idSemestre AS idSemestre, " +
            "em.semestre.name AS nameSemestre) " +
            "FROM EnseignantMatiere em " +
            "JOIN Matiere m ON m.idMatiere = em.matiere " +
            "JOIN Section s ON s.semestre.idSemestre IN (em.semestre.idSemestre, em.semester2.idSemestre) " +
            "LEFT JOIN TP t ON t.idTp = em.groupId " +
            "LEFT JOIN TD td ON td.idTd = em.groupId " +
            "WHERE em.enseignant.id = :id_enseignant")
    List<Map<String, Object>> noteFindSectionAndClassesByEnseignantId(Long id_enseignant);


}