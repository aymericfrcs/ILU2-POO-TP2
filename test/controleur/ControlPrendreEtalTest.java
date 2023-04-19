package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void initSit() {
		System.out.println("Init...");
		village = new Village("Village", 10, 2);
		chef = new Chef("Chef", 10, village);
		village.setChef(chef);
		
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		
		controlEmmenager.ajouterGaulois("Bonnemine", 12);
		controlEmmenager.ajouterGaulois("Asterix", 15);
		controlEmmenager.ajouterGaulois("Idefix", 2);
	}
	
	
	@Test
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal);
	}
	
	@Test
	void testResteEtals() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		
		
		controlPrendreEtal.prendreEtal("Bonnemine", "Poisson", 2);
		assertTrue(controlPrendreEtal.resteEtals());
		
		controlPrendreEtal.prendreEtal("Asterix", "Sanglier", 1);
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		
		assertTrue(controlPrendreEtal.prendreEtal("Bonnemine", "Poisson", 2) == 0);
		assertTrue(controlPrendreEtal.prendreEtal("Asterix", "Sanglier", 1) == 1);
		assertFalse(controlPrendreEtal.prendreEtal("Idefix", "os", 2) == 2);
		assertTrue(controlPrendreEtal.prendreEtal("Idefix", "os", 2) == -1);
		
	}
	
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		
		assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
		assertFalse(controlPrendreEtal.verifierIdentite("jsp"));
	}

}
