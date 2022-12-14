package FFSSM;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import java.time.LocalDate;

import org.junit.Test;

public class LicenceTest {
	Moniteur m; 
	Club club; 
	Personne p;
	Licence l; 
	Plongee plongee;
	Site site;
	
	
	
	@Before
	public void setUp(){

		m = new Moniteur("0220", "Naji", "Geoffrey", "Chemin", "08989", LocalDate.of(2001, 02, 01),12);
		club = new Club(m,"Damien","9034");
		p = new Personne("0220", "Naji", "Geoffrey", "Chemin", "08989", LocalDate.of(2001, 03, 10));
		l = new Licence(p, "08989", LocalDate.of(2002, 03, 10),club);
		site = new Site("Carcassonne", null);
		plongee = new Plongee(site, m, LocalDate.of(2018, 02, 28), 20, 30);
		
	}
	
	@After
	public void terDown(){

		m = null;
		club = null;
		p = null;
		l = null;
		
	}
	
	@Test
	public void testEstValide()
	{
		Licence licence = new Licence(p, "08989", LocalDate.of(2002, 03, 10),club);
		assertEquals(true, licence.estValide(LocalDate.of(2002, 03, 10)));
	}
	

}



