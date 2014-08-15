package andrewmcp333;

public class Tile
{
	private boolean collider = false;
	
	public Tile(boolean collider)
	{
		this.collider = collider;
	}
	
	public boolean isCollider()
	{
		return this.collider;
	}
}