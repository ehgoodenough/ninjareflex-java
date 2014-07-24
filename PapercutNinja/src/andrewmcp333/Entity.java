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
	
	public void update(int delta, int tx, int ty)
	{
		//update the entity here!
	}
}