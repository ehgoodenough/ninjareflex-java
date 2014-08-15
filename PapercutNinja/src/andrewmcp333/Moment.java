package andrewmcp333;

import java.util.LinkedList;

public class Moment extends LinkedList<Action>
{
	public boolean isDone()
	{
		for(Action action : this)
			if(!action.isDone())
				return false;
		
		return true;
	}
	
	public void update(int delta)
	{
		for(Action action : this)
			action.update(delta);
	}
}