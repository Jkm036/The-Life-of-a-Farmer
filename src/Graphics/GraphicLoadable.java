package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GraphicLoadable {
protected String path;
BufferedImage img;
int width, height;
public int pixels[];


	protected GraphicLoadable(String path){
		this.path=path;
		load();		
	}
public void load(){
	try {   
		img=ImageIO.read(GraphicLoadable.class.getResource(this.path));
		width=img.getWidth();
		height= img.getHeight();
		pixels=new int[width*height];
		img.getRGB(0, 0, width, height, pixels, 0, width);
		//((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("Error loading image...");
	}
}
}
