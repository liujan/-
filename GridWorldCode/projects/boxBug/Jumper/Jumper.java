
import info.gridworld.grid.*;
import java.awt.Color;
import info.gridworld.actor.*;

//Jumper 会判断当前路径的前两个位置是否为空，如果为空，则会跳到该位置
//如果不为空，为花，则会吃掉话
//如果为石头，则会转向
public class Jumper extends Bug
{
	//跳跃的目的地
	private Location newLoc;
	//当前位置
	private Location oldLoc;
	public Jumper()
	{
		//默认颜色为橙色
		setColor(Color.ORANGE);
	}

	public Jumper(Color color)
	{
		//设置颜色
		setColor(color);
	}

	public void act()
	{
		//如果可以移动，就移动
		if (canMove())
		{
			move();
		}
		//否则转向
		else
		{
			turn();
		}
	}
	//移动函数
	public void move()
	{
		//移动到新位置
		moveTo(newLoc);
	}
	//@Override
	public boolean canMove()
	{
		Grid<Actor>	gr = getGrid();
		if (null == gr)
		{
			return false;
		}
		//oldLoc表示当前所在位置
		oldLoc = getLocation();
		int direction = getDirection();
		//newLoc表示跳跃两个位置之后的位置
		newLoc = oldLoc.getAdjacentLocation(direction);
		newLoc = newLoc.getAdjacentLocation(direction);

		//如果要跳跃的位置不再grid内，就返回false
		if (!gr.isValid(newLoc))
		{
			return false;
		}
		//如果newLoc所在位置为空或者为flower，就返回true.
		Actor neighbor = gr.get(newLoc);
		return (neighbor == null) || (neighbor instanceof Flower);
	}
}
