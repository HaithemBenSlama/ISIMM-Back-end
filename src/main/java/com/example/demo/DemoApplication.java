package com.example.demo;

import com.example.demo.Doa.*;
import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(DemoApplication.class, args);
		EtudiantRepository etudiant = ctx.getBean(EtudiantRepository.class);
		ReclamationRepository reclamation= ctx.getBean(ReclamationRepository.class);
		EnseignantRepository enseignant = ctx.getBean(EnseignantRepository.class);
		NoteRepository note = ctx.getBean(NoteRepository.class);
		RegimeRepository regime = ctx.getBean(RegimeRepository.class);
		MatiereRepository matiere = ctx.getBean(MatiereRepository.class);
		EnseignantMatiereRepository enseignantMatiere = ctx.getBean(EnseignantMatiereRepository.class);
		UniteRepository unite = ctx.getBean(UniteRepository.class);
		SemestreRepository semestre =ctx.getBean(SemestreRepository.class);
		NiveauRepository niveau = ctx.getBean(NiveauRepository.class);
		DiplomeRepository diplome = ctx.getBean(DiplomeRepository.class);
		TPRepository tp = ctx.getBean(TPRepository.class);
		TDRepository td = ctx.getBean(TDRepository.class);
		SectionRepository section = ctx.getBean(SectionRepository.class);



		Etudiant e1= new Etudiant();
		Enseignant en1= new Enseignant();
		Note n= new Note();
		etudiant.save(e1);


	}

	public void run(String... args) throws Exception {
		// Create an instance of Etudiant
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("John");
		etudiant.setPrenom("Doe");
		etudiant.setEmail("john.doe@example.com");
		etudiant.setCin("0123456789");
		etudiantRepository.save(etudiant);

		// Create an instance of Matiere
		Matiere matiere = new Matiere();
		matiere.setName("Math");
		matiere.setCode(5111);
		matiereRepository.save(matiere);

		// Create an instance of Section
		Section section = new Section();
		section.setName("Section A");
		sectionRepository.save(section);

		// Create an instance of TD
		TD td = new TD();
		td.setName("TD1");
		td.setSection(section);
		tdRepository.save(td);

		// Create an instance of TP
		TP tp = new TP();
		tp.setName("TP1");
		tp.setTd(td);
		tpRepository.save(tp);

		// Create an instance of Note
		Note note = new Note();
		note.setEtudiant(etudiant);
		note.setMatiere(matiere);
		note.setNote(15);
		noteRepository.save(note);

		// Create an instance of Enseignant
		Enseignant enseignant = new Enseignant();
		enseignant.setNom("Jane");
		enseignant.setPrenom("Doe");
		enseignant.setEmail("jane.doe@example.com");
		enseignantRepository.save(enseignant);
	}
}
