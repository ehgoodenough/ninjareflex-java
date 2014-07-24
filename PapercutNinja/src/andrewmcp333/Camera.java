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
		
		minimumOffset = 0;
		maximumOffset = level.getWidthInPixels() - screen.getWidth();
	}
	
	public int getOffset()
	{
		float offset = focus.getX() - screen.getHalfWidth();
		
		if(offset < minimumOffset)
		{
			offset = minimumOffset;
		}
		if(offset > maximumOffset)
		{
			offset = maximumOffset;
		}
		
		return (int)offset;
	}
}