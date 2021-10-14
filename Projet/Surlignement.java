  /**
 * La classe <code>Surlignement</code> est utilisée pour surligner les cases et réorganiser la grille.
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Surlignement implements MouseListener{

    /**
     * Tableau des noms de chaque case.
     */
    private Bloc[] bloc;

    /**
     * Tableau des numéros de chaque blocs.
     */
    private int[] grille;

    /**
     * Numéro de la case sur la souris.
     */
    private int i;

    /**
     * Composante graphique (nom de la fenetre).
     */
    private JFrame fen;

    /**
     * Tableau des cases surlignées.
     */
    private int[] occupe;

    /**
     * Numéro des cases vide.
     */
    private int[] vide = new int[150];

    /**
     * Bloc de couleur vert.
     */
    private int compt;

    /**
     * Score du joueur.
     */
    private int score;

    /**
     * Composant graphique qui contient points.
     */
    private JPanel jeux;

    /**
     * Composant graphique qui contient le score.
     */
    private JLabel points;

    /**
     * Composante graphique ("sombre" ou "clair").
     */
    private JLabel couleur;

    /**
    *Composante graphique qui contient le nombre de cases surlignées
    */
    private JLabel cases;

    /**
    *Composante graphique qui contient le score ajouté si l'utilisateur clique
    */
    private JLabel affscore;

    /**
     * Constructeur destiné à récuperer les informations pour mettre à jour la grille et le score.
     *
     * @param recupbloc nom des cases
     * @param recupgrille numéro des blocs
     * @param indice indice de la case
     * @param fenetre nom de l'objet Fenetre()
     * @param occu numéro des cases surlignées
     * @param sco score actuel
     * @param recupjeux position du panel où se trouve pts
     * @param pts zone de texte où est positioné le score
     * @param couleur1 thème choisi
     * @param recupscases nombre de cases surlignés
     * @param recupaffscore nombre de points ajoutés
     */
    public Surlignement(Bloc[] recupbloc,int[] recupgrille, int indice, JFrame fenetre,int[] occu, int sco,
        JPanel recupjeux, JLabel pts,JLabel couleur1, JLabel recupcases, JLabel recupaffscore){
        int t;
        this.bloc=recupbloc;
        this.grille=recupgrille;
        this.i=indice;
        this.fen=fenetre;
        this.occupe=occu;
        this.score=sco;
        this.jeux=recupjeux;
        this.points= pts;
        for(t=0;t<150;t++){
            vide[t]=0;
        }
        this.couleur=couleur1;
        this.cases=recupcases;
        this.affscore=recupaffscore;
    }

    /**
     * Renvoie le numéro de la case du dessous si celle-ci est occupé.
     * @return le numéro de la case du dessous sinon une valeur prédéfinie (i-15 ou -1)
     */
    public int test1(){
        occupe[i]=grille[i];
        if(i>=15 && grille[i]==grille[i-15]){
            return i-15;
        }
        return -1;
    }

    /**
     ** Renvoie le numéro de la case du dessus si celle-ci est occupé.
     * @return le numéro de la case du dessus sinon une valeur prédéfinie (i+15 ou -1)
     */
    public int test2(){
        occupe[i]=grille[i];
        if(i<=134 && grille[i]==grille[i+15]){
            return i+15;
        }
        return -1;
    }

    /**
     ** Renvoie le numéro de la case de droite si celle-ci est occupé.
     * @return le numéro de la case de droite sinon une valeur prédéfinie (i+1 ou -1)
     */
    public int test3(){
        occupe[i]=grille[i];
        if(i%15!=14 && grille[i]==grille[i+1] ){
            return i+1;
        }
        return -1;
    }

    /**
     ** Renvoie le numéro de la case de gauche si celle-ci est occupé.
     * @return le numéro de la case de gauche sinon une valeur prédéfinie (i-1 ou -1)
     */
    public int test4(){
        occupe[i]=grille[i];
        if(i%15!=0 && grille[i]==grille[i-1]){
            return i-1;
        }
        return -1;
    }

