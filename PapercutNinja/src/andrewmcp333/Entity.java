package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Entity
{
	public float x, y;
	private Image image;
	private float speed = 1f;
	
	public Entity(int x, int y, String image) throws SlickException
	{
		this.x = x * 64;
		this.y = y * 64;
		
		this.image = new Image(image);
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public boolean update(Action action, int delta)
	{
		if(x < action.getX() - 0.25)
		{
			x += speed * delta;
		}
		else if(x > action.getX() + 0.25)
		{
			x -= speed * delta;
		}
		
		if(y < action.getY() - 0.25)
		{
			y += speed * delta;
		}
		else if(y > action.getY() + 0.25)
		{
			y -= speed * delta;
		}
		
		return x == action.getX() && y == action.getY();
	}
	
	public void render(Camera camera)
	{
		image.draw(x - camera.getOffset(), y);
	}
}