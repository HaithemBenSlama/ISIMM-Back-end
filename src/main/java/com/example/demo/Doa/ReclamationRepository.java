package com.example.demo.Doa;

import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Reclamation;
import com.example.demo.entities.Voeux;
import com.example.demo.entities.enums.TypeDevoir;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
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
    @Query("SELECT r.etudiant FROM Reclamation r where r.enseignant.id = :enseignantId")
    List<Reclamation> noteFindReclamationEnseignantByEnseignantId(Long enseignantId);

    @Query("SELECT r FROM Reclamation r WHERE r.codeMatiere = :idMatiere and r.enseignant.id = :enseignantId")
    List<Reclamation> noteFindReclamationEnseignantByCodeMatiere(Long idMatiere, Long enseignantId);

    @Query("SELECT r FROM Reclamation r WHERE r.statut = :statut and r.enseignant.id = :enseignantId")
    List<Reclamation> noteFindReclamationEnseignantByStatut(String statut, Long enseignantId);


    //Student Query
    @Query("SELECT new map(r.codeMatiere as codeMatiere, r.etudiant.id as idEtudiant,r.typeNote as typeDevoir,r.statut as statut, r.message as message , r.creationDateTime as creationDateTime, r.idReclamation as idReclamation,r.enseignant.id as idEnseignant , m.name as nomMatiere) \n" +
            "FROM Reclamation r \n" +
            "JOIN Matiere m ON m.code = r.codeMatiere \n" +
            "WHERE r.etudiant.id = :etudiantId")
    List<Map<String,Object>> noteFindReclamationEtudiantByEtudiantId(Long etudiantId);

    @Query("SELECT r FROM Reclamation r WHERE r.etudiant.id = :etudiantId and r.codeMatiere = :codeMatiere")
    List<Reclamation> noteFindReclamationEtudiantByMatiereId(Long etudiantId, Long codeMatiere);

    @Query("SELECT r FROM Reclamation r WHERE r.etudiant.id = :etudiantId and r.statut = :statut")
    List<Reclamation> noteFindReclamationEtudiantByStatut(Long etudiantId, String statut);

    @Query("SELECT r FROM Reclamation r WHERE r.etudiant.id = :etudiantId and r.creationDateTime = :date")
    List<Reclamation> noteFindReclamationEtudiantByDate(Long etudiantId, Date date);

    @Query("select r from Reclamation r where r.enseignant.id = :idEnseignant and r.etudiant.id = :idEtudiant and r.codeMatiere = :codeMatiere and r.typeNote = :typeDevoir")
    Reclamation noteFindReclamationExists(Long idEnseignant, Long idEtudiant, int codeMatiere, TypeDevoir typeDevoir);


    @Query("SELECT new map(r.codeMatiere as codeMatiere,r.idReclamation as idReclamation, r.typeNote as typeNote, r.creationDateTime as dateCreation,r.message as message, r.statut as statut,m.idMatiere as idMatiere,m.code as matiereCode,m.name as nomMatiere,e.id as idEnseignant,e.email as emailEnseignant,e.nom as nomEnseignant,e.prenom as prenomEnseignant,et.id as idEtudiant ,et.cin as cinEtudiant,et.email as emailEtudiant,et.nom as nomEtudiant,et.prenom as prenomEtudiant) \n" +
            "FROM Reclamation r \n" +
            "INNER join Etudiant et ON et.id = r.etudiant.id \n" +
            "INNER JOIN Enseignant e ON e.id = r.enseignant.id\n" +
            "INNER JOIN Matiere m on m.code = r.codeMatiere\n" +
            "where r.idReclamation = :idReclamation")
    List<Map<String,Object>> noteFindReclamationDetails(Long idReclamation);

}