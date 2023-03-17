
import java.awt.Canvas;

import java.awt.Dimension;
import java.awt.Graphics2D;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import Event.Action;
import Event.ActionListener;
import Event.KeyPressed;
import Event.KeyReleased;
import Inputs.KeyBoardListener;
public class Game extends Canvas implements Runnable, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	int width= 320;
	int height= width/12*9;
	int scale =3;
	double x,y=0;
	boolean up, down, left, right;
	Thread thread;
	boolean running=true;
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	int[] pixels= ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	Graphics2D g;
	Dimension d= new Dimension(width*scale, height*scale);
	BufferStrategy bs;
	Screen screen;
	KeyBoardListener keyboard;
	Game(){
		frame= new JFrame("Life of a farmer");
		frame.setSize(d);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
		//frame.pack();
		screen = new Screen(pixels,width, height);
		keyboard=new KeyBoardListener(this);
		this.addKeyListener(keyboard);
		
	}
	
	
	public void start() {
		double secondStart= System.currentTimeMillis();
		double Cyclestart= System.nanoTime();
		int numFrames=0;
		int numTicks=0;
		while(running){						
			double TIPT=1000000000.0/60;
			int ticks=(int) ((System.nanoTime()-Cyclestart)/TIPT);
			if(ticks>=1) {
				Cyclestart=System.nanoTime();
				while(ticks>0) {
					ticks--;
					numTicks++;	
					tick();
				}
			}			
			numFrames++;
			render();
			if((System.currentTimeMillis()- secondStart)>=100) {
				frame.setTitle("LOAF: Frames:"+ numFrames + " , Ticks: " +numTicks);
				numFrames=0;
				numTicks=0;
				secondStart=System.currentTimeMillis();
			}
		
		}
		
	}//end start
	public void tick() {
		if(up) 
			screen.yOffset--;
		if(down)
			screen.yOffset++;
		if(left)
			screen.xOffset--;
		if(right)
			screen.xOffset++;
	}
	public void render() {
		bs=getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		g= (Graphics2D) bs.getDrawGraphics();
		screen.render();
		g.drawImage(image,0,0 ,width*scale,height*scale, null);	
		screen.clear();
		bs.show();
		g.dispose();	
		
	}


	public static void main(String[] args) {
		Game game= new Game();
		game.start();
	}

	


	@Override
	public void run() {
		running=true;
		thread= new Thread(this);
		thread.start();
		
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
