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


    @Query(nativeQuery = true, value = "SELECT DISTINCT\n" +
            "  etudiant.nom, \n" +
            "  etudiant.prenom, \n" +
            "  etudiant.cin, \n" +
            "  semestre.name AS semester_name, \n" +
            "  diplome.nom AS diplome_name, \n" +
            "  niveau.name AS niveau_name, \n" +
            "  td.name AS td_name,\n" +
            "  tp.name AS tp_name,\n" +
            "  CASE WHEN MONTH(MAX(note.date)) <= 1 THEN CONCAT(YEAR(MAX(note.date)), '/', YEAR(MAX(note.date))+1) ELSE CONCAT(YEAR(MAX(note.date))-1, '/', YEAR(MAX(note.date))) END AS annee_scolaire\n" +
            "FROM etudiant \n" +
            "JOIN tp ON etudiant.id_tp = tp.td \n" +
            "JOIN td ON tp.td = td.id_td \n" +
            "JOIN section ON td.tds = section.id_section \n" +
            "JOIN semestre ON section.id_semestre = semestre.id_semestre \n" +
            "JOIN niveau ON semestre.id_niveau = niveau.id_niveau\n" +
            "JOIN diplome ON niveau.my_diplome = diplome.id_diplome\n" +
            "LEFT JOIN unite_semestres ON semestre.id_semestre = unite_semestres.semestres_id_semestre\n" +
            "LEFT JOIN unite ON unite_semestres.unite_id_unite = unite.id_unite\n" +
            "LEFT JOIN matiere ON unite.id_unite = matiere.unite\n" +
            "LEFT JOIN note ON etudiant.id = note.id_etudiant AND matiere.id_matiere = note.id_matiere\n" +
            "WHERE etudiant.id = :etudiantId AND semestre.id_semestre = :semestreId ")
    Optional<Etudiant> findEtudiantByIdAndSemesterId( Long etudiantId,  Long semestreId);

}