//------------------------------------------------------------mouseEntered------------------------------------------------------------//
    /**
     * Récursivité qui permet d'obtenir les cases adjacentes à celle où se trouve la souris et ainsi de suite.
     */
    public void recursivent (int nouv){
        this.i=nouv;
        int testA=-1;
        int testB=-1;
        int testC=-1;
        int testD=-1;
        testA=test1();
        testB=test2();
        testC=test3();
        testD=test4();
        if(testA!=-1 && grille[testA]!=occupe[testA]){
            recursivent(testA);
        }
        if(testB!=-1 && grille[testB]!=occupe[testB]){
            recursivent(testB);
        }
        if(testC!=-1 && grille[testC]!=occupe[testC]){
            recursivent(testC);
        }
        if(testD!=-1 && grille[testD]!=occupe[testD]){
            recursivent(testD);
        }
    }

    /**
     * Surligne la case sous la souris et les cases adjacentes et affiche le nombre de cases 
     * surlignées et le score ajouté si le joueur clique sur la case.
     */
    public void coloriage(){
        int a,b,cpt=0,compteur=0,compteur2=0;
        for(a=0;a<150;a++){
            if(grille[a]==occupe[a] && grille[a]!=0){
                cpt++;
            }
        }
        if(cpt>1){
            for(b=0;b<150;b++){
                if(grille[b]==occupe[b] && grille[b]!=0){
                    bloc[b].setOpaque(true);
                    bloc[b].setBackground(new Color(130,148,227));
                    compteur++;
                }
            }
            this.cases.setText("Cases séléctionnées : "+compteur);
            Score sco = new Score(compteur,0);
            this.affscore.setText("+"+sco.getScore());
        }
        fen.repaint();
    }
//------------------------------------------------------------mouseExited------------------------------------------------------------//
    /**
     * Réapplique le fond d'origine à la case sous la souris et les cases adjacentes.
     */
    public void recursivexit(){
        int a;
        for (a=0;a<150;a++){
            if (occupe[a]!=0){
                bloc[a].setOpaque(false);
                bloc[a].setBackground(new Color(31,35,35));
                occupe[a]=0;
            }
        }
        this.cases.setText("Cases séléctionnées : 0");
        this.affscore.setText("+0");
        fen.repaint();
    }
