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
	public TiledLevel level;
	public Ninja papercut;
	
	public Screen screen;
	public Camera camera;
	
	public PapercutNinja()
	{
		super("Papercut the Ninja");
	}
	
	public void init(GameContainer container) throws SlickException
	{
		level = new TiledLevel("./res/level.tmx");
		papercut = new Ninja(2, 5);
		
		screen = new Screen(11, 7);
		camera = new Camera(screen, papercut, level);
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		papercut.update(container.getInput(), delta);
	}
	
	public void render(GameContainer container, Graphics graphics) throws SlickException
	{
		level.render(camera);
		papercut.render(camera);
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