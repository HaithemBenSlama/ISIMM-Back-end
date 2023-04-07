package com.example.demo.Doa;

import com.example.demo.entities.Enseignant;
import com.example.demo.entities.enums.Groups;
import com.example.demo.entities.enums.TypeDevoir;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Transactional

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

    @Query("SELECT s FROM Enseignant s where  s.email=?1")
    Optional<Enseignant> chargeFindEnseignantByEmail(String email);


    @Query("select e.id from Enseignant e where e.id = (select em.enseignant.id from EnseignantMatiere em where em.groupId = (select e.td.idTd from Etudiant e where e.id=:idEtudiant) and em.matiere.idMatiere = (select m.idMatiere from Matiere m where m.code = :codeMatiere) and em.groupType= :type)")
    Long noteFindEnseignantByCodeMatiere(int codeMatiere, Long idEtudiant, Groups type);
}