package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Entity
{
	public float x, y;
	private Image image;
	private float speed = 1f;
	
	public Entity(int tx, int ty, String image) throws SlickException
	{
		this.x = tx * 64;
		this.y = ty * 64;
		this.image = new Image(image);
	}
	
	public float getX()
	{
		return this.x;
	}
	
	public float getY()
	{
		return this.y;
	}
	
	public int getTileX()
	{
		return (int)(this.x / 64);
	}
	
	public int getTileY()
	{
		return (int)(this.y / 64);
	}
	
	public void update(Action action, int delta)
	{
		if(this.x < action.getNewX() - 0.25)
		{
			this.x += this.speed * delta;
		}
		else if(this.x > action.getNewX() + 0.25)
		{
			this.x -= this.speed * delta;
		}
		
		if(this.y < action.getNewY() - 0.25)
		{
			this.y += this.speed * delta;
		}
		else if(this.y > action.getNewY() + 0.25)
		{
			this.y -= this.speed * delta;
		}
	}
	
	public boolean isDone(Action action)
	{
		return this.x == action.getNewX()
			&& this.y == action.getNewY();
	}
	
	public void render(Camera camera)
	{
		image.draw(this.x - camera.getOffset(), this.y);
	}
	
	public Action requestAction()
	{
		return null;
	}
}