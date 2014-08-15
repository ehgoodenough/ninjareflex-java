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
				int tid = this.getTileId(tx, ty, 0);
				
				boolean collider = this.getTileProperty(tid, "collider", "false").equals("true");
				this.tiles[tx][ty] = new Tile(collider);
			}
		}
	}
	
	public void render(Camera camera)
	{
		this.render(0 - camera.getOffset(), 0);
	}
	
	public int getWidthInPixels()
	{
		return this.getWidth() * this.getTileWidth();
	}
	
	public int getHeightInPixels()
	{
		return this.getHeight() * this.getTileHeight();
	}
	
	public int getMinTileX()
	{
		return 0;
	}
	
	public int getMaxTileX()
	{
		return this.getWidth();
	}
	
	public int getMinTileY()
	{
		return 0;
	}
	
	public int getMaxTileY()
	{
		return this.getHeight();
	}
	
	public void collide(Action action)
	{
		if(action.getNewTileY() < this.getMinTileY())
		{
			action.removeNorthernMovement();
		}
		
		if(action.getNewTileY() >= this.getMaxTileY())
		{
			action.removeSouthernMovement();
		}
		
		if(action.getNewTileX() >= this.getMaxTileX())
		{
			action.removeEasternMovement();
		}
		
		if(action.getNewTileX() < this.getMinTileX())
		{
			action.removeWesternMovement();
		}
		
		if(action.hasNorthernMovement())
		{
			int ntx = action.getNewTileX();
			int nty = action.getNewTileY();
			
			if(this.getTile(ntx, nty).isCollider())
			{
				action.removeNorthernMovement();
			}
		}
		
		if(action.hasSouthernMovement())
		{
			int ntx = action.getNewTileX();
			int nty = action.getNewTileY();
			
			if(this.getTile(ntx, nty).isCollider())
			{
				action.removeSouthernMovement();
			}
		}
		
		if(action.hasWesternMovement())
		{
			int ntx = action.getNewTileX();
			int nty = action.getNewTileY();
			
			if(this.getTile(ntx, nty).isCollider())
			{
				action.removeWesternMovement();
			}
		}
		
		if(action.hasEasternMovement())
		{
			int ntx = action.getNewTileX();
			int nty = action.getNewTileY();
			
			if(this.getTile(ntx, nty).isCollider())
			{
				action.removeEasternMovement();
			}
		}
	}
	
	public Tile getTile(int tx, int ty)
	{
		if(tx < 0 || tx >= this.getWidth()
		|| ty < 0 || ty >= this.getHeight())
		{
			return null;
		}
		
		return this.tiles[tx][ty];
	}
}