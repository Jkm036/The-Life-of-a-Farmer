package Graphics;

import java.util.ArrayList;

import Entities.Entity;
import Entities.Mobs.Player;
import Event.Action;
import Event.ActionListener;
import Main.Game;

public class World extends GraphicLoadable implements ActionListener{
	//background will be a list of MAP_SIZExMAP_SIZE pixels
 public int background[];
 public int foreground[];
 Player player;
 int xScroll,yScroll;
 public boolean up,down,left, right;
 public int MAP_WIDTH,MAP_HEIGHT;
 private ArrayList<Entity> entities= new ArrayList<Entity>();
 
  public World(String path, Player player){
	  super(path);
	 this.MAP_WIDTH=width;
	 this.MAP_HEIGHT=height;
	 this.player=player;
	 this.xScroll=(player.getX()-(Game.screen.screen_width>>1));
	 this.yScroll=(player.getY()-(Game.screen.screen_height>>1)); 
	 this.background=pixels;
	 this.player=player;
	 entities.add(this.player);
  }
  
  public void render() {
	  Game.screen.render_map(this,xScroll,yScroll);
	  for(Entity e: entities) {
		  e.render();
	  }
  }
  public void tick() {
	for(Entity e: entities) {
		  e.tick();
	  }
	  xScroll=(player.getX()-(Game.screen.screen_width>>1));
	  yScroll=(player.getY()-(Game.screen.screen_height>>1));
	  
  }

@Override
public void Listen(Action a) {
	player.Listen(a);
}
}
