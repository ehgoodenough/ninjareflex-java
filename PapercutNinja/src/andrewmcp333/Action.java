package andrewmcp333;

public class Action
{
	private Entity entity;
	private Direction direction;
	
	private int tx = 0, ty = 0;
	private boolean done = false;
	
	public Action(Entity entity, Direction direction)
	{
		this.entity = entity;
		this.direction = direction;
		
		tx = getOriginalTileX();
		ty = getOriginalTileY();
		
		if(direction == Direction.NORTH || direction == Direction.NORTHEAST || direction == Direction.NORTHWEST)
		{
			ty -= 1;
		}
		
		if(direction == Direction.SOUTH)
		{
			ty += 1;
		}
		
		if(direction == Direction.EAST || direction == Direction.NORTHEAST)
		{
			tx += 1;
		}
		
		if(direction == Direction.WEST || direction == Direction.NORTHWEST)
		{
			tx -= 1;
		}
	}
	
	public void update(int delta)
	{
		done = entity.update(this, delta);
	}
	
	public int getX()
	{
		return tx * 64;
	}
	
	public int getY()
	{
		return ty * 64;
	}
	
	public int getTileX()
	{
		return tx;
	}
	
	public int getTileY()
	{
		return ty;
	}
	
	public boolean isDone()
	{
		return done;
	}
	
	public int getOriginalTileX()
	{
		return (int)(entity.x / 64);
	}
	
	public int getOriginalTileY()
	{
		return (int)(entity.y / 64);
	}
	
	public void revertX()
	{
		tx = getOriginalTileX();
	}
	
	public void revertY()
	{
		ty = getOriginalTileY();
	}
}