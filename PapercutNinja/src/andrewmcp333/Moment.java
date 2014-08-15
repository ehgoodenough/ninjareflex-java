package andrewmcp333;

import java.util.LinkedList;

public class Moment
{
	private LinkedList<Action> actions = new LinkedList<Action>();
	
	public void add(Action action)
	{
		this.actions.add(action);
	}
	
	public void add(LinkedList<Action> actions)
	{
		this.actions.addAll(actions);
	}
	
	public void update(int delta)
	{
		for(Action action : this.actions)
		{
			action.update(delta);
		}
	}
	
	public boolean isFinished()
	{
		for(Action action : this.actions)
		{
			if(!action.isFinished())
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void finish()
	{
		for(Action action : this.actions)
		{
			action.finish();
		}
	}
}