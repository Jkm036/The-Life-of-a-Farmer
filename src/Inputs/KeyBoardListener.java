package Inputs;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Event.ActionListener;
import Event.KeyPressed;
import Event.KeyReleased;
public class KeyBoardListener implements KeyListener{

	boolean up=false,down=false,left=false,right=false;
	ActionListener listener;
	public KeyBoardListener(ActionListener listener){
		this.listener=listener;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		listener.Listen(new KeyPressed(e.getKeyCode()));	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		listener.Listen(new KeyReleased(e.getKeyCode()));
		
	}

}
