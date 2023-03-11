package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		StringBuilder str = new StringBuilder();
		
		if (infosMarche.length == 0) {
			str.append("Le marché est vide, revenez plus tard.\n");
			System.out.println(str.toString());
			str.setLength(0);
			
		} else {
			//TODO Faire la boucle d'affichage du marché
		}
	}
}
