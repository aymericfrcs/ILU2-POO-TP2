package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		StringBuilder phrase = new StringBuilder();
		
		if (!nomVendeurConnu) {
			phrase.append("Je suis d�sol� " + nomVendeur 
					+ ", mais il faut �tre un habitant de notre village pour commencer ici.\n");
			System.out.println(phrase.toString());
			
		} else {
			phrase.append("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un �tal.\n");
			System.out.println(phrase.toString());
			phrase.setLength(0);
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			
			if (!etalDisponible) {
				phrase.append("D�sol� " + nomVendeur + " je n'ai plus d'�tal qui ne soit pas d�j� occup�.\n");
				System.out.println(phrase.toString());
				phrase.setLength(0);
				
			} else {
				installerVendeur(nomVendeur);
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder phrase = new StringBuilder();
		phrase.append("C'est parfait, il me reste un �tal pour vous!\n");
		phrase.append("Il me faudrait quelques renseignements :\n");
		phrase.append("Quel produit souhaitez-vous vendre?\n");
		
		String produit = Clavier.entrerString(phrase.toString());
		phrase.setLength(0);
		
		phrase.append("Combien souahitez-vous en vendre?\n");
		int nbProduit = Clavier.entrerEntier(phrase.toString());
		phrase.setLength(0);
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		if (numeroEtal != -1) {
			phrase.append("Le vendeur " + nomVendeur + " s'est install� � l'�tal n� " + numeroEtal);
		System.out.println(phrase.toString());
		}
	}
}
