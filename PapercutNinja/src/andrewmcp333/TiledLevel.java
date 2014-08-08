package andrewmcp333;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TiledLevel extends TiledMap
{
	public TiledLevel(String path) throws SlickException
	{
		super(path);
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
		
		if(action.hasNorthernMovement() && ty - 1 < 0)
		{
			action.removeNorthernMovement();
		}
		
		if(action.hasWesternMovement() && tx - 1< 0)
		{
			action.removeWesternMovement();
		}
		
		if(action.hasEasternMovement() && tx + 1 >= getWidth())
		{
			action.removeEasternMovement();
		}
		
		if(action.hasSouthernMovement())
		{
			if(ty + 1 >= getHeight())
			{
				action.removeSouthernMovement();
			}
			if(getTileProperty(getTileId(tx, ty + 1, 0), "collider", "false").equals("true"))
			{
				action.removeSouthernMovement();
			}
		}
	}
}