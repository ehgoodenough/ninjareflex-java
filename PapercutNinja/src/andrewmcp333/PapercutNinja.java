package andrewmcp333;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class PapercutNinja extends BasicGame
{
	public Ninja papercut;
	public TiledMap map;
	
	public PapercutNinja()
	{
		super("Papercut the Ninja");
	}
	
	public void init(GameContainer container) throws SlickException
	{
		papercut = new Ninja(5, 5);
		map = new TiledMap("./res/map.tmx");
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		Input input = container.getInput();
		
		papercut.update(input, delta);
	}
	
	public void render(GameContainer container, Graphics graphics) throws SlickException
	{
		map.render(0, 0);
		papercut.render();
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