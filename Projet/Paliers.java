  /**
 * La classe <code>Palier</code> est utilisée pour afficher les différents palier à atteindre pour avoir des étoiles.
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */

import javax.swing.*;
import java.awt.*;

public class Paliers{

    /**
     * Constructeur destiné à afficher les paliers en dessous des étoiles.
     */
    public Paliers(JFrame fenetre,JLabel couleur){
        JLabel pts= new JLabel("300");
        pts.setBounds(20,40,50,50);
        pts.setHorizontalAlignment(JLabel.CENTER);
        pts.setFont(new Font("Serif", Font.BOLD, 10));

        JLabel pts1 = new JLabel("600");
        pts1.setBounds(75,40,50,50);
        pts1.setHorizontalAlignment(JLabel.CENTER);
        pts1.setFont(new Font("Serif", Font.BOLD, 10));

        JLabel pts2 = new JLabel("1 000");
        pts2.setBounds(125,40,50,50);
        pts2.setHorizontalAlignment(JLabel.CENTER);
        pts2.setFont(new Font("Serif", Font.BOLD, 10));

        JLabel pts3 = new JLabel("1 500");
        pts3.setBounds(175,40,50,50);
        pts3.setHorizontalAlignment(JLabel.CENTER);
        pts3.setFont(new Font("Serif", Font.BOLD, 10));

        JLabel pts4 = new JLabel("2 000");
        pts4.setBounds(225,40,50,50);
        pts4.setHorizontalAlignment(JLabel.CENTER);
        pts4.setFont(new Font("Serif", Font.BOLD, 10));

        if(couleur.getText()=="clair"){
            pts.setForeground(new Color(133,101,196));
            pts1.setForeground(new Color(133,101,196));
            pts2.setForeground(new Color(133,101,196));
            pts3.setForeground(new Color(133,101,196));
            pts4.setForeground(new Color(133,101,196));
        }else{
            pts.setForeground(new Color(21,203,222));
            pts1.setForeground(new Color(21,203,222));
            pts2.setForeground(new Color(21,203,222));
            pts3.setForeground(new Color(21,203,222));
            pts4.setForeground(new Color(21,203,222));
        }

        fenetre.add(pts);
        fenetre.add(pts1);
        fenetre.add(pts2);
        fenetre.add(pts3);
        fenetre.add(pts4);
    }
}


        