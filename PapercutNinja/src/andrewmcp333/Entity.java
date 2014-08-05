package andrewmcp333;

public abstract class Entity
{
	public float x, y;
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public boolean update(Action action, int delta)
	{
		return false;
	}
}