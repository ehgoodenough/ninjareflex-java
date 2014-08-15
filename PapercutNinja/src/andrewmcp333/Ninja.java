package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ninja extends Entity
{
	public int jump = 3;
	public boolean jumping = true;
	
	public Ninja(int x, int y) throws SlickException
	{
		super(x, y, "./res/ninja.png");
	}
	
	public Action requestAction(Input input)
	{
		if(input.isKeyPressed(Input.KEY_D))
		{
			if(jump == 0)
			{
				return new Action(this, Direction.SOUTHEAST);
			}
			else
			{
				jump = 0;
				
				return new Action(this, Direction.EAST);
			}
		}
		
		if(input.isKeyPressed(Input.KEY_A))
		{
			if(jump == 0)
			{
				return new Action(this, Direction.SOUTHWEST);
			}
			else
			{
				jump = 0;
				
				return new Action(this, Direction.WEST);
			}
		}
		
		if(input.isKeyPressed(Input.KEY_S))
		{
			return new Action(this, Direction.SOUTH);
		}
		
		if(input.isKeyPressed(Input.KEY_W))
		{
			if(jump > 0)
			{
				jump -= 1;
				
				return new Action(this, Direction.NORTH);
			}
			else
			{
				return new Action(this, Direction.NONE);
			}
		}
		
		if(input.isKeyPressed(Input.KEY_E))
		{
			if(jump > 0)
			{
				jump -= 1;
				
				return new Action(this, Direction.NORTHEAST);
			}
			else
			{
				return new Action(this, Direction.SOUTHEAST);
			}
		}
		
		if(input.isKeyPressed(Input.KEY_Q))
		{
			if(jump > 0)
			{
				jump -= 1;
				
				return new Action(this, Direction.NORTHWEST);
			}
			else
			{
				return new Action(this, Direction.SOUTHWEST);
			}
		}
		
		return null;
	}
	
	public void collide(TiledLevel level)
	{
		int tx = getTileX();
		int ty = getTileY();
		
		if(ty + 1 <= level.getHeight() && level.hasCollider(tx, ty + 1))
		{
			jump = 3;
		}
	}
}