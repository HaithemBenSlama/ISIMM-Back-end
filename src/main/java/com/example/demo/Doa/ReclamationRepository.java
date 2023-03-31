package com.example.demo.Doa;

import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Reclamation;
import com.example.demo.entities.Voeux;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

//    @Query("SELECT R\n" +
//            "FROM Reclamation R\n" +
//            "JOIN Etudiant E ON R.etudiant = E\n" +
//            "JOIN Note N ON E.id = N.etudiant.id AND R.codeMatiere = N.matiere.code\n" +
//            "WHERE N.enseingant.id = :enseignantId ")

    //Teacher Query
    @Query("SELECT r FROM Reclamation r")
    Optional<Reclamation> noteFindReclamationEnseignantByEnseignantId(Long enseignantId);

    @Query("SELECT r FROM Reclamation r WHERE r.codeMatiere = :idMatiere")
    Optional<Reclamation> noteFindReclamationEnseignantByCodeMatiere(Long idMatiere);

    @Query("SELECT r FROM Reclamation r WHERE r.statut = :statut")
    Optional<Reclamation> noteFindReclamationEnseignantByStatut(String statut);


    //Student Query
    @Query("SELECT r FROM Reclamation r WHERE r.etudiant.id = :etudiantId")
    Optional<Reclamation> noteFindReclamationEtudiantByEtudiantId(Long etudiantId);

    @Query("SELECT r FROM Reclamation r WHERE r.etudiant.id = :etudiantId and r.codeMatiere = :codeMatiere")
    Optional<Reclamation> noteFindReclamationEtudiantByMatiereId(Long etudiantId, Long codeMatiere);

    @Query("SELECT r FROM Reclamation r WHERE r.etudiant.id = :etudiantId and r.statut = :statut")
    Optional<Reclamation> noteFindReclamationEtudiantByStatut(Long etudiantId, String statut);

    @Query("SELECT r FROM Reclamation r WHERE r.etudiant.id = :etudiantId and r.creationDateTime = :date")
    Optional<Reclamation> noteFindReclamationEtudiantByDate(Long etudiantId, Date date);


}