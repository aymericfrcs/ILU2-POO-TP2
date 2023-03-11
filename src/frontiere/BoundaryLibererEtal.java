package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		StringBuilder str = new StringBuilder();
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			str.append("Mais vous n'êtes pas inscrit sur note marché aujourd'hui !\n");
			System.out.println(str.toString());
			str.setLength(0);
			
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.parseBoolean(donneesEtal[0]);
			
			if (etalOccupe) {
				int qtteVendu = Integer.parseInt(donneesEtal[4]);
				int qtteInitial = Integer.parseInt(donneesEtal[3]);
				String produit = donneesEtal[2];
				
				str.append("Vous avez vendu " + qtteVendu + " sur " + qtteInitial + " " + produit + ".");
				System.out.println(str.toString());
				str.setLength(0);
				
				str.append("Au revoir " + nomVendeur + ", passez une bonne journée.");
			}
		}
	}

}
