  /**
 * La classe <code>Score</code> est utilisée pour renvoyer le score du joueur.
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score {

	/**
     * Nombre de case que le joueur à supprimé.
     */
	private int compt;

	/**
     * Score (minimum 0).
     */
	private int score;

	/**
     * Constructeur destiné à récuperer les informations pour calculer le score.
     *
     * @param compteur nombre de case
     * @param scor score actuel
     */
	public Score(int compteur, int scor){
		this.compt=compteur;
		this.score=scor;
	}

	/**
   	 * Renvoie le score du joueur.
   	 *
   	 * @return le score du joueur
   	 */
	public int getScore(){
		int sc=this.score+(compt-2)*(compt-2);
		return sc;
	}
}