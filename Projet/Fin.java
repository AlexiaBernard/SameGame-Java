/**
 * La classe <code>Fin</code> est utilisée pour afficher la page de fin de jeux.
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*;
import java.awt.*;

public class Fin {

    /**
     * Composante graphique (nom de la fenetre).
     */
	private JFrame fen;

    /**
     * Score que le joueur a obtenu.
     */
	private int scoreval;

    /**
     * Composante graphique ("sombre" ou "clair").
     */
    private JLabel couleur;

    /**
     * Constructeur destiné à récuperer les informations pour calculer le score.
     *
     * @param recup nom de l'objet Fenetre()
     * @param scor score final
     * @param couleur1 thème choisi
     */
    public Fin (JFrame recup, int scor,JLabel couleur1){
        this.fen=recup;
        this.scoreval=scor;
        this.couleur=couleur1;
    }

    /**
     * Vide l'ancienne page et affiche la nouvelle page de fin avec les étoiles et le score final.
     */
    public void refresh(){
    	fen.getContentPane().removeAll();
        fen.setVisible(false);

        //affichage des étoiles
        Etoile barre = new Etoile(scoreval);
        barre.setBounds(180,100,500,100);
        
        JLabel fin = new JLabel("Bien joué votre score est de");
        fin.setBounds(0,250,710,75);
        fin.setHorizontalAlignment(JLabel.CENTER);
        fin.setFont(new Font("Serif", Font.BOLD, 35));
        
        //affichage du score
        JLabel score = new JLabel(""+this.scoreval);
        score.setBounds(0,300,710,75);
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setFont(new Font("Serif", Font.BOLD, 35));
        
        JButton rejouer = new JButton("Rejouer");
        rejouer.setBounds(125,500,200,50);
        rejouer.addActionListener(new Fenetre(fen,0,"",couleur,1,1));
        rejouer.setFont(new Font("Serif", Font.BOLD,15));
        
        JButton quitter = new JButton("Quitter");
        quitter.setBounds(375,500,200,50);
        quitter.addActionListener(new Fermeture(fen));
        quitter.setFont(new Font("Serif", Font.BOLD,15));

        if(couleur.getText()=="clair"){
            fin.setForeground(new Color(133,101,196));
            score.setForeground(new Color(133,101,196));
            rejouer.setBackground(new Color(210,145,188));
            quitter.setBackground(new Color(210,145,188));
        }else{
            fin.setForeground(new Color(21,203,222));
            score.setForeground(new Color(21,203,222));
            rejouer.setBackground(new Color(21,203,200));
            quitter.setBackground(new Color(21,203,200));
        }

        fen.add(fin);
        fen.add(score);
        fen.add(rejouer);
        fen.add(quitter);
        fen.add(barre);
        fen.setVisible(true);
        fen.revalidate();
    }
}