/**
 * La classe <code>Couleur</code> est utilisée pour changer les couleurs de la fenêtre.
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Couleur implements ActionListener{

    /**
     * Composante graphique (nom de la fenetre).
     */
    private JFrame fen;

    /**
     * Composante graphique (titre du jeu).
     */
    private JLabel titre;

    /**
     * Composante graphique (panel regle).
     */
    private JPanel regle;

    /**
     * Composante graphique (panel points).
     */
    private JPanel points;

    /**
     * Composante graphique (bouton sombre).
     */
    private JRadioButton sombre;

    /**
     * Composante graphique (bouton clair).
     */
    private JRadioButton clair;

    /**
     * Composante graphique (bouton fichier).
     */
    private JButton fichier;

    /**
     * Composante graphique (bouton jouer).
     */
    private JButton jouer;

    /**
     * Composante graphique ("sombre" ou "clair").
     */
    private JLabel theme;
    /**
     * Constructeur destiné à récuperer les informations pour modifier les couleurs.
     *
     * @param recup nom de l'objet Fenetre()
     * @param titre1 titre du jeu
     * @param regle1 panel règle
     * @param point panel points
     * @param sombre1 bouton sombre
     * @param clair1 bouton clair
     * @param fichier1 bouton fichier
     * @param jouer1 bouton jouer
     * @param theme1 thème choisi
     */
    public Couleur (JFrame recup,JLabel titre1,JPanel regle1,JPanel point,
        JRadioButton sombre1,JRadioButton clair1,JButton fichier1,JButton jouer1,JLabel theme1){
        this.fen=recup;
        this.titre=titre1;
        this.regle=regle1;
        this.points=point;
        this.sombre=sombre1;
        this.clair=clair1;
        this.fichier=fichier1;
        this.jouer=jouer1;
        this.theme=theme1;
    }

    /**
     * Modifie les couleurs en fonction du choix de l'utilisateur.
     */
    public void Affichage(){
        fen.setVisible(false);
        
        if(sombre.isSelected()){
            fen.getContentPane().setBackground(new Color(31,35,35));
            titre.setForeground(new Color(21,203,222));
            regle.setBackground(new Color(15,104,79,50));
            points.setBackground(new Color(15,104,79,50));

            sombre.setBackground(new Color(15,104,79));
            clair.setBackground(new Color(15,104,79));
            fichier.setBackground(new Color(21,203,200));
            jouer.setBackground(new Color(21,203,200));
            theme.setText("sombre");
        }else if(clair.isSelected()){
            fen.getContentPane().setBackground(new Color(224,187,228));
            titre.setForeground(new Color(149,125,173));
            regle.setBackground(new Color(210,145,188));
            points.setBackground(new Color(210,145,188));
            
            sombre.setBackground(new Color(210,145,188));
            clair.setBackground(new Color(210,145,188));
            fichier.setBackground(new Color(210,145,188));
            jouer.setBackground(new Color(210,145,188));
            theme.setText("clair");
        }

        fen.setVisible(true);
        fen.repaint();
    }

    /**
     * Rafraîchit la fenêtre quand les boutons radio sombre ou clair sont cliqués.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Affichage();
    }
}
