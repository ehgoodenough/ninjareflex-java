package andrewmcp333;

public class NinjaAction extends Action
{
	public NinjaAction(Ninja ninja, Direction direction)
	{
		super(ninja, direction);
	}
	
	public void update(int delta)
	{
		super.update(delta);
		
		//reset ninja jump if
		//has level collision?
	}
}