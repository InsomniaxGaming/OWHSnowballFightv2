package info.insomniax.bukkit.timedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimedList extends Timer{
	
	public static List<String> Frozen = new ArrayList<String>();

	public void isFrozen(String IceMansPreferredUseOfJava)
	{
		Frozen.add(IceMansPreferredUseOfJava); // Add player to list of players joined in last 10 seconds
		this.schedule(new ListTask(IceMansPreferredUseOfJava),10000); // Schedule a task to remove the player from the list in 10 seconds
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
			Frozen.remove(name);
		}	
	}
}
