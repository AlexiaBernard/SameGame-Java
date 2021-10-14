/**
 * La classe <code>Fermeture</code> est utilisée pour fermer la fenêtre.
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Fermeture implements ActionListener{

	/**
   	 * Composante graphique (nom de la fenetre).
   	 */
    private JFrame fen;

    /**
     * Constructeur destiné à récuperer les informations pour la fermeture de la fenêtre.
     *
     * @param fenetre nom de l'objet Fenetre()
     */
    public Fermeture(JFrame fenetre){
        this.fen=fenetre;
    }

    /**
     * Ferme la fenêtre quand le bouton quitter est cliqué.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        fen.dispose();
    }
}