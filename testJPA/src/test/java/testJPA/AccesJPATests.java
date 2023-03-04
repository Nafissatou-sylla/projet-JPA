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
		System.out.println( "la personne a lire " + pers);
	}
}
