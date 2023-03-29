package com.example.demo;

import com.example.demo.Doa.*;
import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.HashSet;

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

		Department d1= new Department("Informatique",new HashSet<Employer>());
		Enseignant en1= new Enseignant(19,"CPI1", Enseignant.Grade.ASSISTANT,d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),"11223344","Hamel","Lazher",new Date(), Personne.Sexe.HOMME,"Monastir Isimm","123456789","Lazher.Hamel@gmail.com","22880343",40,new Date(),20,10,2100.50F);
		Enseignant en2= new Enseignant(19,"CPI2", Enseignant.Grade.MAITRE,d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),"11665599","Abassi","Imed",new Date(), Personne.Sexe.HOMME,"Monastir Isimm","123456789","imed.abassi@gmail.com","22350168",42,new Date(),20,10,2100.50F);
		Enseignant en3= new Enseignant(19,"ING_INF1", Enseignant.Grade.PROF,d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),"12356489","Graiet","Mohamed",new Date(), Personne.Sexe.HOMME,"Monastir Isimm","123456789","mohamed.graiet@gmail.com","22693521",46,new Date(),20,10,2100.50F);
		Enseignant en4= new Enseignant(19,"MR_INF1", Enseignant.Grade.ASSISTANT,d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),"12453698","Sekma","Manel",new Date(), Personne.Sexe.FEMME,"Monastir Isimm","123456789","manel.sekma@gmail.com","23965847",37,new Date(),20,10,2100.50F);



		Unite u1= new Unite("U1",new HashSet<Matiere>(),new HashSet<Semestre>());
		Regime r1= new Regime("Mixte",10,20,20,50,0,24,24,10,0,0,new HashSet<Matiere>());
		Matiere m1=new Matiere(5111,"Génie Logiciel",10,20,20,50,0,24,24,10,0,0,en1,r1,new HashSet<Note>(),u1,2.0F,1.5F);
		Niveau niveau1= new Niveau("Niveau 1",new HashSet<Semestre>());
		Semestre sem1=new Semestre("Semestre 1", niveau1,new HashSet<Unite>());
		Section s1= new Section("Section 1",sem1,new HashSet<TD>());
		TD td1= new TD("TD1",s1,new HashSet<TP>());
		TP tp1= new TP("TP1",td1);


		Etudiant e1= new Etudiant("11985827","Ben Slama","Haithem",new Date(), Personne.Sexe.HOMME,"Monastir rue echkol","123456789","Haithem@gmail.com","27660834",22,td1,tp1);
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
