package andrewmcp333;

public class Action
{
	public float x, y;
	
	public Action(float x, float y, Direction direction)
	{
		if(direction == Direction.NORTH)
		{
			y -= 64;
		}
		else if(direction == Direction.SOUTH)
		{
			y += 64;
		}
		else if(direction == Direction.EAST)
		{
			x += 64;
		}
		else if(direction == Direction.WEST)
		{
			x -= 64;
		}
		else if(direction == Direction.NORTHEAST)
		{
			x += 64;
			y -= 64;
		}
		else if(direction == Direction.NORTHWEST)
		{
			x -= 64;
			y -= 64;
		}
		
		this.x = x;
		this.y = y;
	}
}