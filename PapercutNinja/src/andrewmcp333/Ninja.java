package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ninja extends Entity
{
	private Image image;
	
	public int tx, ty;
	
	private float speed = 1f;
	
	public Ninja(int x, int y) throws SlickException
	{
		this.tx = x;
		this.ty = y;
		this.x = x * 64;
		this.y = y * 64;
		
		this.image = new Image("./res/ninja.png");
	}
	
	public void update(int delta)
	{
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
	
	public Action getAction(Input input)
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