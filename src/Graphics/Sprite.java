package Graphics;

import Main.Game;

public class Sprite {
public int pixels[];
public int size=Game.SIZE;

	Sprite(int xCoord, int yCoord,SpriteSheet sheet){
		pixels=new int[size*size];
		this.loadSprite(xCoord,yCoord,sheet);	
	}
	
	private void loadSprite(int xCoord,int yCoord, SpriteSheet sheet) {
		for(int y=0;y<size;y++) {
			for(int x =0;x<size;x++) {
				pixels[x+(y*size)]=sheet.pixels[((xCoord*size)+x)+((yCoord*size)+y)*sheet.width];
			}
		}
	}
	
	public static Sprite getSprite(int tile_code) {
		if(tile_code==0xFF75F94D) {
			return grass;
		}else {
			return water;
		}
	}
	public static Sprite grass= new Sprite(2,0,SpriteSheet.grass);
	public static Sprite water= new Sprite(4,0,SpriteSheet.shore);
	// player sprites 
	public static Sprite player_f= new Sprite(0,0,SpriteSheet.player);
}

