package andrewmcp333;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Missile extends Entity
{
	public Missile(int x, int y) throws SlickException
	{
		super(x, y, "./res/missile.png");
	}
	
	public Action requestAction()
	{
		return new Action(this, Direction.WEST);
	}
}