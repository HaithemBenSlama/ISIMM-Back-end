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

//    @Query("Select new map( em.idEnseignantMatiere as idEnseignantMatiere,em.groupId as groupId," +
//            "em.groupType as groupType,em.session as session,em.matiere.idMatiere as idMatiere,m.name as nameMatiere," +
//            "s.idSection as idSection,s.name as nameSection,em.semestre.idSemestre as idSemestre,em.semestre.name as nameSemestre)" +
//            "FROM Note n JOIN Etudiant e ON e.id=n.etudiant.id " +
//            "JOIN TD t ON e.td.idTd=t.idTd " +
//            "JOIN Section s ON s.idSection=t.section.idSection " +
//            "JOIN Matiere m ON m.idMatiere=n.matiere.idMatiere "+
//            "WHERE em.enseignant.id =:id_enseignant and em.groupType != 1")
////    select n.id_note, n.note,n.type,n.id_enseingant,n.id_matiere,n.id_semestre,e.nom,e.prenom,e.cin,e.id,m.code
////    from note n JOIN etudiant e ON e.id=n.id_etudiant
////    JOIN TD t ON e.id_td=t.id_td
////    JOIN section s ON s.id_section=t.tds
////    JOIN matiere m ON m.id_matiere=n.id_matiere
////    where n.id_semestre=1 and n.id_matiere=6 and (type=1 or type=0 or type=3);
//
//    List<Map<String,Object>> noteFindListeEtudiantAndNotesForSection(Long id_enseignant);


}