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
	
	public Direction getDirection()
	{
		return direction;
	}
	
	public boolean hasNorthernMovement()
	{
		return direction == Direction.NORTH || direction == Direction.NORTHEAST || direction == Direction.NORTHWEST;
	}
	
	public boolean hasSouthernMovement()
	{
		return direction == Direction.SOUTH || direction == Direction.SOUTHEAST || direction == Direction.SOUTHWEST;
	}
	
	public boolean hasEasternMovement()
	{
		return direction == Direction.EAST || direction == Direction.NORTHEAST || direction == Direction.SOUTHEAST;
	}
	
	public boolean hasWesternMovement()
	{
		return direction == Direction.WEST || direction == Direction.NORTHWEST || direction == Direction.SOUTHWEST;
	}
	
	public void removeNorthernMovement()
	{
		if(direction == Direction.NORTH)
		{
			direction = Direction.NONE;
		}
		else if(direction == Direction.NORTHEAST)
		{
			direction = Direction.EAST;
		}
		else if(direction == Direction.NORTHWEST)
		{
			direction = Direction.WEST;
		}
	}
	
	public void removeSouthernMovement()
	{
		if(direction == Direction.SOUTH)
		{
			direction = Direction.NONE;
		}
		else if(direction == Direction.SOUTHEAST)
		{
			direction = Direction.EAST;
		}
		else if(direction == Direction.SOUTHWEST)
		{
			direction = Direction.WEST;
		}
	}
	
	public void removeEasternMovement()
	{
		if(direction == Direction.EAST)
		{
			direction = Direction.NONE;
		}
		else if(direction == Direction.NORTHEAST)
		{
			direction = Direction.NORTH;
		}
		else if(direction == Direction.SOUTHEAST)
		{
			direction = Direction.SOUTH;
		}
	}
	
	public void removeWesternMovement()
	{
		if(direction == Direction.WEST)
		{
			direction = Direction.NONE;
		}
		else if(direction == Direction.NORTHWEST)
		{
			direction = Direction.NORTH;
		}
		else if(direction == Direction.SOUTHWEST)
		{
			direction = Direction.SOUTH;
		}
	}
	
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

		if(hasEasternMovement())
		{
			tx += 1;
		}
		else if(hasWesternMovement())
		{
			tx -= 1;
		}
		
		return tx;
	}
	
	public int getNewTileY()
	{
		int ty = this.ty;

		if(hasNorthernMovement())
		{
			ty -= 1;
		}
		else if(hasSouthernMovement())
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