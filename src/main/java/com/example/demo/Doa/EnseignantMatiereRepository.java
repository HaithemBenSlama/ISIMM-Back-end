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
    @Query("Select new map( em.idEnseignantMatiere as idEnseignantMatiere,em.groupId as groupId,em.groupType as groupType,em.session as session,em.matiere.idMatiere as idMatiere,m.name as nameMatiere,s.idSection as idSection,s.name as nameSection,em.semestre.idSemestre as idSemestre,em.semestre.name as nameSemestre)" +
            "FROM EnseignantMatiere em JOIN Matiere m ON m.idMatiere=em.matiere " +
            "JOIN Section s ON s.semestre.idSemestre=em.semestre.idSemestre " +
            "WHERE em.enseignant.id =:id_enseignant and em.groupType != 1")
    List<Map<String,Object>> noteFindSectionAndClassesByEnseignantId(Long id_enseignant);


}