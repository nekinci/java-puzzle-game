/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Niyazi
 */
public class Test {
    
    public static void main(String[] args) {
        
        BufferedImage img = null;
        File f = null;
        
        try {
            f = new File("alanya4.jpg");
            img = ImageIO.read(f);
            
            BufferedImage tmp = img;
            
            for (int i = 0; i < tmp.getWidth(); i++){
                for (int j = 0; j < tmp.getHeight(); j++){
                    if(tmp.getRGB(i, j) == img.getRGB(i, j))
                        System.out.println("Eşleşti");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
