package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ninja extends Entity
{
	public Ninja(int x, int y) throws SlickException
	{
		super(x, y, "./res/ninja.png");
	}
	
	public Action requestAction(Input input)
	{
		if(input.isKeyPressed(Input.KEY_D)) {return new Action(this, Direction.SOUTHEAST);}
		if(input.isKeyPressed(Input.KEY_A)) {return new Action(this, Direction.SOUTHWEST);}
		if(input.isKeyPressed(Input.KEY_S)) {return new Action(this, Direction.SOUTH);}
		if(input.isKeyPressed(Input.KEY_W)) {return new Action(this, Direction.NORTH);}
		if(input.isKeyPressed(Input.KEY_E)) {return new Action(this, Direction.NORTHEAST);}
		if(input.isKeyPressed(Input.KEY_Q)) {return new Action(this, Direction.NORTHWEST);}
		
		return null;
	}
}