/**
 * La classe <code>Fenetre</code> est utilisée pour créer puis afficher la page d'accueil.
 *
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Fenetre implements ActionListener{

	/**
   	 * Composante graphique (nom de la fenetre).
   	 */
	private JFrame fenetre;

	/**
   	 * Code d'erreur (entre 1 et 8).
   	 */
	private int erreur;

	/**
   	 * Nom du fichier incorrecte.
   	 */
	private String fichier;

	/**
   	 * Composante graphique ("sombre" ou "clair").
   	 */
	private JLabel couleur;

	/**
   	 * Composante graphique (abcisse).
   	 */
	private int x;

	/**
   	 * Composante graphique (ordonnée).
   	 */
	private int y;

	/**
   	 * Constructeur destiné à récuperer les informations pour la création de la fenêtre.
   	 *
   	 * @param recup nom de l'objet Fenetre()
   	 * @param error code d'erreur pour la lecture du fichier
   	 * @param recupfichier nom du fichier qui n'a pas été ouvert
   	 * @param couleur1 thème choisi
   	 * @param x1 abcisse de la fenêtre
   	 * @param couleur1 ordonnée de la fenêtre
   	 */
	public Fenetre (JFrame recup,int error,String recupfichier,JLabel couleur1,int x1, int y1){
		this.fenetre=recup;
		this.erreur=error;
		this.fichier=recupfichier;
		this.couleur=couleur1;
		this.x=x1;
		this.y=y1;
	}

	/**
   	 * Affiche la page d'accueil.
   	 */
	public void setFenetre(){
		int b,i;
		int [] tab = {2,0,3,1,4,4,5,9,6,16,7,25,8,36,9,49};

		fenetre.getContentPane().removeAll();
		fenetre.setVisible(false);

		fenetre.setTitle("SameGame");
		fenetre.setSize(700,700);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLayout(null);
		if(x==0 && y==0){
			fenetre.setLocation(450,50);
		}else{
			fenetre.setLocation(fenetre.getBounds().x,fenetre.getBounds().y);
		}
	
		JLabel titre = new JLabel("SAMEGAME");
	    titre.setBounds(0,0,710,75);
	    titre.setHorizontalAlignment(JLabel.CENTER);
	    titre.setFont(new Font("Serif", Font.BOLD, 35));

	    //panel regle
	    JPanel regle = new JPanel();
	    regle.setLayout(null);
	    regle.setBounds(50,100,350,400);

		try {
			FileReader fichier = new FileReader("regles.txt");
			BufferedReader flux = new BufferedReader(fichier);
			String ligne;
			b=70;
			try{
				while ((ligne = flux.readLine()) != null){
					JLabel jTextPane = new JLabel(ligne);
					if (b==70) {
						jTextPane.setBounds(55,b,280,20);
					} else {
					jTextPane.setBounds(35,b,280,20); }
					jTextPane.setBackground(new Color(172,229,72));
					jTextPane.setForeground(new Color(121,121,121));
					regle.add(jTextPane);
					b=b+20;
				}
			}catch (IOException f){
				System.out.println("Problème de lecture du fichier ! ");
			}
			try {
				flux.close();
			}catch (IOException g){
				g.printStackTrace();
			}
		}	
		catch (FileNotFoundException e){ 
			System.err.println("Problème d'ouverture du fichier !");
		}
		
		//titre du panel regle
		JLabel titrer = new JLabel("Règles Du Jeu:");
		titrer.setBounds(0,0,350,50);
	    titrer.setHorizontalAlignment(JLabel.CENTER);
	    titrer.setFont(new Font("Serif", Font.BOLD, 20));
	    titrer.setForeground(new Color(121,121,121));
	    regle.add(titrer);
		
		//panel point
		JPanel point = new JPanel();
		point.setLayout(null);
		point.setBounds(440,100,225,400);

		//panel qui reçoit le texte de point
		JPanel textep = new JPanel();
		textep.setLayout(new GridLayout(10,2));
		textep.setBounds(0,50,225,350);
		textep.setBackground(new Color(15,104,79,0));
		
		//titre du panel point
		JLabel titrep = new JLabel("Points:");
	    titrep.setBounds(0,0,225,50);
	    titrep.setHorizontalAlignment(JLabel.CENTER);
	    titrep.setForeground(new Color(121,121,121));
	    titrep.setFont(new Font("Serif", Font.BOLD, 20));
		point.add(titrep);

		//points par nombre de bloc
		JLabel bloc = new JLabel("Blocs");
		JLabel gain = new JLabel("Gain");
		bloc.setHorizontalAlignment(JLabel.CENTER);
		gain.setHorizontalAlignment(JLabel.CENTER);
		bloc.setForeground(new Color(121,121,121));
		gain.setForeground(new Color(121,121,121));
		textep.add(bloc);
		textep.add(gain);

		//insertion des valeurs dans les JLabel
		for(i=0;i<16;i++){
			String score = String.valueOf(tab[i]);
			JLabel boite = new JLabel(score);
			boite.setHorizontalAlignment(JLabel.CENTER);
			boite.setForeground(new Color(121,121,121));
			textep.add(boite);
		}
		JLabel n = new JLabel("n");
		JLabel n2 = new JLabel("(n-2)\u00b2");
		n.setHorizontalAlignment(JLabel.CENTER);
		n2.setHorizontalAlignment(JLabel.CENTER);
		n.setForeground(new Color(121,121,121));
		n2.setForeground(new Color(121,121,121));
		textep.add(n);
		textep.add(n2);
		point.add(textep);

		JRadioButton sombre = new JRadioButton("Sombre");
		sombre.setBounds(85,325,80,25);
		sombre.setForeground(new Color(121,121,121));
		sombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		regle.add(sombre);

		JRadioButton clair = new JRadioButton("Clair");
		clair.setBounds(185,325,80,25);
		clair.setForeground(new Color(121,121,121));
		clair.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		regle.add(clair);

		ButtonGroup group = new ButtonGroup();
		group.add(sombre);
		group.add(clair);

		JButton fichier = new JButton("FICHIER");
	    fichier.setBounds(125,550,200,50);
	    fichier.setFont(new Font("Serif", Font.BOLD,15));
	    fichier.addActionListener(new GrilleF(fenetre,couleur));

		JButton jouer = new JButton("JOUER");
	    jouer.setBounds(375,550,200,50);
	    jouer.setFont(new Font("Serif", Font.BOLD,15));
	    jouer.addActionListener(new Grille(fenetre,couleur));

	    //thème de la fenêtre en fonction des bouton sombre et clair
	    if(couleur.getText()=="clair"){
			fenetre.getContentPane().setBackground(new Color(224,187,228));
            titre.setForeground(new Color(149,125,173));
            regle.setBackground(new Color(210,145,188));
            point.setBackground(new Color(210,145,188));
            sombre.setBackground(new Color(210,145,188));
            clair.setBackground(new Color(210,145,188));
            fichier.setBackground(new Color(210,145,188));
            jouer.setBackground(new Color(210,145,188));
            clair.setSelected(true);
        }else{
        	fenetre.getContentPane().setBackground(new Color(31,35,35));
			titre.setForeground(new Color(21,203,222));
			regle.setBackground(new Color(15,104,79,50));
			point.setBackground(new Color(15,104,79,50));
			sombre.setBackground(new Color(15,104,79));
            clair.setBackground(new Color(15,104,79));
            fichier.setBackground(new Color(21,203,200));
            jouer.setBackground(new Color(21,203,200));
        	sombre.setSelected(true);
        }

	    sombre.addActionListener(new Couleur(fenetre,titre,regle,point,sombre,clair,fichier,jouer,couleur));
	    clair.addActionListener(new Couleur(fenetre,titre,regle,point,sombre,clair,fichier,jouer,couleur));

	    //affiche l'erreur d'ouverture du fichier sur la fenetre
	    if(erreur==1){
	    	JLabel erreur = new JLabel("Impossible d'afficher la grille, elle doit être de taille 15x10 !");
		    erreur.setBounds(0,600,700,50);
		    erreur.setHorizontalAlignment(JLabel.CENTER);
		    erreur.setForeground(new Color(231,54,54));
		    erreur.setForeground(new Color(231,54,54));
			fenetre.add(erreur);
	    }else if(erreur==2){
	    	JLabel erreur = new JLabel("Impossible de lire dans le fichier "+this.fichier+" !");
		    erreur.setBounds(0,600,700,50);
		    erreur.setHorizontalAlignment(JLabel.CENTER);
		    erreur.setForeground(new Color(231,54,54));
			fenetre.add(erreur);
	    }else if(erreur==3){
	    	JLabel erreur = new JLabel("Impossible de fermer le fichier "+this.fichier+" !");
		    erreur.setBounds(0,600,700,50);
		    erreur.setHorizontalAlignment(JLabel.CENTER);
		    erreur.setForeground(new Color(231,54,54));
			fenetre.add(erreur);
	    }else if(erreur==4){
	    	JLabel erreur = new JLabel("Impossible d'ouvrir le fichier "+this.fichier+" en lecture !");
		    erreur.setBounds(0,600,700,50);
		    erreur.setHorizontalAlignment(JLabel.CENTER);
		    erreur.setForeground(new Color(231,54,54));
			fenetre.add(erreur);
	    }else if(erreur==5){
	    	JLabel erreur = new JLabel("Impossible de lire dans le fichier "+this.fichier+" !");
		    erreur.setBounds(0,600,700,50);
		    erreur.setHorizontalAlignment(JLabel.CENTER);
		    erreur.setForeground(new Color(231,54,54));
			fenetre.add(erreur);
	    }else if(erreur==6){
	    	JLabel erreur = new JLabel("Impossible de fermer le fichier "+this.fichier+" !");
		    erreur.setBounds(0,600,700,50);
		    erreur.setHorizontalAlignment(JLabel.CENTER);
		    erreur.setForeground(new Color(231,54,54));
			fenetre.add(erreur);
	    }else if(erreur==7){
	    	JLabel erreur = new JLabel("Impossible d'ouvrir le fichier "+this.fichier+" en lecture !");
		    erreur.setBounds(0,600,700,50);
		    erreur.setHorizontalAlignment(JLabel.CENTER);
		    erreur.setForeground(new Color(231,54,54));
			fenetre.add(erreur);
	    }else if(erreur==8){
	    	JLabel erreur = new JLabel("Impossible de lancer le jeu : aucun fichier n'a été choisi choisi !");
		    erreur.setBounds(0,600,700,50);
		    erreur.setHorizontalAlignment(JLabel.CENTER);
		    erreur.setForeground(new Color(231,54,54));
			fenetre.add(erreur);
	    }

	    fenetre.add(fichier);
	    fenetre.add(jouer);
	    fenetre.add(titre);
	    fenetre.add(regle);
	    fenetre.add(point);

	    fenetre.setVisible(true);
	    fenetre.revalidate();
	}

	/**
   	 * Affiche la page d'accueil quand le bouton rejouer est cliqué.
   	 */
	@Override
    public void actionPerformed(ActionEvent e){
        setFenetre();
    }
}