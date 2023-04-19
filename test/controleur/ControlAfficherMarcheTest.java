package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void initSituation() {
		System.out.println("Initialisation...");
		village = new Village("village", 10, 5);
		chef = new Chef("Chef", 15, village);
		village.setChef(chef);
	}

	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		
		//TODO Finir ça après les autres tests
		
		
	}
}
