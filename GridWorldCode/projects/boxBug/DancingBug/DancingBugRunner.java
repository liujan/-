import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

public class DancingBugRunner
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{2,3,4};
		DancingBug db = new DancingBug(arr);
		ActorWorld world = new ActorWorld();
        world.add(db);
		world.show();
	}
}
