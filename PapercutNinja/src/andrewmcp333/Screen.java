package andrewmcp333;

public class Screen
{
	private int width, height;
	
	public Screen(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public int getWidth()
	{
		return this.width * 64;
	}
	
	public int getHeight()
	{
		return this.height * 64;
	}
	
	public int getHalfWidth()
	{
		return (this.width / 2) * 64;
	}
	
	public int getHalfHeight()
	{
		return (this.height / 2) * 64;
	}
}