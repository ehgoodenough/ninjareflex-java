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
				}
				else
				{
					colliders[tx][ty] = true;
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
		if(action.hasNorthernMovement())
		{
			if(action.getNewTileY() < 0)
			{
				action.removeNorthernMovement();
			}
			
			if(hasCollider(action.getNewTileX(), action.getNewTileY()))
			{
				action.removeNorthernMovement();
			}
		}
		
		if(action.hasSouthernMovement())
		{
			if(action.getNewTileY() >= getHeight())
			{
				action.removeSouthernMovement();
			}
			
			if(hasCollider(action.getNewTileX(), action.getNewTileY()))
			{
				action.removeSouthernMovement();
			}
		}
		
		if(action.hasWesternMovement())
		{
			if(action.getNewTileX() < 0)
			{
				action.removeWesternMovement();
			}
			
			if(hasCollider(action.getNewTileX(), action.getNewTileY()))
			{
				action.removeWesternMovement();
			}
		}
		
		if(action.hasEasternMovement())
		{
			if(action.getNewTileX() >= getWidth())
			{
				action.removeEasternMovement();
			}
			
			if(hasCollider(action.getNewTileX(), action.getNewTileY()))
			{
				action.removeEasternMovement();
			}
		}
	}
	
	public boolean hasCollider(int tx, int ty)
	{
		return colliders[tx][ty];
	}
}