package testJPA;

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
		System.out.println( "la personne a lire " + pers);
	}
	
	@Test
	void testCreerSupprimer() {
		List<PersonnePOJO> tous = null;
		PersonnePOJO pers = new PersonnePOJO();
		pers.setNom("Sylla");
		pers.setPrenom("Nafi");
		pers.setTelephone("0612345678");
		
		assertNotNull(jpa.lireTous());
		assertEquals(2,jpa.lireTous().size());
		
		jpa.creer(pers);
		
		tous = jpa.lireTous();
		assertNotNull(tous);
		assertEquals(tous.size(), 3);
		
		jpa.supprimer(jpa.getDerniereCle());
		assertNotNull(tous);
		assertEquals(tous.size(), 2);
		
	}
	
	
	@Test
	void testModifier() {
		PersonnePOJO aModifier = null; jpa.lire(1);
		PersonnePOJO aSauvegarder = null;
		aModifier = jpa.lire(1);
		aSauvegarder = jpa.lire(1);
		
		assertEquals("Dupond", aModifier.getNom());
		assertEquals("gérard", aModifier.getPrenom());
		assertEquals("0623547612", aModifier.getTelephone());
		
		aModifier.setNom("Sylla");
		aModifier.setPrenom("Nafi");
		aModifier.setTelephone("0712345678");
		jpa.modifier(aModifier);
		
		aModifier = jpa.lire(1);
		assertEquals("Sylla",  aModifier.getNom());
		assertEquals("Nafi", aModifier.getPrenom());
		assertEquals("0712345678", aModifier.getTelephone());
		
		jpa.modifier(aSauvegarder);
		aModifier =jpa.lire(1);
		}
}
