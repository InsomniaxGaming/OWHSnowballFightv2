package info.insomniax.bukkit.Frozen;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FrozenList extends Timer{
	
	public static List<String> Frozen = new ArrayList<String>();

	public void isFrozen(String IceMansPreferredUseOfJava)
	{
		Frozen.add(IceMansPreferredUseOfJava); // Add player to list of players joined in last 10 seconds
		this.schedule(new Frozen(IceMansPreferredUseOfJava),10000); // Schedule a task to remove the player from the list in 10 seconds
	}
	
	class Frozen extends TimerTask{
		
		String name;
		
		public Frozen(String name)
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
