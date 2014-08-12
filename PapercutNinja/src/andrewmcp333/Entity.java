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
	
	public int getTileX()
	{
		return (int)(x / 64);
	}
	
	public int getTileY()
	{
		return (int)(y / 64);
	}
	
	public boolean update(Action action, int delta)
	{
		if(x < action.getNewX() - 0.25)
		{
			x += speed * delta;
		}
		else if(x > action.getNewX() + 0.25)
		{
			x -= speed * delta;
		}
		
		if(y < action.getNewY() - 0.25)
		{
			y += speed * delta;
		}
		else if(y > action.getNewY() + 0.25)
		{
			y -= speed * delta;
		}
		
		return x == action.getNewX() && y == action.getNewY();
	}
	
	public void render(Camera camera)
	{
		image.draw(x - camera.getOffset(), y);
	}
	
	public Action requestAction()
	{
		return null;
	}
}