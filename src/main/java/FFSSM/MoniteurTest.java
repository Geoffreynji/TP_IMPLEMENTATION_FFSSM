package FFSSM;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class MoniteurTest {

	Moniteur m; 
	Club club; 
	Club club2;
	Personne p;
	Licence l; 
	Plongee plongee;
	Site site;
	
	
	
	@Before
	public void setUp(){

		m = new Moniteur("0220", "Naji", "Geoffrey", "Chemin", "08989", LocalDate.of(2001, 02, 01),12);
		club = new Club(m,"Damien","9034");
		club2 = new Club(m,"Geoffrey","12");
		p = new Personne("0220", "Naji", "Geoffrey", "Chemin", "08989", LocalDate.of(2001, 03, 10));
		l = new Licence(p, "08989", LocalDate.of(2002, 03, 10),club);
		site = new Site("Carcassonne", null);
		plongee = new Plongee(site, m, LocalDate.of(2018, 02, 28), 20, 30);
		
	}
	
	 @Test
	    public void testEmployeurActuel() {
	        LocalDate date = LocalDate.of(2018, 10, 12);
	        assertFalse(m.employeurActuel().isPresent());
	        m.nouvelleEmbauche(club, date);
	        m.nouvelleEmbauche(club2, date);
	        assertSame(club2, m.employeurActuel().get());
	    }

}
