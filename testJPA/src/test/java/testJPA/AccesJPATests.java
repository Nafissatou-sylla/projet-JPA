package testJPA;

import java.util.ArrayList;
import java.util.List;

import org.formation.sylla.testJPA.service.PersonnePOJO;
import org.formation.sylla.testJPA.stockage.DaoJPA;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccesJPATests {
	static DaoJPA jpa;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		jpa = new DaoJPA();
	}
	
	@Test
	void testLireTous() {
	List<PersonnePOJO> res = null;
	res = jpa.lireTous();
	assertEquals(2, res.size());
	}


	@Test
	void testLire() {
		PersonnePOJO pers = null;
		pers = jpa.lire(1);
		assertNotNull(pers);
		assertEquals(1, pers.getId());
		assertEquals("Dupond", pers.getNom());
		assertEquals("gérard", pers.getPrenom());
		assertEquals("0623547612", pers.getTelephone());
	}
	
	@Test
	void testCreerSupprimer() {
		List<PersonnePOJO> tous = null;
		PersonnePOJO pers = new PersonnePOJO();
		pers.setNom("Sylla");
		pers.setPrenom("Nafi");
		pers.setTelephone("0612345678");
		
		tous = jpa.lireTous();
		assertNotNull(tous);
		assertEquals(2, tous.size());
		
		jpa.creer(pers);
		pers.setId(jpa.getDerniereCle());

		assertNotNull(tous);
		assertEquals(tous.size(), 3);
		
		int persASupprimer = jpa.getDerniereCle();
		jpa.supprimer(persASupprimer);
		assertNotNull(tous);
		assertEquals(tous.size(), 2);
	}
	
	
	@Test
	void testModifier() {
		PersonnePOJO aSauvegarder = null;
		PersonnePOJO aModifier = null;
		aModifier = jpa.lire(1);
		
		//on vérifie les données de la base dd
		assertEquals("Dupond", aModifier.getNom());
		assertEquals("gérard", aModifier.getPrenom());
		assertEquals("0623547612", aModifier.getTelephone());
		
		//on change les données
		aModifier.setNom("Sylla");
		aModifier.setPrenom("Nafi");
		aModifier.setTelephone("0712345678");
		
		//on modifie maintenant
		jpa.modifier(aModifier);
		
		aModifier = jpa.lire(1);
		//on vérifie si la modifiacation est bon
		assertEquals("Sylla",  aModifier.getNom());
		assertEquals("Nafi", aModifier.getPrenom());
		assertEquals("0712345678", aModifier.getTelephone());
		
		//on remets la bdd à l'état initial
		aSauvegarder =jpa.lire(1);
		
		aSauvegarder.setNom("Dupond");
		aSauvegarder.setPrenom("gérard");
		aSauvegarder.setTelephone("0623547612");
		
		//on remet les valeurs initial
		jpa.modifier(aSauvegarder);

		assertEquals("Dupond", aSauvegarder.getNom());
		assertEquals("gérard", aSauvegarder.getPrenom());
		assertEquals("0623547612", aSauvegarder.getTelephone());
		}
}
