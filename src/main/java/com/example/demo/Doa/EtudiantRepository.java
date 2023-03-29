package com.example.demo.Doa;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Section;
import com.example.demo.entities.Voeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    @Query("SELECT e FROM Etudiant e JOIN EnseignantMatiere em WHERE em.groupType='TD' AND e.td.idTd=em.groupId")
    Optional<Etudiant> noteFindEtudiantByTdId(Long idTd);

    @Query("SELECT e FROM Etudiant e JOIN EnseignantMatiere em WHERE em.groupType='TP' AND e.tp.idTp=em.groupId")
    Optional<Etudiant> noteFindEtudiantByTpId(Long idTd);



}