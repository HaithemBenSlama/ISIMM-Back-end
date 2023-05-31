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
                    "nr2.note as noteDs," +
                    "nr1.idNoteExam as idNoteExam," +
                    "nr2.idNoteDs as idNoteDs " +
                    "FROM ( " +
                    "   SELECT e.id as id, e.cin as cin, e.nom as nom, e.prenom as prenom " +
                    "   FROM TD t " +
                    "   JOIN Section s ON s.id_section = t.tds " +
                    "   JOIN Etudiant e ON e.id_td = t.id_td " +
                    "   WHERE s.id_section = :group_id " +
                    ") AS er " +
                    "LEFT JOIN ( " +
                    "   SELECT n1.id_etudiant as etudiant_id, n1.note as note, n1.type as type,n1.id_note as idNoteExam " +
                    "   FROM Note n1 " +
                    "   WHERE n1.id_enseingant = :id_enseignant " +
                    "   AND n1.id_semestre = :id_semestre " +
                    "   AND n1.id_matiere = :id_matiere " +
                    "   AND n1.type = 1 " +
                    ") AS nr1 ON nr1.etudiant_id = er.id " +
                    "LEFT JOIN ( " +
                    "   SELECT n2.id_etudiant as etudiant_id, n2.note as note, n2.type as type, n2.id_note as idNoteDs " +
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
            "er.prenom as prenomEtudiant,nr.note as noteTp,nr.t as typeNote, nr.id as idNote) " +
            "FROM Etudiant er " +
            "LEFT JOIN " +
            "(SELECT n.idNote as id,n.etudiant.id as ei,n.note as note,n.type as t " +
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
            "er.prenom as prenomEtudiant,nr.note as noteOral,nr.t as typeNote, nr.id as idNote) " +
            "FROM Etudiant er " +
            "LEFT JOIN " +
            "(SELECT n.idNote as id ,n.etudiant.id as ei,n.note as note,n.type as t " +
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

    //****************************************** Mazen+ Ibrahim  **************************************
    @Query(nativeQuery = true,value="SELECT unite.code_unite, unite.name AS unite_name, matiere.code, matiere.name AS matiere_name,\n" +
            "  CASE WHEN matiere.coeff_ds = 0 THEN 'NA' ELSE MAX(CASE note.type WHEN '0' THEN note.note ELSE NULL END) END AS DS,\n" +
            "  CASE WHEN matiere.coeff_exam = 0 THEN 'NA' ELSE MAX(CASE note.type WHEN '1' THEN note.note ELSE NULL END) END AS EXAM,\n" +
            "  CASE WHEN matiere.coeff_tp = 0 THEN 'NA' ELSE MAX(CASE note.type WHEN '2' THEN note.note ELSE NULL END) END AS TP,\n" +
            "  CASE WHEN matiere.coeff_oral = 0 THEN 'NA' ELSE MAX(CASE note.type WHEN '3' THEN note.note ELSE NULL END) END AS ORAL,\n" +
            "  ROUND(\n" +
            "    (IFNULL(MAX(CASE note.type WHEN '0' THEN note.note * (matiere.coeff_ds/100) ELSE NULL END), 0)\n" +
            "     + IFNULL(MAX(CASE note.type WHEN '1' THEN note.note * (matiere.coeff_exam/100) ELSE NULL END), 0)\n" +
            "     + IFNULL(MAX(CASE note.type WHEN '2' THEN note.note * (matiere.coeff_tp/100) ELSE NULL END), 0)\n" +
            "     + IFNULL(MAX(CASE note.type WHEN '3' THEN note.note * (matiere.coeff_oral/100) ELSE NULL END), 0))\n" +
            "    , 2) AS moyenne \n" +
            "FROM etudiant \n" +
            "JOIN tp ON etudiant.id_tp = tp.td \n" +
            "JOIN td ON tp.td = td.id_td \n" +
            "JOIN section ON td.tds = section.id_section \n" +
            "JOIN semestre ON semestre.id_semestre IN (section.id_semestre, section.id_semestre2) \n" +
            "JOIN unite_semestres ON semestre.id_semestre = unite_semestres.semestres_id_semestre \n" +
            "JOIN unite ON unite_semestres.unite_id_unite = unite.id_unite \n" +
            "JOIN matiere ON unite.id_unite = matiere.unite\n" +
            "LEFT JOIN note ON etudiant.id = note.id_etudiant AND matiere.id_matiere = note.id_matiere \n" +
            "WHERE etudiant.id = :etudiantId AND semestre.id_semestre = :semestreId \n" +
            "GROUP BY matiere.id_matiere")
    List<Object[]> findSectionsByEtudiantId(Long etudiantId ,Long semestreId);

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
            "JOIN semestre ON  semestre.id_semestre in (section.id_semestre ,section.id_semestre2) \n" +
            "JOIN niveau ON semestre.id_niveau = niveau.id_niveau\n" +
            "JOIN diplome ON niveau.my_diplome = diplome.id_diplome\n" +
            "LEFT JOIN unite_semestres ON semestre.id_semestre = unite_semestres.semestres_id_semestre\n" +
            "LEFT JOIN unite ON unite_semestres.unite_id_unite = unite.id_unite\n" +
            "LEFT JOIN matiere ON unite.id_unite = matiere.unite\n" +
            "LEFT JOIN note ON etudiant.id = note.id_etudiant AND matiere.id_matiere = note.id_matiere\n" +
            "WHERE etudiant.id = :EtudiantId AND semestre.id_semestre = :semestreId ")
    List<Object[]> findEtudiantByIdAndSemesterId(Long EtudiantId, Long semestreId);

}
