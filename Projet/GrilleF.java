/**
 * La classe <code>GrilleF</code> est utilisée pour afficher la grille à partir d'un fichier choisi par l'utilisateur .
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
 
public class GrilleF implements ActionListener{

    /**
     * Composante graphique (nom de la fenetre).
     */
    private JFrame fen;

    /**
     * Fichier ouvert.
     */
    private String fichier;

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
    public GrilleF (JFrame recup,JLabel couleur1){
        this.fen=recup;
        this.couleur=couleur1;
    }

    /**
     * Vide l'ancienne page, rempli et affiche la grille avec le score et les étoiles.
     */
    public void Affichage(){
        fen.getContentPane().removeAll();
        fen.setVisible(false);
        fen.setLayout(null);

        int nombre=0,let,nbl=0, nbc=0,a,i;
        char lettre;
        String ligne;
        boolean vrai=true;
        Bloc[] test= new Bloc[150];
        int [] occupe = new int [150];
        int [] grille = new int [150];

        try{
            //vérification de la taille de la grille dans le fichier
            FileReader file1 = new FileReader(this.fichier);
            BufferedReader entree1 = new BufferedReader(file1);
            try {
                while ((ligne = entree1.readLine()) != null){
                    nbc= ligne.length();
                    nbl++;
                    if (nbc!=15) {
                        vrai=false;      
                    }
                }
                if(vrai==false){
                    Fenetre nouvelle1 = new Fenetre(fen,1,this.fichier,couleur,1,1);
                    nouvelle1.setFenetre(); 
                }
            } catch (IOException e) {
                Fenetre nouvelle2 = new Fenetre(fen,2,this.fichier,couleur,1,1);
                nouvelle2.setFenetre();
            }
            try {
                entree1.close();
            } catch (IOException e){
                Fenetre nouvelle3 = new Fenetre(fen,3,this.fichier,couleur,1,1);
                nouvelle3.setFenetre();
            }
        }catch (FileNotFoundException e){
            Fenetre nouvelle4 = new Fenetre(fen,4,this.fichier,couleur,1,1);
            nouvelle4.setFenetre();
        }

        if (vrai==true) {
            try{
                FileReader file = new FileReader(this.fichier);
                BufferedReader entree = new BufferedReader(file);

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

                //Initialisation de occupe[] et remplissage de la grille avec le fichier
                for (a=0 ;a<150 ;a++) {
                    occupe[a]=0;
                }
                for (i=0;i<150 ;i++ ) {
                    try {
                        let= entree.read();
                        lettre = (char)let;
                        if (let!=10){
                            if (lettre==('V')) {
                                nombre=1;
                            } else if (lettre ==('R')) {
                                nombre=2;
                            } else if (lettre ==('B')) {
                                nombre=3;
                            }
                            jeux.add(test[i] = new Bloc(nombre));
                            grille[i] = nombre;
                            test[i].addMouseListener(new Surlignement(test,grille,i,fen,occupe,0,jeux,points,couleur,cases,affscore));
                        } else if (let==10){ i--;}
                    } catch (IOException e) {
                        Fenetre nouvelle5 = new Fenetre(fen,5,this.fichier,couleur,1,1);
                        nouvelle5.setFenetre();
                    }
                }

                Paliers pts = new Paliers(fen,couleur);
                
                fen.add(barre);
                fen.add(jeux);
                fen.add(points);
                fen.add(cases);
                fen.add(affscore);
                try {
                    entree.close();
                } catch (IOException e){
                    Fenetre nouvelle6 = new Fenetre(fen,6,this.fichier,couleur,1,1);
                    nouvelle6.setFenetre();
                }
        
            }catch (FileNotFoundException e){
                Fenetre nouvelle7 = new Fenetre(fen,7,this.fichier,couleur,1,1);
                nouvelle7.setFenetre();
            }
        }
        fen.setVisible(true);
        fen.revalidate();
    }

    /**
     * Ouvre une fenetre de dialogue pour sélectionner un fichier et affiche la grille quand le bouton fichier est cliqué.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        JFileChooser choix = new JFileChooser();
        int val_retour = choix.showOpenDialog(this.fen);

        if (val_retour == JFileChooser.APPROVE_OPTION){
            File file1 = choix.getSelectedFile();
            this.fichier= file1.getName();
            Affichage();
        } else {
            Fenetre nouvelle8 = new Fenetre(fen,8,this.fichier,couleur,1,1);
            nouvelle8.setFenetre();
        }
        
    }
}