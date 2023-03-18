package Main;

import Entities.Mobs.Player;
import Graphics.Sprite;
import Graphics.World;

public class Screen {
int pixels[];
public int screen_width,screen_height;

public int xOffset=0,yOffset=0;
	Screen(int pixels[], int width, int height){
		this.screen_width=width;
		this.screen_height=height;
		this.pixels=pixels;
	}
	public void clear() {
		for(int i=0;i<pixels.length;i++) {
			pixels[i]=0;
		}
	}

	public void render_map(World world, int xScroll,int yScroll) {
		xOffset=xScroll;
		yOffset=yScroll;
		int tile_index;
		int tile_map[]=world.background;
		//corner tiles to be rendered
		int x0=(xOffset>>4);
		int x1=((xOffset+screen_width)>>4)+1;		
		int y0=yOffset>>4;
		int y1=((yOffset+screen_height)>>4)+1;		
		
		for(int y=y0;y<y1;y++) {
			for( int x=x0;x<x1;x++) {
				if(x<0||y<0) {
				render_sprite((x*16),(y*16),Sprite.water);
				}else {
				tile_index=(x+(y*world.MAP_WIDTH));
				render_sprite((x*16),(y*16),Sprite.getSprite(tile_map[tile_index]));
				}
			}
		}
	}
	public void render_sprite(int rounded_xOffset,int rounded_yOffset, Sprite sprite) {
		 int yy,xx;
		 int slight_shift_x,slight_shift_y;
		 slight_shift_x=rounded_xOffset-xOffset;
		 slight_shift_y=rounded_yOffset-yOffset;
		 
		 for(int y=0;y<sprite.size;y++) {
			 yy=y+slight_shift_y;
			 for(int x=0;x<sprite.size;x++) {
				 xx=x+slight_shift_x;
				 if(xx<0||xx>=screen_width||yy<0||yy>=screen_height) {continue;}
				 pixels[xx+(yy*screen_width)]=sprite.pixels[x+(y*sprite.size)];
				 
			 }
		 }
		 
		
	}
	public void render_player(Player player) {
		int xp, yp;
		int col;
		int size=player.size;
		int player_pixels[]=player.sprite.pixels;
		for(int y=0;y<size;y++ ) {
			for(int x=0;x<size;x++) {
				xp=((screen_width>>1)-(size>>1));
				yp=((screen_height>>1)-(size>>1));
				col=player_pixels[x+(y*size)];
				if(col==0xFFFF00FA)
					continue;
				pixels[(xp+x)+(yp+y)*screen_width]=col;
			}
		}
	}

}
