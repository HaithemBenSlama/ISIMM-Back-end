package com.example.demo.Doa;

import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    @Query("SELECT s FROM Section s JOIN EnseignantMatiere em WHERE s.idSection = em.session ")
    Optional<Section> noteFindSectionByIdEnseignant(Long idEnseignant);

}