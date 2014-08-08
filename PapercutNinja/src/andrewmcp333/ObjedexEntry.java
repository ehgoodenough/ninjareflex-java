package andrewmcp333;

import java.util.LinkedList;

public class ObjedexEntry
{
	public LinkedList<Entity> entities = new LinkedList<Entity>();
	
	public LinkedList<Action> requestActions()
	{
		LinkedList<Action> actions = new LinkedList<Action>();
		for(int index = 0; index < entities.size(); index++)
			actions.add(entities.get(index).requestAction());
		return actions;
	}
	
	public void add(Entity entity)
	{
		entities.add(entity);
	}
	
	public void render(Camera camera)
	{
		for(Entity entity : entities)
			entity.render(camera);
	}
}