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
	
	public void update(int delta)
	{
		if(action != null)
		{
			if(x < action.x - 0.25)
			{
				x += speed * delta;
			}
			else if(x > action.x + 0.25)
			{
				x -= speed * delta;
			}
			
			if(y < action.y - 0.25)
			{
				y += speed * delta;
			}
			else if(y > action.y + 0.25)
			{
				y -= speed * delta;
			}
			
			if(x == action.x && y == action.y)
			{
				action = null;
			}
		}
	}
	
	public void render(Camera camera)
	{
		image.draw(x - camera.getOffset(), y);
	}
	
	public Action requestCurrentAction(Input input)
	{
		if(input.isKeyPressed(Input.KEY_D)) {return new Action(x, y, Direction.EAST);}
		if(input.isKeyPressed(Input.KEY_A)) {return new Action(x, y, Direction.WEST);}
		if(input.isKeyPressed(Input.KEY_S)) {return new Action(x, y, Direction.SOUTH);}
		if(input.isKeyPressed(Input.KEY_W)) {return new Action(x, y, Direction.NORTH);}
		if(input.isKeyPressed(Input.KEY_E)) {return new Action(x, y, Direction.NORTHEAST);}
		if(input.isKeyPressed(Input.KEY_Q)) {return new Action(x, y, Direction.NORTHWEST);}
		
		return null;
	}
}