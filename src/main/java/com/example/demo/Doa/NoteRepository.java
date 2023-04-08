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

    @Query(
            value = "SELECT er.id as idEtudiant, er.cin as cinEtudiant, er.nom as nomEtudiant, er.prenom as prenomEtudiant, " +
                    "nr1.note as noteExam, " +
                    "nr2.note as noteDs " +
                    "FROM ( " +
                    "   SELECT e.id as id, e.cin as cin, e.nom as nom, e.prenom as prenom " +
                    "   FROM TD t " +
                    "   JOIN Section s ON s.id_section = t.tds " +
                    "   JOIN Etudiant e ON e.id_td = t.id_td " +
                    "   WHERE s.id_section = :group_id " +
                    ") AS er " +
                    "LEFT JOIN ( " +
                    "   SELECT n1.id_etudiant as etudiant_id, n1.note as note, n1.type as type " +
                    "   FROM Note n1 " +
                    "   WHERE n1.id_enseingant = :id_enseignant " +
                    "   AND n1.id_semestre = :id_semestre " +
                    "   AND n1.id_matiere = :id_matiere " +
                    "   AND n1.type = 1 " +
                    ") AS nr1 ON nr1.etudiant_id = er.id " +
                    "LEFT JOIN ( " +
                    "   SELECT n2.id_etudiant as etudiant_id, n2.note as note, n2.type as type " +
                    "   FROM Note n2 " +
                    "   WHERE n2.id_enseingant = :id_enseignant " +
                    "   AND n2.id_semestre = :id_semestre " +
                    "   AND n2.id_matiere = :id_matiere " +
                    "   AND n2.type = 0 " +
                    ") AS nr2 ON nr2.etudiant_id = er.id ",
            nativeQuery = true
    )
    List<Map<String,Object>> noteFindListeEtudiantAndNotesForSection(
            Long id_enseignant,
            Long group_id,
            Long id_semestre,
            Long id_matiere
    );

    @Query("Select new map(er.id as idEtudiant,er.cin as cinEtudiant,er.nom as nomEtudiant," +
            "er.prenom as prenomEtudiant,nr.note as noteTp,nr.t as typeNote) " +
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
            "er.prenom as prenomEtudiant,nr.note as noteOral,nr.t as typeNote) " +
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