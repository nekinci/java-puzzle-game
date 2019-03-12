
package GuiOperations;

import ImageOperations.AddImage;
import ImageOperations.ImageProperties;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;

public class ImageButton extends JButton {
    
    private BufferedImage img;
    public ImageButton(BufferedImage img){
        this.img = img;
        setSize(100,100);
    }
    
    public void setImage(BufferedImage img){
        this.img = img;
    }
    
    public BufferedImage imageCopy(){
        return img;
    }
    
    // Tabi bu class olmasa JButtona resim eklede onu konumlandırda sonra onun resimlerini değiştirde bi ton iş
    // Nesne yönelimli programlamanın en sevdiğim yanı bu işte seviyoruz seni JAVA :)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g1 = (Graphics2D) g;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g1.drawImage(img,0,0,100,100,null);

    }
    
    


    
}
