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

	public boolean movingNorth() {return direction == Direction.NORTH || direction == Direction.NORTHEAST || direction == Direction.NORTHWEST;}
	public boolean movingSouth() {return direction == Direction.SOUTH || direction == Direction.SOUTHEAST || direction == Direction.SOUTHWEST;}
	public boolean movingEast() {return direction == Direction.EAST || direction == Direction.NORTHEAST || direction == Direction.SOUTHEAST;}
	public boolean movingWest() {return direction == Direction.WEST || direction == Direction.NORTHWEST || direction == Direction.SOUTHWEST;}
	
	public int getTileX()
	{
		return tx;
	}
	
	public int getTileY()
	{
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
	
	public int getNewTileX()
	{
		int tx = this.tx;

		if(movingEast())
		{
			tx += 1;
		}
		else if(movingWest())
		{
			tx -= 1;
		}
		
		return tx;
	}
	
	public int getNewTileY()
	{
		int ty = this.ty;

		if(movingNorth())
		{
			ty -= 1;
		}
		else if(movingSouth())
		{
			ty += 1;
		}
		
		return ty;
	}
	
	public int getNewX()
	{
		return getNewTileX() * 64;
	}
	
	public int getNewY()
	{
		return getNewTileY() * 64;
	}
	
	public void update(int delta)
	{
		done = entity.update(this, delta);
	}
	
	public boolean isDone()
	{
		return done;
	}
}