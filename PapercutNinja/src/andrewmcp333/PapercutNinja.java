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
	public Objedex entities;
	public TiledLevel level;
	public Screen screen;
	public Camera camera;
	
	public Moment moment;
	
	public PapercutNinja()
	{
		super("Papercut the Ninja");
	}
	
	public void init(GameContainer container) throws SlickException
	{
		entities = new Objedex();
		entities.papercut = new Ninja(2, 5);
		entities.missiles.add(new Missile(7, 3));
		
		level = new TiledLevel("./res/level.tmx");
		
		screen = new Screen(SCREEN_WIDTH, SCREEN_HEIGHT);
		camera = new Camera(screen, entities.papercut, level);
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		if(moment == null)
		{
			moment = new Moment();
			
			Action papercut_action = entities.papercut.requestAction(container.getInput());
			Action bulletbill_action = entities.missiles.get(0).requestAction();
			
			if(papercut_action != null)
			{
				level.collide(papercut_action);
				
				moment.add(papercut_action);
				moment.add(bulletbill_action);
			}
		}
		else
		{
			moment.update(delta);
			
			if(moment.isDone())
			{
				moment = null;
			}
		}
	}
	
	public void render(GameContainer container, Graphics graphics) throws SlickException
	{
		level.render(camera);
		entities.papercut.render(camera);
		entities.missiles.get(0).render(camera);
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