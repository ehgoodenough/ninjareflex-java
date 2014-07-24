package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ninja extends Entity
{
	private Image image;
	
	public Ninja(int x, int y) throws SlickException
	{
		this.x = x;
		this.y = y;
		
		this.image = new Image("./res/ninja.png");
	}
	
	public void update(Input input, int delta)
	{
		if(input.isKeyPressed(Input.KEY_D))
		{
			this.x++;
		}
		else if(input.isKeyPressed(Input.KEY_A))
		{
			this.x--;
		}
		else if(input.isKeyPressed(Input.KEY_S))
		{
			this.y++;
		}
		else if(input.isKeyPressed(Input.KEY_W))
		{
			this.y--;
		}
		else if(input.isKeyPressed(Input.KEY_E))
		{
			this.x++;
			this.y--;
		}
		else if(input.isKeyPressed(Input.KEY_Q))
		{
			this.x--;
			this.y--;
		}
	}
	
	public void render(Camera camera)
	{
		//int x = Math.min(getPixelyX(), (11/2)*64));
		//int y = getPixelyY();

		int x = getX() - camera.getOffset();
		int y = getY();
		
		image.draw(x, y);
	}
	
	public int getX()
	{
		return x * 64;
	}
	
	public int getY()
	{
		return y * 64;
	}
}