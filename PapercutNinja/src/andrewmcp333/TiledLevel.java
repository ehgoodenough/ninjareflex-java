package andrewmcp333;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TiledLevel extends TiledMap
{
	boolean[][] colliders;
	
	public TiledLevel(String path) throws SlickException
	{
		super(path);
		
		colliders = new boolean[getWidth()][getHeight()];
		
		for(int ty = 0; ty < getHeight(); ty++)
		{
			for(int tx = 0; tx < getWidth(); tx++)
			{
				int tid = getTileId(tx, ty, 0);
				
				if(getTileProperty(tid, "collider", "false").equals("false"))
				{
					colliders[tx][ty] = false;
					System.out.print(0);
				}
				else
				{
					colliders[tx][ty] = true;
					System.out.print(1);
				}
			}
		}
	}
	
	public void render(Camera camera)
	{
		render(0 - camera.getOffset(), 0);
	}
	
	public int getWidthInPixels()
	{
		return getWidth() * getTileWidth();
	}
	
	public int getHeightInPixels()
	{
		return getHeight() * getTileHeight();
	}
	
	public void collide(Action action)
	{
		int tx = action.getTileX();
		int ty = action.getTileY();
		
		if(action.hasNorthernMovement())
		{
			if(ty - 1 < 0)
			{
				action.removeNorthernMovement();
			}
			
			if(hasCollider(tx, ty - 1))
			{
				action.removeNorthernMovement();
			}
		}
		
		if(action.hasWesternMovement())
		{
			if(tx - 1 < 0)
			{
				action.removeWesternMovement();
			}
			
			if(hasCollider(tx - 1, ty))
			{
				action.removeWesternMovement();
			}
		}
		
		if(action.hasEasternMovement())
		{
			if(tx + 1 >= getWidth())
			{
				action.removeEasternMovement();
			}
			
			if(hasCollider(tx + 1, ty))
			{
				action.removeEasternMovement();
			}
		}
		
		if(action.hasSouthernMovement())
		{
			if(ty + 1 >= getHeight())
			{
				action.removeSouthernMovement();
			}
			
			if(hasCollider(tx, ty + 1))
			{
				action.removeSouthernMovement();
			}
		}
	}
	
	public boolean hasCollider(int tx, int ty)
	{
		return colliders[tx][ty];
	}
}