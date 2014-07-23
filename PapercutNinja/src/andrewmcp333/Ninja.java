package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
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
	
	public void update(Input input, int delta)
	{
		if(input.isKeyPressed(Input.KEY_D))
		{
			this.x += 64;
		}
		else if(input.isKeyPressed(Input.KEY_A))
		{
			this.x -= 64;
		}
		else if(input.isKeyPressed(Input.KEY_S))
		{
			this.y += 64;
		}
		else if(input.isKeyPressed(Input.KEY_W))
		{
			this.y -= 64;
		}
		else if(input.isKeyPressed(Input.KEY_E))
		{
			this.x += 64;
			this.y -= 64;
		}
		else if(input.isKeyPressed(Input.KEY_Q))
		{
			this.x -= 64;
			this.y -= 64;
		}
	}
	
	public void render()
	{
		int x = (int)this.x - (this.image.getWidth() / 2);
		int y = (int)this.y - (this.image.getHeight() / 2);
		
		image.draw(x, y);
	}
}