
package ImageFragmentation;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;


public class ImageFragmentation {
    
    private BufferedImage img;
    private BufferedImage[][] parts;
    public ImageFragmentation(BufferedImage img){
        this();
        this.img = img;
        this.img = resize(img, 400, 400);

    }
    public ImageFragmentation(){
        parts = new BufferedImage[4][4];
    }
    
    public void setImage(BufferedImage img){
        this.img = img;
        img = resize(img, 400, 400);
    }
    
    public void imageFrag(){
        
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                this.parts[i][j] = img.getSubimage(i*100, j*100, 100, 100);
                
            }
        }
    }
    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    public BufferedImage[][] getFragmentedImages(){
        imageFrag();
        return parts;
    }
}
