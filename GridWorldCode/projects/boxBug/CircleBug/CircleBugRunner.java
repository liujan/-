import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.gui.*;

public class CircleBugRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();

		world.add(new CircleBug(2));
		world.add(new CircleBug(1));
		world.show();
	}
}
