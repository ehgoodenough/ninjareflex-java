package andrewmcp333;

public class Action
{
	public float x, y;
	
	public static TiledLevel level;
	
	public Action(float x, float y, Direction direction)
	{
		int tx = (int)(x / 64);
		int ty = (int)(y / 64);
		
		if(direction == Direction.NORTH || direction == Direction.NORTHEAST || direction == Direction.NORTHWEST)
		{
			if(ty - 1 >= 0)
			{
		        int tid = level.getTileId(tx, ty - 1, 0);
		        if(level.getTileProperty(tid, "collider", "false").equals("false"))
		        {
		        	y -= 64;
		        }
			}
		}
		
		if(direction == Direction.SOUTH)
		{
			if(ty + 1 < level.getHeight())
			{
		        int tid = level.getTileId(tx, ty + 1, 0);
		        if(level.getTileProperty(tid, "collider", "false").equals("false"))
		        {
					y += 64;
		        }
			}
		}
		
		if(direction == Direction.EAST || direction == Direction.NORTHEAST)
		{
			if(tx + 1 < level.getWidth())
			{
		        int tid = level.getTileId(tx + 1, ty, 0);
		        if(level.getTileProperty(tid, "collider", "false").equals("false"))
		        {
					x += 64;
		        }
			}
		}
		
		if(direction == Direction.WEST || direction == Direction.NORTHWEST)
		{
			if(tx - 1 >= 0)
			{
		        int tid = level.getTileId(tx - 1, ty, 0);
		        if(level.getTileProperty(tid, "collider", "false").equals("false"))
		        {
					x -= 64;
		        }
			}
		}
		
		this.x = x;
		this.y = y;
	}
}