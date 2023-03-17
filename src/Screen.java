import java.util.Random;

public class Screen {
int[] pixels;
int MAP_WIDTH=16,MAP_HEIGHT=16;
int TILE_SIZE=16;
int[] tiles=new int[MAP_WIDTH*MAP_HEIGHT];
Random random;
int width,height;
int yy,xx;
public int xOffset=0,yOffset=0;
	Screen(int[] pixels, int width, int height){
		this.width=width;
		this.height=height;
		this.pixels=pixels;
		random= new Random(0xffffff);
		for(int i=0;i< tiles.length;i++) {
			tiles[i]=random.nextInt();
		}
	}
	public void clear() {
		for(int i=0;i<pixels.length;i++) {
			pixels[i]=0;
		}
	}

	public void render() {
		for(int y=0;y<height;y++ ) {
			yy=(y+yOffset);
			for(int x =0;x<width;x++){
				xx=(x+xOffset);
				pixels[x +(y*width)]=tiles[((xx/TILE_SIZE)& (MAP_WIDTH-1)) +(((yy/TILE_SIZE)&(MAP_HEIGHT-1))*MAP_WIDTH)];
			}
		}
	}
	
}
