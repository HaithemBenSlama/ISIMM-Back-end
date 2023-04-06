package com.example.demo.Doa;

import com.example.demo.entities.Note;
import com.example.demo.entities.Voeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("Select new map(er.i as idEtudiant,er.c as cinEtudiant,er.n as nomEtudiant," +
            "er.p as prenomEtudiant,nr.n as note,nr.t as typeNote) " +
            "FROM (SELECT e.id as i,e.cin as c,e.nom as n,e.prenom as p FROM TD t " +
            "JOIN Section s ON s.idSection=t.section.idSection JOIN Etudiant e ON e.td.idTd=t.idTd " +
            "WHERE s.idSection=:group_id) AS er " +
            "LEFT JOIN " +
            "(SELECT n.etudiant.id as ei,n.note as n,n.type as t FROM Note n " +
            "WHERE n.enseingant.id=:id_enseignant " +
            "AND n.semestre.idSemestre=:id_semestre " +
            "AND n.matiere.idMatiere=:id_matiere " +
            "AND n.type=0 OR n.type=1) AS nr " +
            "ON nr.ei=er.i")
    List<Map<String,Object>> noteFindListeEtudiantAndNotesForSection(
            Long id_enseignant,
            Long group_id,
            Long id_semestre,
            Long id_matiere
    );

    @Query("Select new map(er.id as idEtudiant,er.cin as cinEtudiant,er.nom as nomEtudiant," +
            "er.prenom as prenomEtudiant,nr.note as note,nr.t as typeNote) " +
            "FROM Etudiant er " +
            "LEFT JOIN " +
            "(SELECT n.etudiant.id as ei,n.note as note,n.type as t " +
            "FROM Note n WHERE n.enseingant.id=:id_enseignant " +
            "AND n.semestre.idSemestre=:id_semestre " +
            "AND n.matiere.idMatiere=:id_matiere " +
            "AND n.type=2) AS nr " +
            "ON nr.ei=er.id " +
            "WHERE er.tp.idTp=:group_id")
    List<Map<String,Object>> noteFindListeEtudiantAndNotesForTp(
            Long id_enseignant,
            Long group_id,
            Long id_semestre,
            Long id_matiere
    );

    @Query("Select new map(er.id as idEtudiant,er.cin as cinEtudiant,er.nom as nomEtudiant," +
            "er.prenom as prenomEtudiant,nr.note as note,nr.t as typeNote) " +
            "FROM Etudiant er " +
            "LEFT JOIN " +
            "(SELECT n.etudiant.id as ei,n.note as note,n.type as t " +
            "FROM Note n WHERE n.enseingant.id=:id_enseignant " +
            "AND n.semestre.idSemestre=:id_semestre " +
            "AND n.matiere.idMatiere=:id_matiere " +
            "AND n.type=3) AS nr " +
            "ON nr.ei=er.id " +
            "WHERE er.td.idTd=:group_id")
    List<Map<String,Object>> noteFindListeEtudiantAndNotesForTd(
            Long id_enseignant,
            Long group_id,
            Long id_semestre,
            Long id_matiere
    );


}