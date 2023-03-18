package Graphics;



public class SpriteSheet extends GraphicLoadable {
	
	SpriteSheet(String path){
		super(path);
	}
	
	public static SpriteSheet grass= new SpriteSheet("/MiniWorldSprites/Ground/Grass.png");
	public static SpriteSheet shore= new SpriteSheet("/MiniWorldSprites/Ground/Shore.png");
	public static SpriteSheet player= new SpriteSheet("/MiniWorldSprites/Characters/Workers/FarmerTemplate.png");

}
