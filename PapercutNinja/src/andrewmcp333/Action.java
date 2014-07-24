package andrewmcp333;

public class Action
{
	public Action(Ninja ninja, Direction direction)
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
		}
		else if(direction == Direction.WEST)
		{
			ninja.tx--;
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