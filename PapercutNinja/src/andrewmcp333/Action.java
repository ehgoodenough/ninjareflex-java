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
		
		this.tx = entity.getTileX();
		this.ty = entity.getTileY();
	}
	
	public Direction getDirection()
	{
		return this.direction;
	}
	
	public boolean hasNorthernMovement()
	{
		return this.direction == Direction.NORTH || this.direction == Direction.NORTHEAST || this.direction == Direction.NORTHWEST;
	}
	
	public boolean hasSouthernMovement()
	{
		return this.direction == Direction.SOUTH || this.direction == Direction.SOUTHEAST || this.direction == Direction.SOUTHWEST;
	}
	
	public boolean hasEasternMovement()
	{
		return this.direction == Direction.EAST || this.direction == Direction.NORTHEAST || this.direction == Direction.SOUTHEAST;
	}
	
	public boolean hasWesternMovement()
	{
		return this.direction == Direction.WEST || this.direction == Direction.NORTHWEST || this.direction == Direction.SOUTHWEST;
	}
	
	public void removeNorthernMovement()
	{
		if(this.direction == Direction.NORTH)
		{
			this.direction = Direction.NONE;
		}
		else if(this.direction == Direction.NORTHEAST)
		{
			this.direction = Direction.EAST;
		}
		else if(this.direction == Direction.NORTHWEST)
		{
			this.direction = Direction.WEST;
		}
	}
	
	public void removeSouthernMovement()
	{
		if(this.direction == Direction.SOUTH)
		{
			this.direction = Direction.NONE;
		}
		else if(this.direction == Direction.SOUTHEAST)
		{
			this.direction = Direction.EAST;
		}
		else if(this.direction == Direction.SOUTHWEST)
		{
			this.direction = Direction.WEST;
		}
	}
	
	public void removeEasternMovement()
	{
		if(this.direction == Direction.EAST)
		{
			this.direction = Direction.NONE;
		}
		else if(this.direction == Direction.NORTHEAST)
		{
			this.direction = Direction.NORTH;
		}
		else if(this.direction == Direction.SOUTHEAST)
		{
			this.direction = Direction.SOUTH;
		}
	}
	
	public void removeWesternMovement()
	{
		if(this.direction == Direction.WEST)
		{
			this.direction = Direction.NONE;
		}
		else if(this.direction == Direction.NORTHWEST)
		{
			this.direction = Direction.NORTH;
		}
		else if(this.direction == Direction.SOUTHWEST)
		{
			this.direction = Direction.SOUTH;
		}
	}
	
	public int getTileX()
	{
		return this.tx;
	}
	
	public int getTileY()
	{
		return this.ty;
	}
	
	public int getX()
	{
		return this.tx * 64;
	}
	
	public int getY()
	{
		return this.tx * 64;
	}
	
	public int getNewTileX()
	{
		int ntx = this.tx;

		if(this.hasEasternMovement())
		{
			ntx += 1;
		}
		else if(this.hasWesternMovement())
		{
			ntx -= 1;
		}
		
		return ntx;
	}
	
	public int getNewTileY()
	{
		int nty = this.ty;

		if(this.hasNorthernMovement())
		{
			nty -= 1;
		}
		else if(this.hasSouthernMovement())
		{
			nty += 1;
		}
		
		return nty;
	}
	
	public int getNewX()
	{
		return this.getNewTileX() * 64;
	}
	
	public int getNewY()
	{
		return this.getNewTileY() * 64;
	}
	
	public void update(int delta)
	{
		this.entity.update(this, delta);
		this.done = this.entity.isDone(this);
	}
	
	public boolean isDone()
	{
		return this.done;
	}
}