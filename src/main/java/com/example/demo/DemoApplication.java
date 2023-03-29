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
		DepartementRepository departement = ctx.getBean(DepartementRepository.class);

		Department d1= new Department("Informatique",new HashSet<Employer>());
		Department d2= new Department("Technologique",new HashSet<Employer>());
		Department d3= new Department("Mathematique",new HashSet<Employer>());

		Enseignant en1= new Enseignant(19,"CPI1", Enseignant.Grade.ASSISTANT,d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),"11223344","Hamel","Lazher",new Date(), Personne.Sexe.HOMME,"Monastir Isimm","123456789","Lazher.Hamel@gmail.com","22880343",40,new Date(),20,10,2100.50F);
		Enseignant en2= new Enseignant(19,"CPI2", Enseignant.Grade.MAITRE,d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),"11665599","Abassi","Imed",new Date(), Personne.Sexe.HOMME,"Monastir Isimm","123456789","imed.abassi@gmail.com","22350168",42,new Date(),20,10,2100.50F);
		Enseignant en3= new Enseignant(19,"ING_INF1", Enseignant.Grade.PROF,d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),"12356489","Graiet","Mohamed",new Date(), Personne.Sexe.HOMME,"Monastir Isimm","123456789","mohamed.graiet@gmail.com","22693521",46,new Date(),20,10,2100.50F);
		Enseignant en4= new Enseignant(19,"MR_INF1", Enseignant.Grade.ASSISTANT,d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),"12453698","Sekma","Manel",new Date(), Personne.Sexe.FEMME,"Monastir Isimm","123456789","manel.sekma@gmail.com","23965847",37,new Date(),20,10,2100.50F);
		d1.setChefDepartement(en1);
		d2.setChefDepartement(en2);
		d3.setChefDepartement(en3);

		departement.save(d1);
		departement.save(d2);
		departement.save(d3);

		enseignant.save(en1);
		enseignant.save(en2);
		enseignant.save(en3);
		enseignant.save(en4);

		Unite u1= new Unite("Analyse descriptive 1",new HashSet<Matiere>(),new HashSet<Semestre>());
		Unite u2= new Unite("Structures de données avancées",new HashSet<Matiere>(),new HashSet<Semestre>());
		Unite u3= new Unite("Ingénierie des systèmes informatiques",new HashSet<Matiere>(),new HashSet<Semestre>());
		Unite u4= new Unite("Programmation Web et mobile",new HashSet<Matiere>(),new HashSet<Semestre>());

		u1.setCoef(3.0F);
		u2.setCoef(3.0F);
		u3.setCoef(2.0F);
		u4.setCoef(4.0F);
		u1.setCredit(6F);
		u2.setCredit(6F);
		u3.setCredit(4F);
		u4.setCredit(8F);

		Regime r1= new Regime("Mixte",10,20,20,50,0,24,24,10,0,0,new HashSet<Matiere>());
		Regime r2= new Regime("Controle continu",30,20,0,50,0,24,0,0,0,0,new HashSet<Matiere>());
		// zid les matiere fil kol regime

		Matiere m1=new Matiere(5111,"Analyse de données",10,20,20,50,0,24,24,10,0,0,en4,r1,new HashSet<Note>(),u1,3F,1.5F);
		Matiere m2=new Matiere(5112,"Mathématiques des réseaux de neurones",10,20,20,50,0,24,24,10,0,0,en1,r1,new HashSet<Note>(),u1,3F,1.5F);
		Matiere m3=new Matiere(5121,"Structures de données avancées en Python ",10,20,20,50,0,24,24,10,0,0,en2,r1,new HashSet<Note>(),u2,3.0F,1.5F);
		Matiere m4=new Matiere(5122,"Techniques de construction d’analyseurs lexico-syntaxiques",10,20,20,50,0,24,24,10,0,0,en1,r1,new HashSet<Note>(),u2,3.0F,1.5F);
		Matiere m5=new Matiere(5131,"Applications logicielles d'entreprise",10,20,20,50,0,24,24,10,0,0,en3,r1,new HashSet<Note>(),u3,2.0F,1F);
		Matiere m6=new Matiere(5132,"Modélisation UML/OCL",10,20,20,50,0,24,24,10,0,0,en2,r1,new HashSet<Note>(),u3,2.0F,1F);
		Matiere m7=new Matiere(5141,"Programmation Web avancée ",10,20,20,50,0,24,24,10,0,0,en3,r1,new HashSet<Note>(),u4,3.0F,1.5F);
		Matiere m8=new Matiere(5142,"Programmation mobile",10,20,20,50,0,24,24,10,0,0,en4,r1,new HashSet<Note>(),u4,3.0F,1.5F);
		Matiere m9=new Matiere(5143,"Projet Web/mobile",10,20,20,50,0,24,24,10,0,0,en1,r1,new HashSet<Note>(),u4,2.0F,1F);


		Niveau niveau1= new Niveau("1ére année",new HashSet<Semestre>());
		Semestre sem1=new Semestre("Semestre 1", niveau1,new HashSet<Unite>());
		Section s1= new Section("Section 1",sem1,new HashSet<TD>());
		TD td1= new TD("TD1",s1,new HashSet<TP>());
		TP tp1= new TP("TP1",td1);


		Etudiant e1= new Etudiant("11985827","Ben Slama","Haithem",new Date(), Personne.Sexe.HOMME,"Monastir rue echkol","123456789","Haithem@gmail.com","27660834",22,td1,tp1);
		Note n= new Note();
		etudiant.save(e1);

	}
}
