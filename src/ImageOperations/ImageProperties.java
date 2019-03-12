
package ImageOperations;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageProperties {
    
    private int width,height,x,y;
	private BufferedImage img;
	
	public ImageProperties(String path,int width,int height) {
		this.width = width; this.height = height;
		this.x = 0; this.y = 0;
		try {
			File file = new File(path);
			img = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("IO Hatası : "+e.getMessage() + " " + path);
			e.printStackTrace();
		}
	}

	public ImageProperties(String path,int x,int y, int width,int height){
		this(path,width,height);
		this.x = x;
		this.y = y;
	}
	
	public BufferedImage getImg() {
		return img;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

	public int getX(){ return x; }

	public int getY() { return y; }
}
