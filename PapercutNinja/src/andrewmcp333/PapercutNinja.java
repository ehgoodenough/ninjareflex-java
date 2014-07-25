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
	public TiledLevel level;
	public Screen screen;
	public Camera camera;
	
	public PapercutNinja()
	{
		super("Papercut the Ninja");
	}
	
	public void init(GameContainer container) throws SlickException
	{
		papercut = new Ninja(2, 5);
		level = new TiledLevel("./res/level.tmx");
		screen = new Screen(SCREEN_WIDTH, SCREEN_HEIGHT);
		camera = new Camera(screen, papercut, level);
		
		Action.level = level; //this is so bad.
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		if(papercut.action == null)
		{
			Action action = papercut.requestCurrentAction(container.getInput());
			
			if(action != null)
			{
				papercut.action = action;
			}
		}
		
		papercut.update(delta);
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
			container.setDisplayMode(SCREEN_WIDTH * 64, SCREEN_HEIGHT * 64, false);
			container.start();
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public static AppGameContainer container;
	
	public static final int SCREEN_WIDTH = 11;
	public static final int SCREEN_HEIGHT = 7;
}