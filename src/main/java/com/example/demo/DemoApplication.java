package com.example.demo;

import com.example.demo.Doa.*;
import com.example.demo.entities.*;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Groups;
import com.example.demo.entities.enums.Session;
import com.example.demo.entities.enums.Sexe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(DemoApplication.class, args);
		MatiereRepository matiere = ctx.getBean(MatiereRepository.class);
		RegimeRepository regime = ctx.getBean(RegimeRepository.class);
		TPRepository tp = ctx.getBean(TPRepository.class);
		TDRepository td = ctx.getBean(TDRepository.class);
		EnseignantRepository enseignant = ctx.getBean(EnseignantRepository.class);
		UniteRepository unite = ctx.getBean(UniteRepository.class);
		DepartementRepository departement = ctx.getBean(DepartementRepository.class);
		NiveauRepository niveau = ctx.getBean(NiveauRepository.class);
		SemestreRepository semestre =ctx.getBean(SemestreRepository.class);
		SectionRepository section = ctx.getBean(SectionRepository.class);
		EnseignantMatiereRepository enseignantMatiere = ctx.getBean(EnseignantMatiereRepository.class);


		Department d1= new Department("Informatique",new HashSet<Employer>());
		departement.save(d1);

		Enseignant en2= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223355","Manel","Sekma",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","Manel.Sekma@gmail.com","23542698",32,new Date(),40,17,1900F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		enseignant.save(en2);

		Unite u1= new Unite(511,"Analyse descriptive 1",3.0F,6F);
		unite.save(u1);


		Regime r1= new Regime("Mixte",10,20,20,50,0,24,24,10,0,0,new HashSet<Matiere>());
		regime.save(r1);

		Matiere m1=new Matiere("Analyse de données",3F,1.5F,60,20,20,0,0,5111,22,0,22,0,0,r1,u1);
		matiere.save(m1);

		Niveau niveau1= new Niveau("1ére année",new HashSet<Semestre>());
		niveau.save(niveau1);


		Semestre sem1=new Semestre("Semestre 1", niveau1,new HashSet<Unite>());
		semestre.save(sem1);


		Section s1= new Section("Section 1",sem1,new HashSet<TD>());
		section.save(s1);


		TD td1= new TD("TD1",s1,new HashSet<TP>());
		td.save(td1);


		TP tp1= new TP("TP1",td1);
		tp.save(tp1);

		td1.addTp(tp1);
		s1.addTd(td1);


		EnseignantMatiere enseignantMatiere2= new EnseignantMatiere(en2,m1, Session.CR, Groups.TD, td1.getIdTd());
		enseignantMatiere.save(enseignantMatiere2);


	}


}


