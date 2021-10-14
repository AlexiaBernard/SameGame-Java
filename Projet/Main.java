/**
 * La classe <code>Main</code> est utilisée pour créer une fenêtre et appeler la classe Fenetre.
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		fenetre.setResizable(false);

		JLabel couleur = new JLabel("sombre"); 
		Fenetre jeux = new Fenetre(fenetre,0,"",couleur,0,0);

		jeux.setFenetre();
	}
}
	