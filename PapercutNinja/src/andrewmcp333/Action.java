package andrewmcp333;

public class Action
{
	private Ninja ninja;
	private Direction direction;
	
	public Action(Ninja ninja, Direction direction)
	{
		this.ninja = ninja;
		this.direction = direction;
	}
	
	public void doit()
	{
		if(direction == Direction.NORTH)
		{
			ninja.ty--;
		}
		else if(direction == Direction.SOUTH)
		{
			ninja.ty++;
		}
		else if(direction == Direction.EAST)
		{
			ninja.tx++;
			ninja.ty++;
		}
		else if(direction == Direction.WEST)
		{
			ninja.tx--;
			ninja.ty++;
		}
		else if(direction == Direction.NORTHEAST)
		{
			ninja.tx++;
			ninja.ty--;
		}
		else if(direction == Direction.NORTHWEST)
		{
			ninja.tx--;
			ninja.ty--;
		}
	}
}