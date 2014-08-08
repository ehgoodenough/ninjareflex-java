package andrewmcp333;

import java.util.LinkedList;

public class Moment
{
	private LinkedList<Action> actions = new LinkedList<Action>();

	public void add(Action action)
	{
		actions.add(action);
	}
	public void add(LinkedList<Action> actions)
	{
		//actions.add(actions);
	}
	
	public boolean isDone()
	{
		for(Action action : actions)
		{
			if(!action.isDone())
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void update(int delta)
	{
		for(Action action : actions)
		{
			action.update(delta);
		}
	}
}