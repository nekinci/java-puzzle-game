
package ImageFragmentation;

import java.awt.image.BufferedImage;


public class ImageFragmentation {
    
    private BufferedImage img;
    private BufferedImage[][] parts;
    public ImageFragmentation(BufferedImage img){
        this();
        this.img = img;
    }
    public ImageFragmentation(){
        parts = new BufferedImage[4][4];
    }
    
    public void setImage(BufferedImage img){
        this.img = img;
    }
    
    public void imageFrag(){
        
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                this.parts[i][j] = img.getSubimage(i*100, j*100, 100, 100);
                
            }
        }
    }
    
    public BufferedImage[][] getFragmentedImages(){
        imageFrag();
        return parts;
    }
}
