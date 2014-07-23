package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ninja
{
	private float x, y;
	private Image image;
	
	public Ninja(float x, float y) throws SlickException
	{
		this.x = (x + 0.5f) * 64;
		this.y = (y + 0.5f) * 64;
		
		this.image = new Image("./res/ninja.png");
	}
	
	public void render()
	{
		int x = (int)this.x - (this.image.getWidth() / 2);
		int y = (int)this.y - (this.image.getHeight() / 2);
		
		image.draw(x, y);
	}
}