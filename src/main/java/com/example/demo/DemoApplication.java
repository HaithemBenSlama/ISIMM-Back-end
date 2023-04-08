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
		Enseignant en3= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223366","Ramzi","Mahmoudi",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","ramzi.mahmoudi@gmail.com","23012565",41,new Date(),40,20,2500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en4= new Enseignant(d4,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223377","Hedia","Sahlia",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","Hedia.sehlia@gmail.com","23654895",42,new Date(),40,20,1500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en5= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223388","Mariem","Gzara",new Date(),Sexe.FEMME,"Monastir ISIMM","azerty123","mariem.gzara@gmail.com","22452302",39,new Date(),40,20,1200F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en6= new Enseignant(d4,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223399","Ilhem","Belkahla",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","ilhem.belkahla@gmail.com","25360123",30,new Date(),40,20,1500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en7= new Enseignant(d4,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11223322","Soumaya","Ben Aycha",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","soumaya.benaycha@gmail.com","29856325",30,new Date(),40,20,1500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en8= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"12001244","Sami","Bhiri",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","sami.bhiri@gmail.com","25369210",39,new Date(),40,20,2500F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en9= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"12001255","Taher","Khadhraoui",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","taher.khadhraoui@gmail.com","25364820",32,new Date(),40,20,1200F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en10= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"12001266","Azza","Chebil",new Date(), Sexe.FEMME,"Monastir ISIMM","azerty123","azza.chabil@gmail.com","23698520",39,new Date(),40,20,1200F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.PROF);
		Enseignant en11= new Enseignant(d1,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"12001277","Malek","Ben Salem",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","malek.benSalem@gmail.com","24563282",39,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);
		Enseignant en12= new Enseignant(d3,new HashSet<DemandeConger>(),new HashSet<DemandeStockable>(),new HashSet<Service>(),"11365259","Ahmed","Boughamoura",new Date(), Sexe.HOMME,"Monastir ISIMM","azerty123","ahmed.boughamoura@gmail.com","97523642",55,new Date(),40,20,2000F,new HashSet<Voeux>(),new HashSet<EnseignantMatiere>(),new HashSet<Note>(),20.3F, Grade.MAITRE);


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


		d1.setChefDepartement(en1);
		d3.setChefDepartement(en12);
		d4.setChefDepartement(en7);

		d1.addEnseignant(en1);
		d1.addEnseignant(en2);
		d1.addEnseignant(en3);
		d1.addEnseignant(en5);
		d1.addEnseignant(en8);
		d1.addEnseignant(en9);
		d1.addEnseignant(en10);
		d1.addEnseignant(en11);

		d3.addEnseignant(en12);

		d4.addEnseignant(en4);
		d4.addEnseignant(en6);
		d4.addEnseignant(en7);



		Unite u1= new Unite(511,"Analyse descriptive 1",3.0F,6F);
		Unite u2= new Unite(512,"Structures de données avancées",3.0F,6F);
		Unite u3= new Unite(513,"Ingénierie des systèmes informatiques",2.0F,4F);
		Unite u4= new Unite(514,"Programmation Web et mobile",4.0F,8F);
		Unite u5= new Unite(515,"Transversale 5",3.0F,6F);

		unite.save(u1);unite.save(u2);unite.save(u3);unite.save(u4);unite.save(u5);

		Regime r1= new Regime("Mixte",3,22,0,22,0,0,new HashSet<Matiere>());
		Regime r2= new Regime("Controle continu",2,22,0,0,0,0,new HashSet<Matiere>());

		regime.save(r1);regime.save(r2);

		Matiere m1=new Matiere("Analyse de données",3F,1.5F,50,20,30,0,5111,22,0,22,0,0,r1,u1);
		Matiere m2=new Matiere("Mathématiques des réseaux de neurones",3F,1.5F,50,20,30,0,5112,22,0,22,0,0,r1,u1);

		Matiere m3=new Matiere("Structures de données avancées en Python",3F,1.5F,50,20,30,0,5121,22,0,22,0,0,r1,u2);
		Matiere m4=new Matiere("Techniques de construction d’analyseurs lexico-syntaxiques",3F,1.5F,60,20,20,0,5122,22,0,22,0,0,r1,u2);

		Matiere m5=new Matiere("Applications logicielles d'entreprise",2F,1F,50,20,30,0,5131,22,0,22,0,0,r1,u3);
		Matiere m6=new Matiere("Modélisation UML/OCL",2F,1F,60,20,20,0,5132,22,0,0,0,22,r1,u3);

		Matiere m7=new Matiere("Programmation Web avancée",3F,1.5F,50,20,30,0,5141,22,0,22,0,0,r1,u4);
		Matiere m8=new Matiere("Programmation mobile",2F,1.5F,50,20,30,0,5142,22,0,22,0,0,r1,u4);
		Matiere m9=new Matiere("Projet Web/mobile",2F,1F,0,0,100,0,5143,0,0,0,0,22,r2,u4);

		Matiere m10=new Matiere("Anglais – certification 1",2F,1F,80,10,0,10,5151,22,0,0,0,0,r2,u5);
		Matiere m11=new Matiere("Français – certification 2",2F,1F,80,10,0,10,5152,22,0,0,0,0,r2,u5);
		Matiere m12=new Matiere("Techniques de communication 1 : communication et connaissance du soi",2F,1F,80,10,0,10,5153,22,0,0,0,0,r2,u5);


		matiere.save(m1);matiere.save(m2);matiere.save(m3);matiere.save(m4);matiere.save(m5);matiere.save(m6);matiere.save(m7);matiere.save(m8);
		matiere.save(m9);matiere.save(m10);matiere.save(m11);matiere.save(m12);


		r1.addMatiere(m1);
		r1.addMatiere(m2);
		r1.addMatiere(m3);
		r1.addMatiere(m4);
		r1.addMatiere(m5);
		r1.addMatiere(m6);
		r1.addMatiere(m7);
		r1.addMatiere(m8);
		r2.addMatiere(m9);
		r2.addMatiere(m10);
		r2.addMatiere(m11);
		r2.addMatiere(m12);



		u1.addMatiere(m1);
		u1.addMatiere(m2);
		u2.addMatiere(m3);
		u2.addMatiere(m4);
		u3.addMatiere(m5);
		u3.addMatiere(m6);
		u4.addMatiere(m7);
		u4.addMatiere(m8);
		u4.addMatiere(m9);
		u5.addMatiere(m10);
		u5.addMatiere(m11);
		u5.addMatiere(m12);


		Niveau niveau1= new Niveau("1ére année",new HashSet<Semestre>());
		niveau.save(niveau1);

		Niveau niveauCPI1= new Niveau("1ére annéé",new HashSet<Semestre>());
		niveau.save(niveauCPI1);

		Semestre sem1=new Semestre("Semestre 1", niveau1,new HashSet<Unite>());
		semestre.save(sem1);

		Semestre sem1CPI1=new Semestre("Semestre 1", niveauCPI1,new HashSet<Unite>());
		semestre.save(sem1CPI1);


		niveau1.addSemestre(sem1);
		niveauCPI1.addSemestre(sem1CPI1);


		u1.addSemestre(sem1);
		u2.addSemestre(sem1);
		u3.addSemestre(sem1);
		u4.addSemestre(sem1);
		u5.addSemestre(sem1);

		u1.addSemestre(sem1CPI1);
		u2.addSemestre(sem1CPI1);
		u3.addSemestre(sem1CPI1);


		sem1.addUnite(u1);
		sem1.addUnite(u2);
		sem1.addUnite(u3);
		sem1.addUnite(u4);
		sem1.addUnite(u5);

		sem1CPI1.addUnite(u1);
		sem1CPI1.addUnite(u2);
		sem1CPI1.addUnite(u3);



		Section s1= new Section("ING_INF_1",sem1,new HashSet<TD>());
		section.save(s1);

		Section s2= new Section("CPI1",sem1CPI1,new HashSet<TD>());
		section.save(s2);

		TD td1= new TD("TD1",s1,new HashSet<TP>(),new HashSet<Etudiant>());
		td.save(td1);

		TD td2= new TD("TD2",s1,new HashSet<TP>(),new HashSet<Etudiant>());
		td.save(td2);

		TD td1CPI1= new TD("TD1",s2,new HashSet<TP>(),new HashSet<Etudiant>());
		td.save(td1CPI1);


		TP tp1= new TP("TP1",td1);

		TP tp2= new TP("TP2",td1);
		TP tp3= new TP("TP3",td2);
		tp.save(tp1);tp.save(tp2);tp.save(tp3);

		TP tp1CPI1= new TP("TP1",td1CPI1);
		TP tp2CPI1= new TP("TP2",td1CPI1);
		tp.save(tp1CPI1);tp.save(tp2CPI1);

		td1.addTp(tp1);
		td1.addTp(tp2);
		td2.addTp(tp3);

		td1CPI1.addTp(tp1CPI1);
		td1CPI1.addTp(tp2CPI1);


		s1.addTd(td1);
		s1.addTd(td2);
		s2.addTd(td1CPI1);

		Etudiant e1= new Etudiant("13507341","Abassi","Ghada",new Date(), Sexe.FEMME,"Monastir","123456789","Ghada@gmail.com","23569852",22,td1,tp1);
		Etudiant e2= new Etudiant("14009108","Ben Abdallah","Syrine",new Date(), Sexe.FEMME,"Monastir","123456789","syrine@gmail.com","24569321",22,td1,tp1);
		Etudiant e3= new Etudiant("11985827","Ben Slama","Haithem",new Date(), Sexe.HOMME,"Monastir","123456789","Haithem@gmail.com","27660834",22,td1,tp1);
		Etudiant e4= new Etudiant("14020786","Bouzgarrou","Fatma",new Date(), Sexe.FEMME,"Monastir","123456789","fatma@gmail.com","29856352",22,td1,tp1);
		Etudiant e5= new Etudiant("14007249","Chaftar","Ghazi",new Date(), Sexe.HOMME,"Monastir","123456789","ghazi@gmail.com","21452365",22,td1,tp1);
		Etudiant e6= new Etudiant("12880792","Chiba","Tasnim",new Date(), Sexe.FEMME,"Monastir","123456789","tasnim@gmail.com","23456859",22,td1,tp1);
		Etudiant e7= new Etudiant("14020269","Elayeb","Oussema",new Date(), Sexe.HOMME,"Monastir","123456789","oussama@gmail.com","98532012",22,td1,tp1);
		Etudiant e8= new Etudiant("12861799","Ferjani","Nader",new Date(), Sexe.HOMME,"Monastir","123456789","nader@gmail.com","99632015",22,td1,tp1);
		Etudiant e9= new Etudiant("14657285","Gharouel","Fatma",new Date(), Sexe.FEMME,"Monastir","123456789","fatmaGharouel@gmail.com","98152360",22,td1,tp1);
		Etudiant e10= new Etudiant("11984839","Guesmi","Molka",new Date(), Sexe.FEMME,"Monastir","123456789","molka@gmail.com","96321458",22,td1,tp1);
		Etudiant e11= new Etudiant("13281794","Guiza","Asma",new Date(), Sexe.FEMME,"Monastir","123456789","asma@gmail.com","96472013",22,td1,tp1);
		Etudiant e12= new Etudiant("12876936","Hajri","Kais",new Date(), Sexe.HOMME,"Monastir","123456789","kais@gmail.com","96321582",22,td1,tp1);
		Etudiant e13= new Etudiant("12849683","Hamila","Ahmed",new Date(), Sexe.HOMME,"Monastir","123456789","ahmedHamila@gmail.com","24563180",22,td1,tp1);
		Etudiant e14= new Etudiant("14030800","Ibrahim","Achraf",new Date(), Sexe.HOMME,"Monastir","123456789","achraf@gmail.com","26482395",22,td1,tp2);
		Etudiant e15= new Etudiant("14028682","Khelil","Imen",new Date(), Sexe.FEMME,"Monastir","123456789","imen@gmail.com","21563298",22,td1,tp2);
		Etudiant e16= new Etudiant("13279386","Maatoug","Amal",new Date(), Sexe.FEMME,"Monastir","123456789","amal@gmail.com","24963282",22,td1,tp2);
		Etudiant e17= new Etudiant("09643732","Matallah","Mariem",new Date(), Sexe.FEMME,"Monastir","123456789","mariem@gmail.com","29635824",22,td1,tp2);
		Etudiant e18= new Etudiant("14029071","Miled","Yassine",new Date(), Sexe.HOMME,"Monastir","123456789","yessine@gmail.com","29786325",22,td1,tp2);
		Etudiant e19= new Etudiant("14024228","Naouar","Mohamed",new Date(), Sexe.HOMME,"Monastir","123456789","mohamed@gmail.com","28649532",22,td1,tp2);
		Etudiant e20= new Etudiant("11156573","Omrane","Yosra",new Date(), Sexe.FEMME,"Monastir","123456789","yosra@gmail.com","29786352",22,td1,tp2);
		Etudiant e21= new Etudiant("14418106","Riahi","Farah",new Date(), Sexe.FEMME,"Monastir","123456789","farah@gmail.com","29652345",22,td1,tp2);
		Etudiant e22= new Etudiant("12873880","Rouis","Nour",new Date(), Sexe.FEMME,"Monastir","123456789","nour@gmail.com","24963856",22,td1,tp2);
		Etudiant e23= new Etudiant("14024333","Saidane","Yassine",new Date(), Sexe.HOMME,"Monastir","123456789","yassine@gmail.com","27415630",22,td1,tp2);
		Etudiant e24= new Etudiant("14322733","Sghaier","Mazen",new Date(), Sexe.HOMME,"Monastir","123456789","mazen@gmail.com","97863425",22,td1,tp2);
		Etudiant e25= new Etudiant("09643569","Tayari","Belhassen",new Date(), Sexe.HOMME,"Monastir","123456789","belhassen@gmail.com","20324571",22,td1,tp2);
		Etudiant e26= new Etudiant("11152975","Trabelsi","Ibrahim",new Date(), Sexe.HOMME,"Monastir","123456789","ibrahim@gmail.com","29864523",22,td1,tp2);
		Etudiant e27= new Etudiant("14011853","Zahaf","Ahmed",new Date(), Sexe.HOMME,"Monastir","123456789","ahmed@gmail.com","55693285",22,td1,tp2);
		Etudiant e28 = new Etudiant("14011801", "Murray", "Audrey", new Date(), Sexe.FEMME, "Sfax", "123456789", "murray_audrey@gmail.com", "52671928", 21, td2, tp3);
		Etudiant e29 = new Etudiant("14011802", "Hill", "Cameron", new Date(), Sexe.HOMME, "Tunis", "123456789", "hill_cameron@gmail.com", "53102846", 20, td2, tp3);
		Etudiant e30 = new Etudiant("14011803", "Scott", "Naomi", new Date(), Sexe.FEMME, "Gabes", "123456789", "scott_naomi@gmail.com", "55679012", 23, td2, tp3);
		Etudiant e31 = new Etudiant("14011804", "Watson", "Louis", new Date(), Sexe.HOMME, "Sousse", "123456789", "watson_louis@gmail.com", "55371928", 20, td2, tp3);
		Etudiant e32 = new Etudiant("14011805", "Black", "Evelyn", new Date(), Sexe.FEMME, "Nabeul", "123456789", "black_evelyn@gmail.com", "52341027", 21, td2, tp3);
		Etudiant e33 = new Etudiant("14011806", "Reed", "Evan", new Date(), Sexe.HOMME, "Bizerte", "123456789", "reed_evan@gmail.com", "57021536", 22, td2, tp3);
		Etudiant e34 = new Etudiant("14011807", "Gonzalez", "Makayla", new Date(), Sexe.FEMME, "Sfax", "123456789", "gonzalez_makayla@gmail.com", "55571929", 20, td2, tp3);
		Etudiant e35 = new Etudiant("14011808", "Parker", "Avery", new Date(), Sexe.HOMME, "Tunis", "123456789", "parker_avery@gmail.com", "56901347", 21, td2, tp3);
		Etudiant e36 = new Etudiant("14011809", "Butler", "Micah", new Date(), Sexe.HOMME, "Gabes", "123456789", "butler_micah@gmail.com", "53621904", 20, td2, tp3);
		Etudiant e37 = new Etudiant("14011810", "Gomez", "Genesis", new Date(), Sexe.FEMME, "Sousse", "123456789", "gomez_genesis@gmail.com", "51236890", 22, td2, tp3);
		Etudiant e38 = new Etudiant("14011811", "Cruz", "Julian", new Date(), Sexe.HOMME, "Nabeul", "123456789", "cruz_julian@gmail.com", "53671922", 23, td2, tp3);
		Etudiant e39 = new Etudiant("14011812", "Bailey", "Rowan", new Date(), Sexe.HOMME, "Bizerte", "123456789", "bailey_rowan@gmail.com", "56371028", 20, td2, tp3);
		Etudiant e40 = new Etudiant("14011856", "Collins", "Olivia", new Date(), Sexe.FEMME, "Tunis", "123456789", "collins_olivia@gmail.com", "55693285", 21, td2, tp3);
		Etudiant e41 = new Etudiant("14011857", "Richardson", "Nicholas", new Date(), Sexe.HOMME, "Sousse", "123456789", "richardson_nicholas@gmail.com", "55693285", 23, td2, tp3);
		Etudiant e42 = new Etudiant("14011858", "Graham", "Caroline", new Date(), Sexe.FEMME, "Sfax", "123456789", "graham_caroline@gmail.com", "55693285", 20, td2, tp3);


		Etudiant e43 = new Etudiant("14011853", "Garcia", "Sophia", new Date(), Sexe.HOMME, "Monastir", "123456789", "garcia_sophia@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e44 = new Etudiant("14011853", "Martinez", "Noah", new Date(), Sexe.HOMME, "Monastir", "123456789", "martinez_noah@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e45 = new Etudiant("14011853", "Lopez", "Liam", new Date(), Sexe.HOMME, "Monastir", "123456789", "lopez_liam@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e46 = new Etudiant("14011853", "Gonzalez", "Olivia", new Date(), Sexe.FEMME, "Monastir", "123456789", "gonzalez_olivia@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e47 = new Etudiant("14011853", "Rodriguez", "Emma", new Date(), Sexe.FEMME, "Monastir", "123456789", "rodriguez_emma@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e48 = new Etudiant("14011853", "Hernandez", "Ava", new Date(), Sexe.FEMME, "Monastir", "123456789", "hernandez_ava@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e49 = new Etudiant("14011853", "Davis", "Isabella", new Date(), Sexe.FEMME, "Monastir", "123456789", "davis_isabella@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e50 = new Etudiant("14011853", "Flores", "Mia", new Date(), Sexe.FEMME, "Monastir", "123456789", "flores_mia@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e51 = new Etudiant("14011853", "Rivera", "Charlotte", new Date(), Sexe.FEMME, "Monastir", "123456789", "rivera_charlotte@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e52 = new Etudiant("14011853", "Lee", "Amelia", new Date(), Sexe.FEMME, "Monastir", "123456789", "lee_amelia@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e53 = new Etudiant("14011853", "Allen", "Evelyn", new Date(), Sexe.FEMME, "Monastir", "123456789", "allen_evelyn@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e54 = new Etudiant("14011853", "Wright", "Abigail", new Date(), Sexe.FEMME, "Monastir", "123456789", "wright_abigail@gmail.com", "55693285",22,td1CPI1,tp1CPI1);
		Etudiant e55 = new Etudiant("14011853", "Baker", "Emily", new Date(), Sexe.FEMME, "Monastir", "123456789", "baker_emily@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e56 = new Etudiant("14011853", "Foster", "Harper", new Date(), Sexe.FEMME, "Monastir", "123456789", "foster_harper@gmail.com", "55693285", 22, td1CPI1, tp1CPI1);
		Etudiant e57 = new Etudiant("14011853", "Gomez", "Sophie", new Date(), Sexe.FEMME, "Monastir", "123456789", "gomez_sophie@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e58 = new Etudiant("14011853", "Howard", "Avery", new Date(), Sexe.HOMME, "Monastir", "123456789", "howard_avery@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e59 = new Etudiant("14011853", "Jackson", "Carter", new Date(), Sexe.HOMME, "Monastir", "123456789", "jackson_carter@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e60 = new Etudiant("14011853", "Kelly", "Mason", new Date(), Sexe.HOMME, "Monastir", "123456789", "kelly_mason@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e61 = new Etudiant("14011853", "Lambert", "Wyatt", new Date(), Sexe.HOMME, "Monastir", "123456789", "lambert_wyatt@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e62 = new Etudiant("14011853", "Murphy", "Henry", new Date(), Sexe.HOMME, "Monastir", "123456789", "murphy_henry@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e63 = new Etudiant("14011853", "Nelson", "Ethan", new Date(), Sexe.HOMME, "Monastir", "123456789", "nelson_ethan@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e64 = new Etudiant("14011853", "Owens", "Oliver", new Date(), Sexe.HOMME, "Monastir", "123456789", "owens_oliver@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e65 = new Etudiant("14011853", "Peterson", "Logan", new Date(), Sexe.HOMME, "Monastir", "123456789", "peterson_logan@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e66 = new Etudiant("14011853", "Reid", "William", new Date(), Sexe.HOMME, "Monastir", "123456789", "reid_william@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e67 = new Etudiant("14011853", "Stewart", "Jack", new Date(), Sexe.HOMME, "Monastir","123456789", "reid_william@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e68 = new Etudiant("14011853", "Turner", "Benjamin", new Date(), Sexe.HOMME, "Monastir", "123456789", "turner_benjamin@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);
		Etudiant e69 = new Etudiant("14011853", "Walker", "Luke", new Date(), Sexe.HOMME, "Monastir", "123456789", "walker_luke@gmail.com", "55693285", 22, td1CPI1, tp2CPI1);

		List<Etudiant> etudiantList = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,e23,e24,e25,e26,e27,e28,e29,e30,e31,e32,e33,e34,e35,e36,e37,e38,e39,e40,e41,e42,e43,e44,e45,e46,e47,e48,e49,e50,e51,e52,e53,e54,e56,e57,e58,e59,e60,e61,e62,e63,e64,e65,e66,e67,e68,e69);
		etudiant.saveAll(etudiantList);

		td1.addEtudiant(e1);td1.addEtudiant(e2);td1.addEtudiant(e3);td1.addEtudiant(e4);td1.addEtudiant(e5);td1.addEtudiant(e6);td1.addEtudiant(e7);
		td1.addEtudiant(e8);td1.addEtudiant(e9);td1.addEtudiant(e10);td1.addEtudiant(e11);td1.addEtudiant(e12);td1.addEtudiant(e13);td1.addEtudiant(e14);
		td1.addEtudiant(e15);td1.addEtudiant(e16);td1.addEtudiant(e17);td1.addEtudiant(e18);td1.addEtudiant(e19);td1.addEtudiant(e20);td1.addEtudiant(e21);
		td1.addEtudiant(e22);td1.addEtudiant(e23);td1.addEtudiant(e24);td1.addEtudiant(e25);td1.addEtudiant(e26);td1.addEtudiant(e27);

		td2.addEtudiant(e28);td2.addEtudiant(e29);td2.addEtudiant(e30);td2.addEtudiant(e31);td2.addEtudiant(e32);td2.addEtudiant(e33);td2.addEtudiant(e34);
		td2.addEtudiant(e35);td2.addEtudiant(e36);td2.addEtudiant(e37);td2.addEtudiant(e38);td2.addEtudiant(e39);td2.addEtudiant(e40);td2.addEtudiant(e41);
		td2.addEtudiant(e42);

		td1CPI1.addEtudiant(e43);td1CPI1.addEtudiant(e44);td1CPI1.addEtudiant(e45);td1CPI1.addEtudiant(e46);td1CPI1.addEtudiant(e47);td1CPI1.addEtudiant(e48);td1CPI1.addEtudiant(e49);
		td1CPI1.addEtudiant(e50);td1CPI1.addEtudiant(e51);td1CPI1.addEtudiant(e52);td1CPI1.addEtudiant(e53);td1CPI1.addEtudiant(e54);td1CPI1.addEtudiant(e55);td1CPI1.addEtudiant(e56);
		td1CPI1.addEtudiant(e57);td1CPI1.addEtudiant(e58);td1CPI1.addEtudiant(e59);td1CPI1.addEtudiant(e60);td1CPI1.addEtudiant(e61);td1CPI1.addEtudiant(e62);td1CPI1.addEtudiant(e63);
		td1CPI1.addEtudiant(e64);td1CPI1.addEtudiant(e65);td1CPI1.addEtudiant(e66);td1CPI1.addEtudiant(e67);td1CPI1.addEtudiant(e68);td1CPI1.addEtudiant(e69);



		tp1.addEtudiant(e1);tp1.addEtudiant(e2);tp1.addEtudiant(e3);tp1.addEtudiant(e4);tp1.addEtudiant(e5);tp1.addEtudiant(e6);tp1.addEtudiant(e7);
		tp1.addEtudiant(e8);tp1.addEtudiant(e9);tp1.addEtudiant(e10);tp1.addEtudiant(e11);tp1.addEtudiant(e12);tp1.addEtudiant(e13);


		tp2.addEtudiant(e14);tp2.addEtudiant(e15);tp2.addEtudiant(e16);tp2.addEtudiant(e17);tp2.addEtudiant(e18);tp2.addEtudiant(e19);tp2.addEtudiant(e20);
		tp2.addEtudiant(e21);tp2.addEtudiant(e22);tp2.addEtudiant(e23);tp2.addEtudiant(e24);tp2.addEtudiant(e25);tp2.addEtudiant(e26);tp2.addEtudiant(e27);

		tp3.addEtudiant(e28);tp3.addEtudiant(e29);tp3.addEtudiant(e30);tp3.addEtudiant(e31);tp3.addEtudiant(e32);tp3.addEtudiant(e33);tp3.addEtudiant(e34);
		tp3.addEtudiant(e35);tp3.addEtudiant(e36);tp3.addEtudiant(e37);tp3.addEtudiant(e38);tp3.addEtudiant(e39);tp3.addEtudiant(e40);tp3.addEtudiant(e41);
		tp3.addEtudiant(e42);

		tp1CPI1.addEtudiant(e43);tp1CPI1.addEtudiant(e44);tp1CPI1.addEtudiant(e45);tp1CPI1.addEtudiant(e46);tp1CPI1.addEtudiant(e47);tp1CPI1.addEtudiant(e48);tp1CPI1.addEtudiant(e49);
		tp1CPI1.addEtudiant(e50);tp1CPI1.addEtudiant(e51);tp1CPI1.addEtudiant(e52);tp1CPI1.addEtudiant(e53);tp1CPI1.addEtudiant(e54);tp1CPI1.addEtudiant(e55);tp1CPI1.addEtudiant(e56);


		tp2CPI1.addEtudiant(e57);tp2CPI1.addEtudiant(e58);tp2CPI1.addEtudiant(e59);tp2CPI1.addEtudiant(e60);tp2CPI1.addEtudiant(e61);tp2CPI1.addEtudiant(e62);tp2CPI1.addEtudiant(e63);
		tp2CPI1.addEtudiant(e64);tp2CPI1.addEtudiant(e65);tp2CPI1.addEtudiant(e66);tp2CPI1.addEtudiant(e67);tp2CPI1.addEtudiant(e68);tp2CPI1.addEtudiant(e69);

		Diplome diplome1 = new Diplome("Ingenierie en Genie Logiciel", new HashSet<Niveau>());

		Diplome diplomeCPI1 = new Diplome("Préparatoire Integré en Informatique", new HashSet<Niveau>());

		diplome1.addNiveau(niveau1);
		diplomeCPI1.addNiveau(niveauCPI1);
		diplome.save(diplome1);
		diplome.save(diplomeCPI1);
		niveau1.setDiplome(diplome1);
		niveauCPI1.setDiplome(diplomeCPI1);

		Note n1=new Note(m6,e1,en1, TypeDevoir.EXAM,14.5F,new Date());
		Note n2=new Note(m6,e2,en1, TypeDevoir.EXAM,14.5F,new Date());
		Note n3=new Note(m6,e3,en1, TypeDevoir.EXAM,14.0F,new Date());
		Note n4=new Note(m6,e4,en1, TypeDevoir.EXAM,12.5F,new Date());
		Note n5=new Note(m6,e5,en1, TypeDevoir.EXAM,14.0F,new Date());
		Note n6=new Note(m6,e6,en1, TypeDevoir.EXAM,12.5F,new Date());
		Note n7=new Note(m6,e7,en1, TypeDevoir.EXAM,14.5F,new Date());
		Note n8=new Note(m6,e8,en1, TypeDevoir.EXAM,14.0F,new Date());
		Note n9=new Note(m6,e9,en1, TypeDevoir.EXAM,10.0F,new Date());
		Note n10=new Note(m6,e10,en1, TypeDevoir.EXAM,14.0F,new Date());
		Note n11=new Note(m6,e11,en1, TypeDevoir.EXAM,13.0F,new Date());
		Note n12=new Note(m6,e12,en1, TypeDevoir.EXAM,14.5F,new Date());
		Note n13=new Note(m6,e13,en1, TypeDevoir.EXAM,14.0F,new Date());
		Note n14=new Note(m6,e14,en1, TypeDevoir.EXAM,14.5F,new Date());
		Note n15=new Note(m6,e15,en1, TypeDevoir.EXAM,14.0F,new Date());
		Note n16=new Note(m6,e16,en1, TypeDevoir.EXAM,12.0F,new Date());
		Note n17=new Note(m6,e17,en1, TypeDevoir.EXAM,13.0F,new Date());
		Note n18=new Note(m6,e18,en1, TypeDevoir.EXAM,14.5F,new Date());
		Note n19=new Note(m6,e19,en1, TypeDevoir.EXAM,12.5F,new Date());
		Note n20=new Note(m6,e20,en1, TypeDevoir.EXAM,12.5F,new Date());
		Note n21=new Note(m6,e21,en1, TypeDevoir.EXAM,12.0F,new Date());
		Note n22=new Note(m6,e22,en1, TypeDevoir.EXAM,10.5F,new Date());
		Note n23=new Note(m6,e23,en1, TypeDevoir.EXAM,14.5F,new Date());
		Note n24=new Note(m6,e24,en1, TypeDevoir.EXAM,5.0F,new Date());
		Note n25=new Note(m6,e25,en1, TypeDevoir.EXAM,10.5F,new Date());
		Note n26=new Note(m6,e26,en1, TypeDevoir.EXAM,15.5F,new Date());
		Note n27=new Note(m6,e27,en1, TypeDevoir.EXAM,11.5F,new Date());

		Note n28=new Note(m6,e1,en1, TypeDevoir.DS,16.5F,new Date());
		Note n29=new Note(m6,e2,en1, TypeDevoir.DS,17.5F,new Date());
		Note n30=new Note(m6,e3,en1, TypeDevoir.DS,10.0F,new Date());
		Note n31=new Note(m6,e4,en1, TypeDevoir.DS,16.5F,new Date());
		Note n32=new Note(m6,e5,en1, TypeDevoir.DS,14.0F,new Date());
		Note n33=new Note(m6,e6,en1, TypeDevoir.DS,13.5F,new Date());
		Note n34=new Note(m6,e7,en1, TypeDevoir.DS,13.5F,new Date());
		Note n35=new Note(m6,e8,en1, TypeDevoir.DS,10.0F,new Date());
		Note n36=new Note(m6,e9,en1, TypeDevoir.DS,8.0F,new Date());
		Note n37=new Note(m6,e10,en1, TypeDevoir.DS,5.0F,new Date());
		Note n38=new Note(m6,e11,en1, TypeDevoir.DS,16.0F,new Date());
		Note n39=new Note(m6,e12,en1, TypeDevoir.DS,15.5F,new Date());
		Note n40=new Note(m6,e13,en1, TypeDevoir.DS,13.0F,new Date());
		Note n41=new Note(m6,e14,en1, TypeDevoir.DS,16.5F,new Date());
		Note n42=new Note(m6,e15,en1, TypeDevoir.DS,10.0F,new Date());
		Note n43=new Note(m6,e16,en1, TypeDevoir.DS,13.0F,new Date());
		Note n44=new Note(m6,e17,en1, TypeDevoir.DS,16.0F,new Date());
		Note n45=new Note(m6,e18,en1, TypeDevoir.DS,12.5F,new Date());
		Note n46=new Note(m6,e19,en1, TypeDevoir.DS,15.5F,new Date());
		Note n47=new Note(m6,e20,en1, TypeDevoir.DS,16.5F,new Date());
		Note n48=new Note(m6,e21,en1, TypeDevoir.DS,18.0F,new Date());
		Note n49=new Note(m6,e22,en1, TypeDevoir.DS,13.5F,new Date());
		Note n50=new Note(m6,e23,en1, TypeDevoir.DS,11.5F,new Date());
		Note n51=new Note(m6,e24,en1, TypeDevoir.DS,11.0F,new Date());
		Note n52=new Note(m6,e25,en1, TypeDevoir.DS,12.5F,new Date());
		Note n53=new Note(m6,e26,en1, TypeDevoir.DS,13.5F,new Date());
		Note n54=new Note(m6,e27,en1, TypeDevoir.DS,10.5F,new Date());

		Note n55=new Note(m4,e27,en1, TypeDevoir.TP,19.5F,new Date());
		Note n56=new Note(m4,e7,en1, TypeDevoir.TP,15.5F,new Date());

		Note n57=new Note(m4,e27,en1, TypeDevoir.ORAL,14.0F,new Date());
		Note n58=new Note(m4,e7,en1, TypeDevoir.ORAL,13.75F,new Date());


		n1.setSemestre(sem1);
		n2.setSemestre(sem1);
		n3.setSemestre(sem1);
		n4.setSemestre(sem1);
		n5.setSemestre(sem1);
		n6.setSemestre(sem1);
		n7.setSemestre(sem1);
		n8.setSemestre(sem1);
		n9.setSemestre(sem1);
		n10.setSemestre(sem1);
		n11.setSemestre(sem1);
		n12.setSemestre(sem1);
		n13.setSemestre(sem1);
		n14.setSemestre(sem1);
		n15.setSemestre(sem1);
		n16.setSemestre(sem1);
		n17.setSemestre(sem1);
		n18.setSemestre(sem1);
		n19.setSemestre(sem1);
		n20.setSemestre(sem1);
		n21.setSemestre(sem1);
		n22.setSemestre(sem1);
		n23.setSemestre(sem1);
		n24.setSemestre(sem1);
		n25.setSemestre(sem1);
		n26.setSemestre(sem1);
		n27.setSemestre(sem1);
		n28.setSemestre(sem1);
		n55.setSemestre(sem1);
		n56.setSemestre(sem1);
		n57.setSemestre(sem1);
		n58.setSemestre(sem1);








		note.save(n1);note.save(n2);note.save(n3);note.save(n4);note.save(n5);note.save(n6);note.save(n7);note.save(n8);
		note.save(n9);note.save(n10);note.save(n11);note.save(n12);note.save(n13);note.save(n14);note.save(n15);note.save(n16);
		note.save(n17);note.save(n18);note.save(n19);note.save(n20);note.save(n24);note.save(n25);note.save(n26);note.save(n27);
		note.save(n28);note.save(n29);note.save(n30);note.save(n31);note.save(n32);note.save(n33);note.save(n34);note.save(n35);
		note.save(n36);note.save(n37);note.save(n38);note.save(n39);note.save(n40);note.save(n41);note.save(n42);note.save(n43);
		note.save(n44);note.save(n45);note.save(n46);note.save(n47);note.save(n48);note.save(n49);note.save(n50);note.save(n51);
		note.save(n52);note.save(n53);note.save(n54);note.save(n55);note.save(n56);note.save(n57);note.save(n58);

		e1.addNote(n1);e1.addNote(n28);e2.addNote(n2);e2.addNote(n29);e3.addNote(n3);e3.addNote(n30);e4.addNote(n4);e4.addNote(n31);
		e5.addNote(n5);e5.addNote(n32);e6.addNote(n6);e6.addNote(n33);e7.addNote(n7);e7.addNote(n34);e8.addNote(n8);e8.addNote(n35);
		e9.addNote(n9);e9.addNote(n36);e10.addNote(n10);e10.addNote(n37);e11.addNote(n11);e11.addNote(n38);e12.addNote(n12);e12.addNote(n39);
		e13.addNote(n13);e13.addNote(n40);e14.addNote(n14);e14.addNote(n41);e15.addNote(n15);e15.addNote(n42);e16.addNote(n16);e16.addNote(n43);
		e17.addNote(n17);e17.addNote(n44);e18.addNote(n18);e18.addNote(n45);e19.addNote(n19);e19.addNote(n46);e20.addNote(n20);e20.addNote(n47);
		e21.addNote(n21);e21.addNote(n48);e22.addNote(n22);e22.addNote(n49);e23.addNote(n23);e23.addNote(n50);e24.addNote(n24);e24.addNote(n51);
		e25.addNote(n25);e25.addNote(n52);e26.addNote(n26);e26.addNote(n53);e27.addNote(n27);e27.addNote(n54);
		e27.addNote(n55);e7.addNote(n56);e27.addNote(n57);e7.addNote(n58);

		en1.addNote(n1);en1.addNote(n2);en1.addNote(n3);en1.addNote(n4);en1.addNote(n5);en1.addNote(n6);en1.addNote(n7);en1.addNote(n8);
		en1.addNote(n9);en1.addNote(n10);en1.addNote(n11);en1.addNote(n12);en1.addNote(n13);en1.addNote(n14);en1.addNote(n15);en1.addNote(n16);
		en1.addNote(n17);en1.addNote(n18);en1.addNote(n19);en1.addNote(n20);en1.addNote(n24);en1.addNote(n25);en1.addNote(n26);en1.addNote(n27);
		en1.addNote(n28);en1.addNote(n29);en1.addNote(n30);en1.addNote(n31);en1.addNote(n32);en1.addNote(n33);en1.addNote(n34);en1.addNote(n35);
		en1.addNote(n36);en1.addNote(n37);en1.addNote(n38);en1.addNote(n39);en1.addNote(n40);en1.addNote(n41);en1.addNote(n42);en1.addNote(n43);
		en1.addNote(n44);en1.addNote(n45);en1.addNote(n46);en1.addNote(n47);en1.addNote(n48);en1.addNote(n49);en1.addNote(n50);en1.addNote(n51);
		en1.addNote(n52);en1.addNote(n53);en1.addNote(n54);en1.addNote(n55);en1.addNote(n56);en1.addNote(n57);en1.addNote(n55);


		Reclamation reclamation1 = new Reclamation(e3,new Date(),"Je suis absent dans ce devoir","Envoyée",5111,TypeDevoir.DS);
		Reclamation reclamation2 = new Reclamation(e25,new Date(),"Double correction dans cette matiere","Acceptée",5112,TypeDevoir.DS);
		Reclamation reclamation3 = new Reclamation(e14,new Date(),"Je veux verifier ma copie du devoir","Refusée",5121,TypeDevoir.DS);

		reclamation1.setEnseignant(en2);
		reclamation2.setEnseignant(en12);
		reclamation3.setEnseignant(en5);


		reclamation.save(reclamation1);reclamation.save(reclamation2);
		reclamation.save(reclamation3);


		EnseignantMatiere enseignantMatiere1= new EnseignantMatiere(en1,m4,Session.TP,Groups.TP, tp1.getIdTp());
		EnseignantMatiere enseignantMatiere2= new EnseignantMatiere(en1,m4,Session.TP,Groups.TP, tp2.getIdTp());
		EnseignantMatiere enseignantMatiere3= new EnseignantMatiere(en1,m4,Session.CR,Groups.SECTION, s1.getIdSection());
		EnseignantMatiere enseignantMatiere4= new EnseignantMatiere(en1,m9,Session.TP,Groups.TP, tp1.getIdTp());
		EnseignantMatiere enseignantMatiere5= new EnseignantMatiere(en1,m9,Session.TP,Groups.TP, tp2.getIdTp());
		EnseignantMatiere enseignantMatiere6= new EnseignantMatiere(en1,m6,Session.CR,Groups.SECTION, s1.getIdSection());
		EnseignantMatiere enseignantMatiere7= new EnseignantMatiere(en1,m6,Session.TD,Groups.TD, td1.getIdTd());
		EnseignantMatiere enseignantMatiere33= new EnseignantMatiere(en1,m6,Session.TD,Groups.TD, td2.getIdTd());

		enseignantMatiere1.setSemestre(sem1);
		enseignantMatiere2.setSemestre(sem1);
		enseignantMatiere3.setSemestre(sem1);
		enseignantMatiere4.setSemestre(sem1);
		enseignantMatiere5.setSemestre(sem1);
		enseignantMatiere6.setSemestre(sem1);
		enseignantMatiere7.setSemestre(sem1);
		enseignantMatiere33.setSemestre(sem1);



		EnseignantMatiere enseignantMatiere8= new EnseignantMatiere(en2,m1, Session.CR,Groups.SECTION, s1.getIdSection());
		EnseignantMatiere enseignantMatiere9= new EnseignantMatiere(en2,m1, Session.TP,Groups.TP,tp1.getIdTp());
		EnseignantMatiere enseignantMatiere10= new EnseignantMatiere(en2,m1, Session.TP,Groups.TP,tp2.getIdTp());

		enseignantMatiere8.setSemestre(sem1);
		enseignantMatiere9.setSemestre(sem1);
		enseignantMatiere10.setSemestre(sem1);


		EnseignantMatiere enseignantMatiere11= new EnseignantMatiere(en3,m5,Session.TP,Groups.TP, tp1.getIdTp());
		EnseignantMatiere enseignantMatiere12= new EnseignantMatiere(en3,m5,Session.TP,Groups.TP, tp2.getIdTp());
		EnseignantMatiere enseignantMatiere13= new EnseignantMatiere(en3,m5,Session.CR,Groups.SECTION, s1.getIdSection());

		enseignantMatiere11.setSemestre(sem1);
		enseignantMatiere12.setSemestre(sem1);
		enseignantMatiere13.setSemestre(sem1);


		EnseignantMatiere enseignantMatiere14= new EnseignantMatiere(en4,m11,Session.TD,Groups.TD,td1.getIdTd());


		EnseignantMatiere enseignantMatiere15= new EnseignantMatiere(en5,m3,Session.CR,Groups.SECTION,s1.getIdSection());


		EnseignantMatiere enseignantMatiere16= new EnseignantMatiere(en6,m12,Session.TD,Groups.TD,td1.getIdTd());


		EnseignantMatiere enseignantMatiere17= new EnseignantMatiere(en7,m10,Session.TD,Groups.TD, td1.getIdTd());


		EnseignantMatiere enseignantMatiere18= new EnseignantMatiere(en8,m7,Session.CR,Groups.SECTION,s1.getIdSection());

		EnseignantMatiere enseignantMatiere19= new EnseignantMatiere(en9,m7,Session.TP,Groups.TP,tp1.getIdTp());
		EnseignantMatiere enseignantMatiere20= new EnseignantMatiere(en9,m7,Session.TP,Groups.TP,tp2.getIdTp());

		EnseignantMatiere enseignantMatiere21= new EnseignantMatiere(en10,m3,Session.TP,Groups.TP,tp1.getIdTp());
		EnseignantMatiere enseignantMatiere22= new EnseignantMatiere(en10,m3,Session.TP,Groups.TP,tp2.getIdTp());

		EnseignantMatiere enseignantMatiere23= new EnseignantMatiere(en11,m8,Session.CR,Groups.SECTION,s1.getIdSection());
		EnseignantMatiere enseignantMatiere24= new EnseignantMatiere(en11,m8,Session.TP,Groups.TP, tp1.getIdTp());
		EnseignantMatiere enseignantMatiere25= new EnseignantMatiere(en11,m8,Session.TP,Groups.TP, tp2.getIdTp());




		EnseignantMatiere enseignantMatiere26= new EnseignantMatiere(en12,m2,Session.CR,Groups.SECTION,s1.getIdSection());
		EnseignantMatiere enseignantMatiere27= new EnseignantMatiere(en12,m2,Session.TP,Groups.TP,tp1.getIdTp());
		EnseignantMatiere enseignantMatiere28= new EnseignantMatiere(en12,m2,Session.TP,Groups.TP, tp2.getIdTp());


		EnseignantMatiere enseignantMatiere29= new EnseignantMatiere(en1,m6,Session.CR,Groups.SECTION, s2.getIdSection());
		EnseignantMatiere enseignantMatiere30= new EnseignantMatiere(en1,m4,Session.CR,Groups.SECTION, s2.getIdSection());
		EnseignantMatiere enseignantMatiere31= new EnseignantMatiere(en1,m6,Session.TP,Groups.TP, tp2CPI1.getIdTp());
		enseignantMatiere29.setSemestre(sem1CPI1);
		enseignantMatiere30.setSemestre(sem1CPI1);
		enseignantMatiere31.setSemestre(sem1CPI1);




		enseignantMatiere.save(enseignantMatiere1);enseignantMatiere.save(enseignantMatiere2);enseignantMatiere.save(enseignantMatiere3);
		enseignantMatiere.save(enseignantMatiere4);enseignantMatiere.save(enseignantMatiere5);enseignantMatiere.save(enseignantMatiere6);
		enseignantMatiere.save(enseignantMatiere7);enseignantMatiere.save(enseignantMatiere8);enseignantMatiere.save(enseignantMatiere9);
		enseignantMatiere.save(enseignantMatiere10);enseignantMatiere.save(enseignantMatiere11);enseignantMatiere.save(enseignantMatiere12);
		enseignantMatiere.save(enseignantMatiere13);enseignantMatiere.save(enseignantMatiere14);enseignantMatiere.save(enseignantMatiere15);
		enseignantMatiere.save(enseignantMatiere16);enseignantMatiere.save(enseignantMatiere17);enseignantMatiere.save(enseignantMatiere18);
		enseignantMatiere.save(enseignantMatiere19);enseignantMatiere.save(enseignantMatiere20);enseignantMatiere.save(enseignantMatiere21);
		enseignantMatiere.save(enseignantMatiere22);enseignantMatiere.save(enseignantMatiere23);enseignantMatiere.save(enseignantMatiere24);
		enseignantMatiere.save(enseignantMatiere25);enseignantMatiere.save(enseignantMatiere26);enseignantMatiere.save(enseignantMatiere27);
		enseignantMatiere.save(enseignantMatiere28);
		enseignantMatiere.save(enseignantMatiere29);enseignantMatiere.save(enseignantMatiere30);enseignantMatiere.save(enseignantMatiere31);
		enseignantMatiere.save(enseignantMatiere33);



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


		unite.save(u1);unite.save(u2);unite.save(u3);unite.save(u4);unite.save(u5);

		regime.save(r1);regime.save(r2);

		matiere.save(m1);matiere.save(m2);matiere.save(m3);matiere.save(m4);matiere.save(m5);matiere.save(m6);matiere.save(m7);matiere.save(m8);
		matiere.save(m9);matiere.save(m10);matiere.save(m11);matiere.save(m12);


		niveau.save(niveau1);
		niveau.save(niveauCPI1);


		semestre.save(sem1);
		semestre.save(sem1CPI1);


		section.save(s1);
		section.save(s2);

		td.save(td1);


		tp.save(tp1);tp.save(tp2);
		tp.save(tp1CPI1);tp.save(tp2CPI1);


		etudiant.saveAll(etudiantList);

		diplome.save(diplome1);
		diplome.save(diplomeCPI1);


		note.save(n1);note.save(n2);note.save(n3);note.save(n4);note.save(n5);note.save(n6);note.save(n7);note.save(n8);
		note.save(n9);note.save(n10);note.save(n11);note.save(n12);note.save(n13);note.save(n14);note.save(n15);note.save(n16);
		note.save(n17);note.save(n18);note.save(n19);note.save(n20);note.save(n24);note.save(n25);note.save(n26);note.save(n27);
		note.save(n28);note.save(n29);note.save(n30);note.save(n31);note.save(n32);note.save(n33);note.save(n34);note.save(n35);
		note.save(n36);note.save(n37);note.save(n38);note.save(n39);note.save(n40);note.save(n41);note.save(n42);note.save(n43);
		note.save(n44);note.save(n45);note.save(n46);note.save(n47);note.save(n48);note.save(n49);note.save(n50);note.save(n51);
		note.save(n52);note.save(n53);note.save(n54);note.save(n55);note.save(n56);note.save(n57);note.save(n58);

		reclamation.save(reclamation1);reclamation.save(reclamation2);
		reclamation.save(reclamation3);



	}
}
