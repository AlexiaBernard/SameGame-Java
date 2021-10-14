/**
 * La classe <code>Etoile</code> est utilisée pour afficher des étoiles correspondant au score.
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*; 
import java.awt.*;

public class Etoile extends JComponent{
	
	/**
     * Etoile couleur or.
     */ 
	private Image or;

	/**
     * Etoile couleur argent.
     */
	private Image argent;

	/**
     * Score actuel du joueur.
     */
	private int score;

	/**
     * Constructeur destiné à récuperer les informations pour afficher le nombre d'étoile correspondant.
     *
     * @param scor score actuel
     */
	public Etoile(int recupscore){
		super();
		this.or=Toolkit.getDefaultToolkit().getImage("or.png");
		this.argent=Toolkit.getDefaultToolkit().getImage("grise.png");
		this.score=recupscore;
	}

	/**
     * Dessine le nombre d'étoile en fonction du score du joueur à chaque clique.
     */
	@Override
	protected void paintComponent(Graphics pinceau) { 	
	    Graphics secondPinceau = pinceau.create();
	    if (this.isOpaque()){
	      secondPinceau.setColor(this.getBackground());
	      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
	    }
	    if(score>=2000){
	    	secondPinceau.drawImage(this.or,20,10,this);
		  	secondPinceau.drawImage(this.or,75,10,this);
		  	secondPinceau.drawImage(this.or,125,10,this);
		  	secondPinceau.drawImage(this.or,175,10,this);
		  	secondPinceau.drawImage(this.or,225,10,this);
	    }else if(score>=1500 && score<2000){
	    	secondPinceau.drawImage(this.or,20,10,this);
		  	secondPinceau.drawImage(this.or,75,10,this);
		  	secondPinceau.drawImage(this.or,125,10,this);
		  	secondPinceau.drawImage(this.or,175,10,this);
		  	secondPinceau.drawImage(this.argent,225,10,this);
	    }else if(score>=1000 && score<1500){
	    	secondPinceau.drawImage(this.or,20,10,this);
		  	secondPinceau.drawImage(this.or,75,10,this);
		  	secondPinceau.drawImage(this.or,125,10,this);
		  	secondPinceau.drawImage(this.argent,175,10,this);
		  	secondPinceau.drawImage(this.argent,225,10,this);
	    }else if(score>=600 && score<1000){
	    	secondPinceau.drawImage(this.or,20,10,this);
		  	secondPinceau.drawImage(this.or,75,10,this);
		  	secondPinceau.drawImage(this.argent,125,10,this);
		  	secondPinceau.drawImage(this.argent,175,10,this);
		  	secondPinceau.drawImage(this.argent,225,10,this);
	    }else if(score>=300 && score<600){
	    	secondPinceau.drawImage(this.or,20,10,this);
		  	secondPinceau.drawImage(this.argent,75,10,this);
		  	secondPinceau.drawImage(this.argent,125,10,this);
		  	secondPinceau.drawImage(this.argent,175,10,this);
		  	secondPinceau.drawImage(this.argent,225,10,this);
	    }else if(score>=0 && score<300){
	    	secondPinceau.drawImage(this.argent,20,10,this);
		  	secondPinceau.drawImage(this.argent,75,10,this);
		  	secondPinceau.drawImage(this.argent,125,10,this);
		  	secondPinceau.drawImage(this.argent,175,10,this);
		  	secondPinceau.drawImage(this.argent,225,10,this);
	    }	
	} 
}