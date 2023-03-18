package Entities.Mobs;

import Event.Action;
import Event.ActionListener;
import Event.KeyPressed;
import Event.KeyReleased;
import Graphics.Sprite;
import Main.Game;

public class Player extends Mobs implements ActionListener{
private boolean up,down,left,right;
public int size=16;
public Sprite sprite;
	public Player(int xScroll, int yScroll){		
		this.setX(xScroll);
		this.y=yScroll;
		sprite=Sprite.player_f;
	}

	public void render() {
		Game.screen.render_player(this);
	}
	public void tick() {
		if(up)
			y--;
		if(down)
			y++;
		if(left)
			x--;
		if(right)
			x++;
	}
	@Override
	public void Listen(Action a) {
		if(a instanceof KeyPressed) {
			switch (a.type) {
			case UP:
				up=true;break;
			case DOWN:
				down=true;break;
			case LEFT:
				left=true;break;
			case RIGHT:
				right=true;break;
			}
		}
		if(a instanceof KeyReleased) {
			switch (a.type) {
			case UP:
				up=false;break;
			case DOWN:
				down=false;break;
			case LEFT:
				left=false;break;
			case RIGHT:
				right=false;break;
			}
		}
		
	}
	
	
}
