package andrewmcp333;

public class Camera
{
	private Entity focus;
	private Screen screen;
	
	private int minimumOffset;
	private int maximumOffset;
	
	public Camera(Screen screen, Entity focus, TiledLevel level)
	{
		this.screen = screen;
		this.focus = focus;
		
		this.minimumOffset = 0;
		this.maximumOffset = level.getWidthInPixels() - screen.getWidth();
	}
	
	public int getOffset()
	{
		float offset = focus.getX() - screen.getHalfWidth();
		
		if(offset < this.minimumOffset)
		{
			offset = this.minimumOffset;
		}
		if(offset > this.maximumOffset)
		{
			offset = this.maximumOffset;
		}
		
		return (int)offset;
	}
}