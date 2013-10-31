package info.insomniax.bukkit.owhsnowballfight;

import info.insomniax.bukkit.core.BukkitPlugin;

import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import mc.alk.arena.objects.arenas.Arena;
import mc.alk.arena.objects.events.ArenaEventHandler;

public class SnowballArena extends Arena{
	
	BukkitPlugin myPlugin;
	
	public SnowballArena(BukkitPlugin instance)
	{
		myPlugin = instance;
	}
	
	int damage = 20;

    @ArenaEventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
      if (event.isCancelled())
        return;
      if (event.getDamager().getType() !=  EntityType.SNOWBALL)
        return;
      event.setDamage(damage);
    }

}
