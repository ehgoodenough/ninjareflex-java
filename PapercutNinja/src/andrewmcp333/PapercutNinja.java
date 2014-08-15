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
	public Screen screen;
	public Camera camera;
	public Moment moment;
	
	public PapercutNinja()
	{
		super("Papercut the Ninja");
	}
	
	public void init(GameContainer container) throws SlickException
	{
		Objedex.papercut = new Ninja(2, 2);
		Objedex.missiles.add(new Missile(7, 3));
		
		Objedex.level = new TiledLevel("./res/level.tmx");
		
		screen = new Screen(SCREEN_WIDTH, SCREEN_HEIGHT);
		camera = new Camera(screen, Objedex.papercut, Objedex.level);
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		if(moment == null)
		{
			moment = new Moment();
			
			Action action = Objedex.papercut.requestAction(container.getInput());
			Objedex.level.collide(action);
			
			if(action.getDirection() != Direction.NONE)
			{
				moment.add(action);
				moment.add(Objedex.missiles.requestActions());
			}
		}
		else
		{
			moment.update(delta);
			
			if(moment.isFinished())
			{
				moment.finish();
				moment = null;
			}
		}
	}
	
	public void render(GameContainer container, Graphics graphics) throws SlickException
	{
		Objedex.level.render(camera);
		Objedex.papercut.render(camera);
		Objedex.missiles.render(camera);
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