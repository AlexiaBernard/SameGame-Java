/**
 * La classe <code>Bloc</code> est utilisée pour dessiner un bloc parmis les trois possible.
 *  
 * @version 1.1
 * @author Florian CUNSOLO et Aléxia BERNARD
 */


import javax.swing.JComponent;
import java.awt.*;
 
public class Bloc extends JComponent {
  
  /**
   * Bloc de couleur vert.
   */
  private Image vert;

  /**
   * Bloc de couleur rouge.
   */
  private Image rouge;

  /**
   * Bloc de couleur bleu.
   */
  private Image bleu;

  /**
   * Numéros qui determine la couleur du bloc.
   */
  private int ordre;

  /**
   * Constructeur destiné à récuperer les informations pour afficher le type de bloc.
   *
   * @param recu numéro du bloc choisi
   */
  public Bloc(int recu) {
    super();
    this.vert = Toolkit.getDefaultToolkit().getImage("vert.png");
    this.rouge = Toolkit.getDefaultToolkit().getImage("rouge.png");
    this.bleu = Toolkit.getDefaultToolkit().getImage("bleu.png");
    this.ordre=recu;
  }

  /**
   * Dessine dans chaque case le bloc qui a été choisi.
   */
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    if (this.isOpaque()) {
      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    secondPinceau.setColor(this.getForeground());

    if(ordre==1){
      secondPinceau.drawImage(this.vert, (this.getWidth()-this.vert.getWidth(null))/2,(this.getHeight()-this.vert.getHeight(null))/2,this);
    }else if(ordre==2){
      secondPinceau.drawImage(this.rouge, (this.getWidth()-this.rouge.getWidth(null))/2, (this.getHeight()-this.rouge.getHeight(null))/2,this);
    }else if(ordre==3){
      secondPinceau.drawImage(this.bleu, (this.getWidth()-this.bleu.getWidth(null))/2,(this.getHeight()-this.bleu.getHeight(null))/2,this);
    }else if(ordre==4){}
  }
}