//------------------------------------------------------------mouseClicked------------------------------------------------------------//

    /**
     * Vide la case sous la souris et les cases adjacentes.
     */
    public void clicked(){
        int a,b,cpt=0;
        String point1;
        for(a=0;a<150;a++){
            if(grille[a]==occupe[a] && grille[a]!=0){
                cpt++;
            }
        }
        if(cpt>1){
            fen.getContentPane().removeAll();
            jeux.removeAll();

            Score sc = new Score(cpt,score);
            this.score=sc.getScore();
            point1="Score : "+this.score;
            points.setText(point1);
            if(couleur.getText()=="clair"){
                points.setForeground(new Color(133,101,196));
            }else{
                points.setForeground(new Color(21,203,222));
            }

            for (b=0;b<150;b++){
                if (occupe[b]!=0){
                    JLabel tre;
                    jeux.add(tre = new JLabel());
                    occupe[b]=0;
                    grille[b]=0;
                    vide[b]=1;
                    bloc[b]=new Bloc(4);
                }else{
                    jeux.add(bloc[b] = new Bloc(grille[b]));
                    bloc[b].addMouseListener(new Surlignement(bloc,grille,b,fen,occupe, score,jeux, points,couleur,cases, affscore));
                }
            }

            fen.add(jeux);
            fen.add(points);
            fen.add(cases);
            fen.add(affscore);
            points.repaint();
            fen.revalidate();
        }
    }

    /**
     * Réorganise la grille par ligne puis par colonne.
     */
    public void reorganisation(){
        int a,b,nb,cpt2=0;
        int e=135,cpt3=0,c,d,k,l, val1=0, dec=0,h=14,z;

        for(b=149;b>0;b--){
            if(vide[b]==1){
                this.i=b;
                nb=b%15;
                for(a=b;a>nb;a=a-15){
                    if(vide[a]==1){
                        cpt2++;                      
                    } else {
                        a=nb;
                    }
                }
                grille[i]=grille[(i-(cpt2*15))];
                grille[(i-(cpt2*15))]=0;
                vide[i]=0;
                vide[i-(cpt2*15)]=1;
                cpt2=0;
            }
        }
        this.maj();

        cpt3=0;
        for(c=0;c<15;c++){
            for(d=0;d<=e+c;d=d+15){
                if(grille[d+c]==0){
                    cpt3++;
                }
            }
            if(cpt3==10){
                val1=(d+c)%15;
                if (val1<h){
                    while (val1<h){
                        for(l=148; l>=135; l-- ){
                            if ((l%15)==val1){
                                for (z=l; z>=(l-135); z=z-15){
                                    if(z+1<(150-dec)){
                                        grille[z]=grille[z+1];
                                        grille[z+1]=0;
                                        vide[z]=0;
                                    }
                                }
                                l=135;
                            }
                        }
                        val1++;
                    }
                    dec++;
                    h--;
                    c--;
                }
            }
            cpt3=0;
        }
        for (z=0;z<=149;z++){
            if (grille[z]==0){
                vide[z]=1;
            } else {vide[z]=0;}
        }
        this.maj();
    }

    /**
     * Affiche la grille avec les nouvelles positions.
     */
    public void maj(){
        int a;
        fen.getContentPane().removeAll();
        jeux.removeAll();

        Etoile barre = new Etoile(score);
        barre.setBounds(0,0,500,100);

            for (a=0;a<150;a++){
                if (vide[a]==1){
                    JLabel tre;
                    jeux.add(tre = new JLabel());
                    occupe[a]=0;
                    grille[a]=0;
                    vide[a]=1;
                    bloc[a]=new Bloc(4);
                }else if (vide[a]==0){
                    jeux.add(bloc[a] = new Bloc(grille[a]));
                    bloc[a].addMouseListener(new Surlignement(bloc,grille,a,fen,occupe, score,jeux, points,couleur,cases, affscore));
                }
            }

        Paliers pts = new Paliers(fen,couleur);

        fen.add(barre);
        fen.add(jeux);
        fen.add(points);
        fen.add(cases);
        fen.add(affscore);
        fen.revalidate();
    }

    /**
     * Renvoie la condition de fin de jeux si le joueur ne peux plus jouer.
     * @return la conditon de fin de jeux
     */
    public boolean parcours(){
        int a,cpt=0,cpt2=0;
        for(a=0;a<150;a++){
            if(vide[a]==1){
                cpt++;
            }
        }
        if(cpt==149){
            return true;
        }

        for(a=0;a<150;a++){
            if(a>14 && grille[a]==grille[a-15] && grille[a]!=0){
                cpt2++;
            }else if(a<135 && grille[a]==grille[a+15] && grille[a]!=0){
                cpt2++;
            }else if(a>0 && grille[a]==grille[a-1] && grille[a]!=0){
                cpt2++;
            }else if(a<149 && grille[a]==grille[a+1] && grille[a]!=0){
                cpt2++;
            }
        }
        if(cpt2==0){
            return true;
        }
        return false;
    }
//------------------------------------------------------------Override------------------------------------------------------------//

    /**
     * Change le fond sur toutes les cases surlignées quand la souris entre dans la case.
     */
    @Override
    public void mouseEntered(MouseEvent e){
        recursivent(i);
        coloriage();
    }

    /**
     * Applique le fond d'origine sur toutes les cases surlignées quand la souris sort de la case.
     */
    @Override
    public void mouseExited(MouseEvent e){
        recursivexit();
    }

    /**
     * Vide toutes les cases surlignées et réorganise la grille quand le souris est cliqué.
     */
    @Override
    public void mouseClicked(MouseEvent e){
        clicked();
        reorganisation();
        if(parcours()==true){
            Fin fin = new Fin(fen,score,couleur);
            fin.refresh();
        }
    }
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}