package andrewmcp333;

import java.util.LinkedList;

public class ObjedexEntry extends LinkedList<Entity>
{
	public LinkedList<Action> requestActions()
	{
		LinkedList<Action> actions = new LinkedList<Action>();
		for(int index = 0; index < this.size(); index++)
			actions.add(this.get(index).requestAction());
		return actions;
	}
	
	public void render(Camera camera)
	{
		for(Entity entity : this)
			entity.render(camera);
	}
}