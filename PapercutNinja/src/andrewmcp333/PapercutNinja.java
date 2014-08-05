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
	public Missile bulletbill;
	public TiledLevel level;
	public Screen screen;
	public Camera camera;

	public Action papercut_action;
	public Action bulletbill_action;
	
	public PapercutNinja()
	{
		super("Papercut the Ninja");
	}
	
	public void init(GameContainer container) throws SlickException
	{
		papercut = new Ninja(2, 5);
		bulletbill = new Missile(7, 3);
		level = new TiledLevel("./res/level.tmx");
		screen = new Screen(SCREEN_WIDTH, SCREEN_HEIGHT);
		camera = new Camera(screen, papercut, level);
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		if(papercut_action == null)
		{
			papercut_action = papercut.requestAction(container.getInput());
			
			if(papercut_action != null)
			{
				level.collide(papercut_action);
			}
			
			bulletbill_action = bulletbill.requestAction();
		}
		else
		{
			papercut_action.update(delta);
			bulletbill_action.update(delta);
			
			if(papercut_action.isDone())
			{
				papercut_action = null;
			}
		}
	}
	
	public void render(GameContainer container, Graphics graphics) throws SlickException
	{
		level.render(camera);
		papercut.render(camera);
		bulletbill.render(camera);
	}
	
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer container = new AppGameContainer(new PapercutNinja());
			container.setDisplayMode(SCREEN_WIDTH * 64, SCREEN_HEIGHT * 64, false);
			container.start();
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public static final int SCREEN_WIDTH = 11;
	public static final int SCREEN_HEIGHT = 7;
}