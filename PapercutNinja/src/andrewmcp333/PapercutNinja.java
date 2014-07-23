package andrewmcp333;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class PapercutNinja extends BasicGame
{
	
	public PapercutNinja()
	{
		super("Papercut the Ninja");
	}
	
	public void init(GameContainer container) throws SlickException
	{
		
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		
	}
	
	public void render(GameContainer container, Graphics graphics) throws SlickException
	{
		
	}

	public static void main(String[] args)
	{
		try
		{
			container = new AppGameContainer(new PapercutNinja());
			container.setDisplayMode(11*64, 7*64, false);
			container.start();
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public static AppGameContainer container;
}