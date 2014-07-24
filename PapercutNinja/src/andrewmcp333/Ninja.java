package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ninja extends Entity
{
	private Image image;
	
	private int tx, ty;
	
	private float speed = 1f;
	
	public Ninja(int x, int y) throws SlickException
	{
		this.tx = x;
		this.ty = y;
		this.x = x * 64;
		this.y = y * 64;
		
		this.image = new Image("./res/ninja.png");
	}
	
	public void update(Input input, int delta)
	{
		if(input.isKeyPressed(Input.KEY_D))
		{
			tx++;
		}
		else if(input.isKeyPressed(Input.KEY_A))
		{
			tx--;
		}
		else if(input.isKeyPressed(Input.KEY_S))
		{
			ty++;
		}
		else if(input.isKeyPressed(Input.KEY_W))
		{
			ty--;
		}
		else if(input.isKeyPressed(Input.KEY_E))
		{
			tx++;
			ty--;
		}
		else if(input.isKeyPressed(Input.KEY_Q))
		{
			tx--;
			ty--;
		}
		
		
		
		if(x < (tx - 0.1) * 64)
		{
			x += speed * delta;
		}
		else if(x > (tx + 0.1) * 64)
		{
			x -= speed * delta;
		}
		else
		{
			x = tx * 64;
		}
		
		if(y < (ty - 0.1) * 64)
		{
			y += speed * 2 * delta;
		}
		else if(y > (ty + 0.1) * 64)
		{
			y -= speed * 2 * delta;
		}
		else
		{
			y = ty * 64;
		}
	}
	
	public void render(Camera camera)
	{
		image.draw(x - camera.getOffset(), y);
	}
}