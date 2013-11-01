package info.insomniax.bukkit.timedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimedList extends Timer{
	
	private List<String> list = new ArrayList<String>();

	public void add(String player, long time)
	{
		list.add(player); // Add player to list of players joined in last 10 seconds
		this.schedule(new ListTask(player),time); // Schedule a task to remove the player from the list in 10 seconds
	}
	
	public boolean inList(String player)
	{
		return false; // Fix this to return correctly :) We will use "inList" instead of "isFrozen"
	}
	
	class ListTask extends TimerTask{
		
		String name;
		
		public ListTask(String name)
		{
			this.name = name;
		}

		@Override
		public void run()
		{
			list.remove(name);
		}	
	}
}
