/**
 * La classe <code>Grille</code> est utilisée pour afficher une grille aléatoire.
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Grille implements ActionListener{

    /**
     * Composante graphique (nom de la fenetre).
     */
    private JFrame fen;

    /**
     * Composante graphique ("sombre" ou "clair").
     */
    private JLabel couleur;
    /**
     * Constructeur destiné à récuperer les informations pour l'affichage de la grille.
     *
     * @param recup nom de l'objet Fenetre()
     * @param couleur1 thème choisi
     */
    public Grille (JFrame recup,JLabel couleur1){
        this.fen=recup;
        this.couleur=couleur1;
    }

    /**
     * Vide l'ancienne page,rempli et affiche la grille avec le score et les étoiles.
     */
    public void Affichage(){
        int [] occupe = new int [150];
        int nombre,Min=1,Max=3,i,a;
        Bloc[] test= new Bloc[150];
        int [] grille = new int [150];

    	fen.getContentPane().removeAll();
        fen.setVisible(false);
        fen.setLayout(null);
        
        //panel pour la grille
        JPanel jeux = new JPanel();
        jeux.setBounds(0,70,700,600);
    	jeux.setLayout(new GridLayout(10,15));
        jeux.setOpaque(false);

        //affichage du score
        JLabel points = new JLabel("Score : 0 ");
        points.setBounds(0,0,1125,75);
        points.setHorizontalAlignment(JLabel.CENTER);
        points.setFont(new Font("Serif", Font.BOLD, 35));

        //affichage du nombre de cases
        JLabel cases = new JLabel("Cases séléctionnées : 0 ");
        cases.setBounds(0,0,725,55);
        cases.setHorizontalAlignment(JLabel.CENTER);
        cases.setFont(new Font("Serif", Font.BOLD, 12));

        //affichage du score en plus
        JLabel affscore = new JLabel("+0");
        affscore.setBounds(0,0,735,97);
        affscore.setHorizontalAlignment(JLabel.CENTER);
        affscore.setFont(new Font("Serif", Font.BOLD, 23));

        if(couleur.getText()=="clair"){
            points.setForeground(new Color(133,101,196));
            cases.setForeground(new Color(133,101,196));
            affscore.setForeground(new Color(133,101,196));
        }else{
            points.setForeground(new Color(21,203,222));
            cases.setForeground(new Color(21,203,222));
            affscore.setForeground(new Color(21,203,222));
        }

        //affichage des étoiles en fonction du score
        Etoile barre = new Etoile(0);
        barre.setBounds(0,0,500,100);

        //Initialisation de occupe[] et remplissage de la grille aléatoirement
        for (a=0 ;a<150 ;a++) {
            occupe[a]=0;
        }

        for(i=0;i<150;i++){
            nombre =Min+(int)(Math.random()*((Max-Min)+1));
            jeux.add(test[i] = new Bloc(nombre));
            grille[i] = nombre;
            test[i].addMouseListener(new Surlignement(test,grille,i,fen,occupe,0,jeux,points,couleur, cases, affscore));
        }

        Paliers pts = new Paliers(fen,couleur);

        fen.add(barre);
        fen.add(jeux);
        fen.add(points);
        fen.add(cases);
        fen.add(affscore);
        fen.setVisible(true);
        fen.revalidate();
    }

    /**
     * Affiche de la grille quand le bouton jouer est cliqué.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Affichage();
    }
}
