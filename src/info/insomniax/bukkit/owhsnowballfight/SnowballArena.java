package info.insomniax.bukkit.owhsnowballfight;

import java.util.ArrayList;
import java.util.List;

import info.insomniax.bukkit.core.BukkitPlugin;
import info.insomniax.bukkit.timedlist.TimedList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import mc.alk.arena.objects.arenas.Arena;
import mc.alk.arena.objects.events.ArenaEventHandler;


public class SnowballArena extends Arena{
	
	BukkitPlugin myPlugin;
	TimedList frozen = new TimedList();
	List<SnowballFighter> fighters = new ArrayList<SnowballFighter>();
	
	public SnowballArena(BukkitPlugin instance)
	{
		myPlugin = instance;
	}
	
	int rockDamage = 20;

    @ArenaEventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
      if (event.isCancelled()) // If event is cancelled, stop here
        return;
      if (event.getDamager().getType() !=  EntityType.SNOWBALL) // If the damage was anything other than snowball, stop here
        return;
      if((event.getEntityType() != EntityType.PLAYER) || (event.getDamager().getType() != EntityType.PLAYER)) // If this snowball wasn't thrown by and/or didn't hit a player, stop here
    	return;
      
      if(myPlugin.useListsForRock())
      {
    	  
      }
      else if(myPlugin.wasProbable(1,10))
      {
    	  //At this point, we can safely type cast these entities since we already checked to make sure they're players.
    	  Entity player = event.getEntity();
    	  Entity damager = event.getDamager();
    	  
    	  ((Player)player).sendMessage("You were hit by a " + ChatColor.RED + "snow covered rock " + ChatColor.WHITE + "by " + ChatColor.GOLD + ((Player)damager).getName());
    	  ((Player)damager).sendMessage("You struck " + ChatColor.GOLD + ((Player)player).getName() + ChatColor.WHITE + " with a " + ChatColor.RED + " snow covered rock");  

          event.setDamage(rockDamage); // Increase snowball damage!
      }
      
      if(myPlugin.useListsForFreeze())
      {
    	  //Insom's code here
      } else
      {
    	  if(myPlugin.wasProbable(1,32)){
    		  Entity player = event.getEntity();
    		  String playername = ((Player) player).getName();
    		  
    		  if(!frozen.has(playername))
    		  {
    			  frozen.add(playername, 10000);
    		  }
    	  }
      }
    }
    
    @ArenaEventHandler
    // Method name does not matter. What matters is the @ArenaEventHandler annotation and the passed in PlayerMoveEvent
    public void onMove(PlayerMoveEvent event)
    {
    	if(frozen.has(event.getPlayer().getName())){
    		event.setCancelled(true);
    	}
    	//Shado did worky worky
    }

}
