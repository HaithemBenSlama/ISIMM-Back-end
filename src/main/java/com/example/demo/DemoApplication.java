package com.example.demo;

import com.example.demo.Doa.*;
import com.example.demo.entities.*;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Groups;
import com.example.demo.entities.enums.Session;
import com.example.demo.entities.enums.Sexe;
import com.example.demo.entities.enums.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(DemoApplication.class, args);


		EtudiantRepository etudiant = ctx.getBean(EtudiantRepository.class);
		EnseignantRepository enseignant = ctx.getBean(EnseignantRepository.class);
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

		Department d1= new Department("Informatique",new HashSet<Employer>(),new HashSet<Enseignant>());
		Department d2= new Department("Technologique",new HashSet<Employer>(),new HashSet<Enseignant>());
		Department d3= new Department("Mathematique",new HashSet<Employer>(),new HashSet<Enseignant>());
		Department d4= new Department("Langue",new HashSet<Employer>(),new HashSet<Enseignant>());

		departement.save(d1);
		departement.save(d2);
		departement.save(d3);
		departement.save(d4);



		Enseignant en1= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223344","Hamel","Lazher",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","Lazher.hamel@gmail.com","22880343",30,new Date(),40,20,2500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en2= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223355","Manel","Sekma",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","Manel.Sekma@gmail.com","23542698",32,new Date(),40,17,1900F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en3= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223366","Ben Hmida","Abir",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","abir.benhmida@gmail.com","23012565",41,new Date(),40,20,2500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en4= new Enseignant(d3,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223377","Eloued","mohamed",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","Eloued.mohamed@gmail.com","23654895",42,new Date(),40,20,1500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en5= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223388","Ben Abdallah","Asma",new Date(),Sexe.FEMME,"Monastir ISIMM","azerty123","asma.benabdallah@gmail.com","22452302",39,new Date(),40,20,1200F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en6= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223399","Sakka rouis","Taoufik",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","taoufik.sakkarouis@gmail.com","25360123",30,new Date(),40,20,1500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en7= new Enseignant(d4,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223322","Soumaya","Ben Aycha",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","soumaya.benaycha@gmail.com","29856325",30,new Date(),40,20,1500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en8= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"12001244","Sami","Bhiri",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","sami.bhiri@gmail.com","25369210",39,new Date(),40,20,2500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en9= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"12001255","Graiet","Mohamed",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","Graiet.mohamed@gmail.com","25364820",32,new Date(),40,20,1200F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en10= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"12001266","Kouraichi","Dorsaf",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","dorsaf.koraichi@gmail.com","23698520",39,new Date(),40,20,1200F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en11= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"12001277","Malek","Ben Salem",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","malek.benSalem@gmail.com","24563282",39,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en12= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11365259","Yousfi","Nihed",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","nihed.yousfi@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en13= new Enseignant(d2,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11385249","Kerekni","Asma",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","asma.Kerekni@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en14= new Enseignant(d2,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11355259","Azzaz","Skander",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","skander.azzaz@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en15= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11355479","Abassi","Imed",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","imed.abassi@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en16= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11358969","Kmimech","Mourad",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","mourad.kmimech@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en17= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11780969","Blel","Ilhem",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","ilhem.blel@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en18= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11390409","Ben salah","Kais",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","kais.bensalah@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en19= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11057409","Baba","Raja",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","raja.baba@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en20= new Enseignant(d3,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11390435","Ben Chrouda","Mohamed",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","mohammed.benchrouda@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en21= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11390487","Chaka","Radhwane",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","radhwane.chaka@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en22= new Enseignant(d4,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11874009","Horigue","Salwa",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","Salwa.horigue@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en23= new Enseignant(d3,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11390269","Slimene","Jihene",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","jihene.slimene@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en24= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11390200","Chatti","Maleke",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","malek.chatti@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);


		enseignant.save(en1);
		enseignant.save(en2);
		enseignant.save(en3);
		enseignant.save(en4);
		enseignant.save(en5);
		enseignant.save(en6);
		enseignant.save(en7);
		enseignant.save(en8);
		enseignant.save(en9);
		enseignant.save(en10);
		enseignant.save(en11);
		enseignant.save(en12);
		enseignant.save(en13);
		enseignant.save(en14);
		enseignant.save(en15);
		enseignant.save(en16);
		enseignant.save(en17);
		enseignant.save(en18);
		enseignant.save(en19);
		enseignant.save(en20);
		enseignant.save(en21);
		enseignant.save(en22);
		enseignant.save(en23);
		enseignant.save(en24);



		d1.setChefDepartement(en1);
		//d3.setChefDepartement(en12);
		//d4.setChefDepartement(en7);

		d1.addEnseignant(en1);
		d1.addEnseignant(en2);
		d1.addEnseignant(en3);
		d1.addEnseignant(en5);
		d1.addEnseignant(en6);
		d1.addEnseignant(en8);
		d1.addEnseignant(en9);
		d1.addEnseignant(en10);
		d1.addEnseignant(en11);
		d1.addEnseignant(en12);
		d1.addEnseignant(en15);
		d1.addEnseignant(en16);
		d1.addEnseignant(en17);
		d1.addEnseignant(en18);
		d1.addEnseignant(en19);
		d1.addEnseignant(en24);


		d2.addEnseignant(en13);
		d2.addEnseignant(en14);


		d3.addEnseignant(en4);
		d3.addEnseignant(en20);
		d3.addEnseignant(en23);

		d4.addEnseignant(en22);
		d4.addEnseignant(en7);

		Unite u1= new Unite(310,"Mathematiques 1",3.0F,6F);
		Unite u2= new Unite(120,"Theorie des langages ",2.0F,4F);
		Unite u3= new Unite(330,"Rzéeaux et systeme",3.0F,6F);
		Unite u4= new Unite(340,"Programmation oriontee objet",3.0F,6F);
		Unite u5= new Unite(311,"Transversale ",2.0F,4F);
		Unite u6= new Unite(350,"Systemes d'information",2.0F,4F);


		unite.save(u1);unite.save(u2);unite.save(u3);unite.save(u4);unite.save(u5);unite.save(u6);

		Regime r1= new Regime("Mixte",3,22,0,22,0,0,new HashSet<Matiere>());
		Regime r2= new Regime("Controle continu",2,22,0,0,0,0,new HashSet<Matiere>());

		regime.save(r1);regime.save(r2);

		Matiere m1=new Matiere("Algebre 3",3F,1.5F,50,20,30,0,3111,22,0,0,0,0,r1,u1);
		Matiere m2=new Matiere("Analyse 3",3F,1.5F,50,20,30,0,3112,22,0,0,0,0,r1,u1);

		Matiere m3=new Matiere("Theorie des langages et automate",4F,2F,50,20,30,0,3121,22,0,0,0,0,r1,u2);

		Matiere m4=new Matiere("Transmission de données ",3F,1.5F,60,20,20,0,3122,22,11,0,0,0,r1,u3);
		Matiere m5=new Matiere("Systemes d exploitation 2",3F,1.5F,50,20,30,0,3131,22,11,0,0,0,r1,u3);

		Matiere m6=new Matiere("Programmation OO JAVA",2F,1F,60,20,20,0,3132,22,11,22,0,22,r1,u4);
		Matiere m7=new Matiere("Programmation python",2F,1F,50,20,30,0,3141,22,0,22,0,0,r1,u4);

		Matiere m8=new Matiere("Fondement des bases de donnees",2F,1F,50,20,30,0,3142,22,22,0,0,0,r1,u6);
		Matiere m9=new Matiere("Logique formelle",2F,1F,0,0,100,0,3143,22,11,0,0,22,r2,u6);

		Matiere m10=new Matiere("TOIEC 1",2F,1F,80,10,0,10,3151,22,0,0,0,0,r2,u5);
		Matiere m11=new Matiere("Technique de communication 1",2F,1F,80,10,0,10,3152,22,0,0,0,0,r2,u5);

		matiere.save(m1);matiere.save(m2);matiere.save(m3);matiere.save(m4);matiere.save(m5);matiere.save(m6);matiere.save(m7);matiere.save(m8);
		matiere.save(m9);matiere.save(m10);matiere.save(m11);

		Unite u7= new Unite(410,"Mathematiques 2",2.0F,4F);
		Unite u8= new Unite(420,"Compilation ",2.0F,4F);
		Unite u9= new Unite(430,"Programmation",2.0F,4F);
		Unite u10= new Unite(440,"Systeme d'information",3.0F,6F);
		Unite u11= new Unite(450,"Systemes et Reseaux ",3.0F,6F);
		Unite u12= new Unite(411,"Transversale ",2.0F,4F);

		unite.save(u7);unite.save(u8);unite.save(u9);unite.save(u10);unite.save(u11);unite.save(u12);

		Matiere m111=new Matiere("Probabilite Statistique",4F,2F,50,20,30,0,4111,22,22,0,0,0,r1,u7);
		Matiere m22=new Matiere("Compilation",4F,2F,50,20,30,0,4112,22,0,22,0,0,r1,u8);

		Matiere m33=new Matiere("Java 1",2F,1F,50,20,30,0,3121,22,0,22,0,0,r1,u9);
		Matiere m44=new Matiere("Develepement Web",2F,1F,60,20,20,0,4122,22,0,22,0,0,r1,u9);

		Matiere m55=new Matiere("Ingenierie de base de donnees",3F,1.5F,50,20,30,0,4131,22,22,0,0,0,r1,u10);
		Matiere m66=new Matiere("Conception de systeme d information",3F,1.5F,60,20,20,0,4132,22,22,0,0,22,r1,u10);

		Matiere m77=new Matiere("Reseaux informatiques",3F,1.5F,50,20,30,0,4141,22,11,11,0,0,r1,u11);
		Matiere m88=new Matiere("Systeme d'exploitation 2",3F,1.5F,50,20,30,0,4142,22,11,11,0,0,r1,u11);

		Matiere m100=new Matiere("Anglais 4",2F,1F,80,10,0,10,4151,22,0,0,0,0,r2,u12);
		Matiere m1110=new Matiere("Français 4",2F,1F,80,10,0,10,4152,22,0,0,0,0,r2,u12);

		matiere.save(m111);matiere.save(m22);matiere.save(m33);matiere.save(m44);matiere.save(m55);matiere.save(m66);matiere.save(m77);matiere.save(m88);
		matiere.save(m100);matiere.save(m1110);

		r1.addMatiere(m1);
		r1.addMatiere(m2);
		r1.addMatiere(m3);
		r1.addMatiere(m4);
		r1.addMatiere(m5);
		r1.addMatiere(m6);
		r1.addMatiere(m7);
		r1.addMatiere(m8);
		r1.addMatiere(m9);
		r2.addMatiere(m10);
		r2.addMatiere(m11);

		r1.addMatiere(m111);
		r1.addMatiere(m22);
		r1.addMatiere(m33);
		r1.addMatiere(m44);
		r1.addMatiere(m55);
		r1.addMatiere(m66);
		r1.addMatiere(m77);
		r1.addMatiere(m88);
		r2.addMatiere(m100);
		r2.addMatiere(m1110);

		u1.addMatiere(m1);
		u1.addMatiere(m2);
		u2.addMatiere(m3);
		u3.addMatiere(m4);
		u3.addMatiere(m5);
		u4.addMatiere(m6);
		u4.addMatiere(m7);
		u5.addMatiere(m10);
		u5.addMatiere(m11);
		u6.addMatiere(m8);
		u6.addMatiere(m9);

		u7.addMatiere(m111);
		u8.addMatiere(m22);
		u9.addMatiere(m33);
		u9.addMatiere(m44);
		u10.addMatiere(m55);
		u10.addMatiere(m66);
		u11.addMatiere(m77);
		u11.addMatiere(m88);
		u12.addMatiere(m100);
		u12.addMatiere(m1110);

		Niveau niveauCPI2= new Niveau("2éme annéé",new HashSet<Semestre>());
		niveau.save(niveauCPI2);

		Semestre sem1CPI2=new Semestre("Semestre 1", niveauCPI2,new HashSet<Unite>());
		semestre.save(sem1CPI2);

		Semestre sem2CPI2=new Semestre("Semestre 2", niveauCPI2,new HashSet<Unite>());
		semestre.save(sem2CPI2);

		niveauCPI2.addSemestre(sem1CPI2);
		niveauCPI2.addSemestre(sem2CPI2);


		u1.addSemestre(sem1CPI2);
		u2.addSemestre(sem1CPI2);
		u3.addSemestre(sem1CPI2);
		u4.addSemestre(sem1CPI2);
		u5.addSemestre(sem1CPI2);
		u6.addSemestre(sem1CPI2);

		u7.addSemestre(sem2CPI2);
		u8.addSemestre(sem2CPI2);
		u9.addSemestre(sem2CPI2);
		u10.addSemestre(sem2CPI2);
		u11.addSemestre(sem2CPI2);
		u12.addSemestre(sem2CPI2);


		sem1CPI2.addUnite(u1);
		sem1CPI2.addUnite(u2);
		sem1CPI2.addUnite(u3);
		sem1CPI2.addUnite(u4);
		sem1CPI2.addUnite(u5);
		sem1CPI2.addUnite(u6);


		sem2CPI2.addUnite(u7);
		sem2CPI2.addUnite(u8);
		sem2CPI2.addUnite(u9);
		sem2CPI2.addUnite(u10);
		sem2CPI2.addUnite(u11);
		sem2CPI2.addUnite(u12);


		Section cpi2= new Section("CPI2",sem1CPI2,new HashSet<>());
		cpi2.setSemestre2(sem2CPI2);
		section.save(cpi2);


		TD td1CPI2= new TD("TD1",cpi2,new HashSet<TP>(),new HashSet<Etudiant>());
		td.save(td1CPI2);


		TP tp1CPI2= new TP("TP1",td1CPI2);
		TP tp2CPI2= new TP("TP2",td1CPI2);

		tp.save(tp1CPI2);tp.save(tp2CPI2);


		td1CPI2.addTp(tp1CPI2);
		td1CPI2.addTp(tp2CPI2);

		cpi2.addTd(td1CPI2);

		Etudiant e1= new Etudiant("13507341","Abassi","Ghada",new Date(), Sexe.FEMME,"Monastir","123456789","Ghada@gmail.com","23569852",22,td1CPI2,tp1CPI2);
		Etudiant e2= new Etudiant("14009108","Ben Abdallah","Syrine",new Date(), Sexe.FEMME,"Monastir","123456789","sirinebenabdallah092@gmail.com","24569321",22,td1CPI2,tp1CPI2);
		Etudiant e3= new Etudiant("11985827","Ben Slama","Haithem",new Date(), Sexe.HOMME,"Monastir","123456789","Haithem.benslama@hotmail.fr","27660834",22,td1CPI2,tp1CPI2);
		Etudiant e4= new Etudiant("14020786","Bouzgarrou","Fatma",new Date(), Sexe.FEMME,"Monastir","123456789","fatmabouzgarrou6@gmail.com","29856352",22,td1CPI2,tp1CPI2);
		Etudiant e5= new Etudiant("14007249","Chaftar","Ghazi",new Date(), Sexe.HOMME,"Monastir","123456789","ghazichaftar@gmail.com","21452365",22,td1CPI2,tp1CPI2);
		Etudiant e6= new Etudiant("12880792","Chiba","Tasnim",new Date(), Sexe.FEMME,"Monastir","123456789","tasnimchiba@gmail.com","23456859",22,td1CPI2,tp1CPI2);
		Etudiant e7= new Etudiant("14020269","Elayeb","Oussema",new Date(), Sexe.HOMME,"Monastir","123456789","elayeb.oussama2020@gmail.com","98532012",22,td1CPI2,tp1CPI2);
		Etudiant e8= new Etudiant("12861799","Ferjani","Nader",new Date(), Sexe.HOMME,"Monastir","123456789","ferjani.nader@hotmail.fr","99632015",22,td1CPI2,tp1CPI2);
		Etudiant e9= new Etudiant("14657285","Gharouel","Fatma",new Date(), Sexe.FEMME,"Monastir","123456789","gharouelfatma@gmail.com","98152360",22,td1CPI2,tp1CPI2);
		Etudiant e10= new Etudiant("11984839","Guesmi","Molka",new Date(), Sexe.FEMME,"Monastir","123456789","molka.guesmi20@gmail.com","96321458",22,td1CPI2,tp1CPI2);
		Etudiant e11= new Etudiant("13281794","Guiza","Asma",new Date(), Sexe.FEMME,"Monastir","123456789","Asma.guiza@ieee.org","96472013",22,td1CPI2,tp1CPI2);
		Etudiant e12= new Etudiant("12876936","Hajri","Kais",new Date(), Sexe.HOMME,"Monastir","123456789","kais.hajri01@gmail.com","96321582",22,td1CPI2,tp1CPI2);
		Etudiant e13= new Etudiant("12849683","Hamila","Ahmed",new Date(), Sexe.HOMME,"Monastir","123456789","csahmed17@gmail.com","24563180",22,td1CPI2,tp1CPI2);
		Etudiant e14= new Etudiant("14030800","Ibrahim","Achraf",new Date(), Sexe.HOMME,"Monastir","123456789","achrefibrahim215@gmail.com","26482395",22,td1CPI2,tp2CPI2);
		Etudiant e15= new Etudiant("14028682","Khelil","Imen",new Date(), Sexe.FEMME,"Monastir","123456789","imenkhalil2001@gmail.com","21563298",22,td1CPI2,tp2CPI2);
		Etudiant e16= new Etudiant("13279386","Maatoug","Amal",new Date(), Sexe.FEMME,"Monastir","123456789","maatougamal1@gmail.com","24963282",22,td1CPI2,tp2CPI2);
		Etudiant e17= new Etudiant("09643732","Matallah","Mariem",new Date(), Sexe.FEMME,"Monastir","123456789","mkdmeriam22@gmail.com","29635824",22,td1CPI2,tp2CPI2);
		Etudiant e18= new Etudiant("14029071","Miled","Yessine",new Date(), Sexe.HOMME,"Monastir","123456789","miled.yassine7@gmail.com","29786325",22,td1CPI2,tp2CPI2);
		Etudiant e19= new Etudiant("14024228","Naouar","Mohamed",new Date(), Sexe.HOMME,"Monastir","123456789","naouarm769@gmail.com","28649532",22,td1CPI2,tp2CPI2);
		Etudiant e20= new Etudiant("11156573","Omrane","Yosra",new Date(), Sexe.FEMME,"Monastir","123456789","yosraomran@gmail.com","29786352",22,td1CPI2,tp2CPI2);
		Etudiant e21= new Etudiant("14418106","Riahi","Farah",new Date(), Sexe.FEMME,"Monastir","123456789","riahi.farah2@gmail.com","29652345",22,td1CPI2,tp2CPI2);
		Etudiant e22= new Etudiant("12873880","Rouis","Nour",new Date(), Sexe.FEMME,"Monastir","123456789","nourrouis0@gmail.com","24963856",22,td1CPI2,tp2CPI2);
		Etudiant e23= new Etudiant("14024333","Saidane","Yassine",new Date(), Sexe.HOMME,"Monastir","123456789","yassinesaidoune003@gmail.com","27415630",22,td1CPI2,tp2CPI2);
		Etudiant e24= new Etudiant("14322733","Sghaier","Mazen",new Date(), Sexe.HOMME,"Monastir","123456789","Sghaiermazen7@gmail.com","97863425",22,td1CPI2,tp2CPI2);
		Etudiant e25= new Etudiant("09643569","Tayari","Belhassen",new Date(), Sexe.HOMME,"Monastir","123456789","belhassentayari09@gmail.com","20324571",22,td1CPI2,tp2CPI2);
		Etudiant e26= new Etudiant("11152975","Trabelsi","Ibrahim",new Date(), Sexe.HOMME,"Monastir","123456789","ib03092001@gmail.com","29864523",22,td1CPI2,tp2CPI2);
		Etudiant e27= new Etudiant("14011853","Zahaf","Ahmed",new Date(), Sexe.HOMME,"Monastir","123456789","zahafahmed135@gmail.com","55693285",22,td1CPI2,tp2CPI2);
		List<Etudiant> etudiantList = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,e23,e24,e25,e26,e27);
		etudiant.saveAll(etudiantList);

		td1CPI2.addEtudiant(e1);td1CPI2.addEtudiant(e2);td1CPI2.addEtudiant(e3);td1CPI2.addEtudiant(e4);td1CPI2.addEtudiant(e5);td1CPI2.addEtudiant(e6);td1CPI2.addEtudiant(e7);
		td1CPI2.addEtudiant(e8);td1CPI2.addEtudiant(e9);td1CPI2.addEtudiant(e10);td1CPI2.addEtudiant(e11);td1CPI2.addEtudiant(e12);td1CPI2.addEtudiant(e13);td1CPI2.addEtudiant(e14);
		td1CPI2.addEtudiant(e15);td1CPI2.addEtudiant(e16);td1CPI2.addEtudiant(e17);td1CPI2.addEtudiant(e18);td1CPI2.addEtudiant(e19);td1CPI2.addEtudiant(e20);td1CPI2.addEtudiant(e21);
		td1CPI2.addEtudiant(e22);td1CPI2.addEtudiant(e23);td1CPI2.addEtudiant(e24);td1CPI2.addEtudiant(e25);td1CPI2.addEtudiant(e26);td1CPI2.addEtudiant(e27);

		tp1CPI2.addEtudiant(e1);tp1CPI2.addEtudiant(e2);tp1CPI2.addEtudiant(e3);tp1CPI2.addEtudiant(e4);tp1CPI2.addEtudiant(e5);tp1CPI2.addEtudiant(e6);tp1CPI2.addEtudiant(e7);
		tp1CPI2.addEtudiant(e8);tp1CPI2.addEtudiant(e9);tp1CPI2.addEtudiant(e10);tp1CPI2.addEtudiant(e11);tp1CPI2.addEtudiant(e12);tp1CPI2.addEtudiant(e13);

		tp2CPI2.addEtudiant(e14);tp2CPI2.addEtudiant(e15);tp2CPI2.addEtudiant(e16);tp2CPI2.addEtudiant(e17);tp2CPI2.addEtudiant(e18);tp2CPI2.addEtudiant(e19);tp2CPI2.addEtudiant(e20);
		tp2CPI2.addEtudiant(e21);tp2CPI2.addEtudiant(e22);tp2CPI2.addEtudiant(e23);tp2CPI2.addEtudiant(e24);tp2CPI2.addEtudiant(e25);tp2CPI2.addEtudiant(e26);tp2CPI2.addEtudiant(e27);



		Diplome diplomeCPI2 = new Diplome("Préparatoire Integré en Informatique", new HashSet<Niveau>());

		diplomeCPI2.addNiveau(niveauCPI2);
		diplome.save(diplomeCPI2);
		niveauCPI2.setDiplome(diplomeCPI2);


		EnseignantMatiere enseignantMatiere1= new EnseignantMatiere(en19,m5,Session.TP,Groups.TP, tp1CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere2= new EnseignantMatiere(en19,m5,Session.TP,Groups.TP, tp2CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere3= new EnseignantMatiere(en20,m2,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere4= new EnseignantMatiere(en7,m10,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere5= new EnseignantMatiere(en21,m6,Session.TP,Groups.TP, tp1CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere6= new EnseignantMatiere(en21,m6,Session.TP,Groups.TP, tp2CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere7= new EnseignantMatiere(en5,m3,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere8= new EnseignantMatiere(en2,m5,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere9= new EnseignantMatiere(en23,m1,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere10= new EnseignantMatiere(en22,m11,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere11= new EnseignantMatiere(en24,m8,Session.TP,Groups.TP, tp2CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere12= new EnseignantMatiere(en15,m6,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere13= new EnseignantMatiere(en15,m8,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere14= new EnseignantMatiere(en14,m4,Session.CR,Groups.SECTION, cpi2.getIdSection());

		EnseignantMatiere enseignantMatiere15= new EnseignantMatiere(en4,m111,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere16= new EnseignantMatiere(en4,m111,Session.TD,Groups.TD, td1CPI2.getIdTd());


		EnseignantMatiere enseignantMatiere17= new EnseignantMatiere(en5,m22,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere18= new EnseignantMatiere(en5,m22,Session.TD,Groups.TD, td1CPI2.getIdTd());


		EnseignantMatiere enseignantMatiere19= new EnseignantMatiere(en15,m33,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere20= new EnseignantMatiere(en21,m33,Session.TP,Groups.TP, tp1CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere21= new EnseignantMatiere(en21,m33,Session.TP,Groups.TP, tp2CPI2.getIdTp());



		EnseignantMatiere enseignantMatiere22= new EnseignantMatiere(en8,m44,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere23= new EnseignantMatiere(en11,m44,Session.TP,Groups.TP, tp1CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere24= new EnseignantMatiere(en11,m44,Session.TP,Groups.TP, tp2CPI2.getIdTp());


		EnseignantMatiere enseignantMatiere25= new EnseignantMatiere(en15,m55,Session.CR,Groups.SECTION,cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere26= new EnseignantMatiere(en15,m55,Session.TP,Groups.TP, tp1CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere27= new EnseignantMatiere(en15,m55,Session.TP,Groups.TP, tp2CPI2.getIdTp());


		EnseignantMatiere enseignantMatiere28= new EnseignantMatiere(en13,m66,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere29= new EnseignantMatiere(en13,m66,Session.TP,Groups.TP, tp1CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere30= new EnseignantMatiere(en13,m66,Session.TP,Groups.TP, tp2CPI2.getIdTp());


		EnseignantMatiere enseignantMatiere31= new EnseignantMatiere(en14,m77,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere32= new EnseignantMatiere(en17,m77,Session.TP,Groups.TP, tp1CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere33= new EnseignantMatiere(en17,m77,Session.CR,Groups.SECTION, tp1CPI2.getIdTp());

		EnseignantMatiere enseignantMatiere34= new EnseignantMatiere(en2,m88,Session.CR,Groups.SECTION, cpi2.getIdSection());
		EnseignantMatiere enseignantMatiere35= new EnseignantMatiere(en19,m88,Session.TP,Groups.TP, tp1CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere36= new EnseignantMatiere(en19,m88,Session.TP,Groups.TP, tp2CPI2.getIdTp());


		EnseignantMatiere enseignantMatiere37= new EnseignantMatiere(en7,m100,Session.CR,Groups.SECTION, td1CPI2.getIdTd());
		EnseignantMatiere enseignantMatiere38= new EnseignantMatiere(en7,m100,Session.TP,Groups.TD, td1CPI2.getIdTd());

		EnseignantMatiere enseignantMatiere39= new EnseignantMatiere(en22,m88,Session.CR,Groups.SECTION, tp1CPI2.getIdTp());
		EnseignantMatiere enseignantMatiere40= new EnseignantMatiere(en22,m88,Session.TD,Groups.TD, td1CPI2.getIdTd());





		enseignantMatiere1.setSemestre(sem1CPI2);
		enseignantMatiere2.setSemestre(sem1CPI2);
		enseignantMatiere3.setSemestre(sem1CPI2);
		enseignantMatiere4.setSemestre(sem1CPI2);
		enseignantMatiere5.setSemestre(sem1CPI2);
		enseignantMatiere6.setSemestre(sem1CPI2);
		enseignantMatiere7.setSemestre(sem1CPI2);
		enseignantMatiere8.setSemestre(sem1CPI2);
		enseignantMatiere9.setSemestre(sem1CPI2);
		enseignantMatiere10.setSemestre(sem1CPI2);
		enseignantMatiere11.setSemestre(sem1CPI2);
		enseignantMatiere12.setSemestre(sem1CPI2);
		enseignantMatiere13.setSemestre(sem1CPI2);
		enseignantMatiere14.setSemestre(sem1CPI2);

		enseignantMatiere15.setSemestre(sem2CPI2);
		enseignantMatiere16.setSemestre(sem2CPI2);
		enseignantMatiere17.setSemestre(sem2CPI2);
		enseignantMatiere18.setSemestre(sem2CPI2);
		enseignantMatiere19.setSemestre(sem2CPI2);
		enseignantMatiere20.setSemestre(sem2CPI2);
		enseignantMatiere21.setSemestre(sem2CPI2);
		enseignantMatiere22.setSemestre(sem2CPI2);
		enseignantMatiere23.setSemestre(sem2CPI2);
		enseignantMatiere24.setSemestre(sem2CPI2);
		enseignantMatiere25.setSemestre(sem2CPI2);
		enseignantMatiere26.setSemestre(sem2CPI2);
		enseignantMatiere27.setSemestre(sem2CPI2);
		enseignantMatiere28.setSemestre(sem2CPI2);
		enseignantMatiere29.setSemestre(sem2CPI2);
		enseignantMatiere30.setSemestre(sem2CPI2);
		enseignantMatiere31.setSemestre(sem2CPI2);
		enseignantMatiere32.setSemestre(sem2CPI2);
		enseignantMatiere33.setSemestre(sem2CPI2);
		enseignantMatiere34.setSemestre(sem2CPI2);
		enseignantMatiere35.setSemestre(sem2CPI2);
		enseignantMatiere36.setSemestre(sem2CPI2);
		enseignantMatiere37.setSemestre(sem2CPI2);
		enseignantMatiere38.setSemestre(sem2CPI2);
		enseignantMatiere39.setSemestre(sem2CPI2);
		enseignantMatiere40.setSemestre(sem2CPI2);

		enseignantMatiere.save(enseignantMatiere1);enseignantMatiere.save(enseignantMatiere2);enseignantMatiere.save(enseignantMatiere3);
		enseignantMatiere.save(enseignantMatiere4);enseignantMatiere.save(enseignantMatiere5);enseignantMatiere.save(enseignantMatiere6);
		enseignantMatiere.save(enseignantMatiere7);enseignantMatiere.save(enseignantMatiere8);enseignantMatiere.save(enseignantMatiere9);
		enseignantMatiere.save(enseignantMatiere10);enseignantMatiere.save(enseignantMatiere11);enseignantMatiere.save(enseignantMatiere12);
		enseignantMatiere.save(enseignantMatiere13);enseignantMatiere.save(enseignantMatiere14);enseignantMatiere.save(enseignantMatiere15);
		enseignantMatiere.save(enseignantMatiere16);enseignantMatiere.save(enseignantMatiere17);enseignantMatiere.save(enseignantMatiere18);
		enseignantMatiere.save(enseignantMatiere19);enseignantMatiere.save(enseignantMatiere20);enseignantMatiere.save(enseignantMatiere21);
		enseignantMatiere.save(enseignantMatiere22);enseignantMatiere.save(enseignantMatiere23);enseignantMatiere.save(enseignantMatiere24);
		enseignantMatiere.save(enseignantMatiere25);enseignantMatiere.save(enseignantMatiere26);enseignantMatiere.save(enseignantMatiere27);
		enseignantMatiere.save(enseignantMatiere28);enseignantMatiere.save(enseignantMatiere29);enseignantMatiere.save(enseignantMatiere30);
		enseignantMatiere.save(enseignantMatiere31);enseignantMatiere.save(enseignantMatiere32);enseignantMatiere.save(enseignantMatiere33);
		enseignantMatiere.save(enseignantMatiere34);enseignantMatiere.save(enseignantMatiere35);enseignantMatiere.save(enseignantMatiere36);
		enseignantMatiere.save(enseignantMatiere37);enseignantMatiere.save(enseignantMatiere38);enseignantMatiere.save(enseignantMatiere39);
		enseignantMatiere.save(enseignantMatiere40);


		/*----------------------------------Update-------------------------------------------*/

		departement.save(d1);
		departement.save(d2);
		departement.save(d3);
		departement.save(d4);

		enseignant.save(en1);
		enseignant.save(en2);
		enseignant.save(en3);
		enseignant.save(en4);
		enseignant.save(en5);
		enseignant.save(en6);
		enseignant.save(en7);
		enseignant.save(en8);
		enseignant.save(en9);
		enseignant.save(en10);
		enseignant.save(en11);
		enseignant.save(en12);
		enseignant.save(en13);
		enseignant.save(en14);
		enseignant.save(en15);
		enseignant.save(en16);
		enseignant.save(en17);
		enseignant.save(en18);
		enseignant.save(en19);
		enseignant.save(en20);
		enseignant.save(en21);
		enseignant.save(en22);
		enseignant.save(en23);
		enseignant.save(en24);

		unite.save(u1);unite.save(u2);unite.save(u3);unite.save(u4);unite.save(u5);unite.save(u6);

		matiere.save(m1);matiere.save(m2);matiere.save(m3);matiere.save(m4);matiere.save(m5);matiere.save(m6);matiere.save(m7);matiere.save(m8);
		matiere.save(m9);matiere.save(m10);matiere.save(m11);

		unite.save(u7);unite.save(u8);unite.save(u9);unite.save(u10);unite.save(u11);unite.save(u12);

		matiere.save(m111);matiere.save(m22);matiere.save(m33);matiere.save(m44);matiere.save(m55);matiere.save(m66);matiere.save(m77);matiere.save(m88);
		matiere.save(m100);matiere.save(m1110);

		niveau.save(niveauCPI2);

		semestre.save(sem1CPI2);

		section.save(cpi2);

		td.save(td1CPI2);

		tp.save(tp1CPI2);tp.save(tp2CPI2);

		etudiant.saveAll(etudiantList);

		diplome.save(diplomeCPI2);
	}
}
