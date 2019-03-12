
package ImageOperations;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;

public class AddImage implements Icon{
    private ImageProperties img = null;
    private BufferedImage imgs;
    public AddImage(ImageProperties img){
        this.img = img;
    }
    
    public AddImage(BufferedImage imgs){
        this.imgs = imgs;
        img = null;
    }

    
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g1 = (Graphics2D) g;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        if(img != null)
            g1.drawImage(img.getImg(), img.getX(), img.getY(),img.getWidth(),img.getHeight(),c);
        else
            g1.drawImage(imgs,0,0,100,100,c);
    }

    @Override
    public int getIconWidth() {
        if(img != null)
            return  img.getWidth();
        else
            return imgs.getWidth();
    }

    @Override
    public int getIconHeight() {
        if(img != null)
            return  img.getHeight();
        else
            return  imgs.getHeight();
    }
    
    
}
