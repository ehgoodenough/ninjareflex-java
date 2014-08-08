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
		
		if(tx >= 0 && tx < getWidth() && ty >= 0 && ty < getHeight())
		{
			if(getTileProperty(getTileId(tx, ty, 0), "collider", "false").equals("true"))
			{
				action.revertY();
				action.revertX();
			}
		}
		else
		{
			action.revertY();
			action.revertX();
		}
	}
}