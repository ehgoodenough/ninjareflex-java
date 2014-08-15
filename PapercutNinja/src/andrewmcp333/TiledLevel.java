package andrewmcp333;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TiledLevel extends TiledMap
{
	Tile[][] tiles;
	
	public TiledLevel(String path) throws SlickException
	{
		super(path);
		
		this.tiles = new Tile[this.getWidth()][this.getHeight()];
		
		for(int ty = 0; ty < this.getHeight(); ty++)
		{
			for(int tx = 0; tx < this.getWidth(); tx++)
			{
				int tid = getTileId(tx, ty, 0);
				
				boolean collider = this.getTileProperty(tid, "collider", "false").equals("true");
				this.tiles[tx][ty] = new Tile(collider);
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
		if(action.getNewTileY() < 0)
		{
			action.removeNorthernMovement();
		}
		
		if(action.getNewTileY() >= getHeight())
		{
			action.removeSouthernMovement();
		}
		
		if(action.getNewTileX() >= getWidth())
		{
			action.removeEasternMovement();
		}
		
		if(action.getNewTileX() < 0)
		{
			action.removeWesternMovement();
		}
		
		if(action.hasNorthernMovement())
		{
			if(this.getTile(action.getNewTileX(), action.getNewTileY()).isCollider())
			{
				action.removeNorthernMovement();
			}
		}
		
		if(action.hasSouthernMovement())
		{
			if(this.getTile(action.getNewTileX(), action.getNewTileY()).isCollider())
			{
				action.removeSouthernMovement();
			}
		}
		
		if(action.hasWesternMovement())
		{
			if(this.getTile(action.getNewTileX(), action.getNewTileY()).isCollider())
			{
				action.removeWesternMovement();
			}
		}
		
		if(action.hasEasternMovement())
		{
			if(this.getTile(action.getNewTileX(), action.getNewTileY()).isCollider())
			{
				action.removeEasternMovement();
			}
		}
	}
	
	public Tile getTile(int tx, int ty)
	{
		if(tx < 0 || tx >= getWidth() || ty < 0 || ty >= getHeight())
		{
			return null;
		}
		
		return this.tiles[tx][ty];
	}
}