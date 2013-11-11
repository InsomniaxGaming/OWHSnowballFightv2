package info.insomniax.bukkit.timedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class TimedList extends Timer{
	
	private List<Object> list = new ArrayList<Object>();

	// This method will add a player to the List for time amount of milliseconds. Any number below 0 is a permanent add to the list
	public void add(Object obj, long time)
	{
		list.add(obj); // Add player to list
		
		if(time >= 0)
			this.schedule(new ListTask(obj),time); // Schedule a task to remove the player from the list after the length of variable "time"
	}
	
	public void remove(Object obj)
	{
		list.remove(obj);
	}
	
	public boolean has(Object obj)
	{
		if(list.contains(obj)){
			return true;
		}
		return false; // Fix this to return correctly :) We will use "inList" instead of "isFrozen"
	}
	
	class ListTask extends TimerTask{
		
		Object listItem;
		
		public ListTask(Object obj)
		{
			listItem = obj;
		}

		@Override
		public void run()
		{
			remove(listItem);
		}	
	}
}
