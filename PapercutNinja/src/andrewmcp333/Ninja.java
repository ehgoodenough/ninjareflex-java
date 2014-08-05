package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ninja extends Entity
{
	private Image image;
	
	private float speed = 1f;
	public Action action;
	
	public Ninja(int x, int y) throws SlickException
	{
		this.x = x * 64;
		this.y = y * 64;
		
		this.image = new Image("./res/ninja.png");
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
		
		if(x == action.getX() && y == action.getY())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void render(Camera camera)
	{
		image.draw(x - camera.getOffset(), y);
	}
	
	public Action requestAction(Input input)
	{
		if(input.isKeyPressed(Input.KEY_D)) {return new Action(this, Direction.EAST);}
		if(input.isKeyPressed(Input.KEY_A)) {return new Action(this, Direction.WEST);}
		if(input.isKeyPressed(Input.KEY_S)) {return new Action(this, Direction.SOUTH);}
		if(input.isKeyPressed(Input.KEY_W)) {return new Action(this, Direction.NORTH);}
		if(input.isKeyPressed(Input.KEY_E)) {return new Action(this, Direction.NORTHEAST);}
		if(input.isKeyPressed(Input.KEY_Q)) {return new Action(this, Direction.NORTHWEST);}
		
		return null;
	}
}