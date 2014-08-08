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
		
		this.tx = (int)(entity.x / 64);
		this.ty = (int)(entity.y / 64);
	}
	
	public void update(int delta)
	{
		done = entity.update(this, delta);
	}
	
	public int getTileX()
	{
		int tx = this.tx;

		if(direction == Direction.EAST || direction == Direction.NORTHEAST || direction == Direction.SOUTHEAST)
		{
			tx += 1;
		}
		
		if(direction == Direction.WEST || direction == Direction.NORTHWEST || direction == Direction.SOUTHWEST)
		{
			tx -= 1;
		}
		
		return tx;
	}
	
	public int getTileY()
	{
		int ty = this.ty;

		if(direction == Direction.NORTH || direction == Direction.NORTHEAST || direction == Direction.NORTHWEST)
		{
			ty -= 1;
		}
		
		if(direction == Direction.SOUTH || direction == Direction.SOUTHEAST || direction == Direction.SOUTHWEST)
		{
			ty += 1;
		}
		
		return ty;
	}
	
	public int getX()
	{
		return getTileX() * 64;
	}
	
	public int getY()
	{
		return getTileY() * 64;
	}
	
	public boolean isDone()
	{
		return done;
	}
}