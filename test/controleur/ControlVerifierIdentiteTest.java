package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;	
	private Chef chef;
	
	@BeforeEach
	public void initSit() {
		System.out.println("Init...");
		village = new Village("Village", 10, 15);
		chef = new Chef("Chef", 10, village);
		village.setChef(chef);
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite);
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		
		controlEmmenager.ajouterGaulois("Bonnemine", 10);
		assertTrue(controlVerifierIdentite.verifierIdentite("Bonnemine"));
		assertTrue(controlVerifierIdentite.verifierIdentite("Chef"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Jépadfrix"));
	}
}
