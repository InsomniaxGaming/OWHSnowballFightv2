package info.insomniax.bukkit.core;

import info.insomniax.bukkit.owhsnowballfight.SnowballArena;
import mc.alk.arena.BattleArena;

import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPlugin extends JavaPlugin{
	
	//Wrapper class for all things bukkit!
	
	public void onEnable(){

	    BattleArena.registerCompetition(
	                      this, "OWHSnowballFightv2", "sb", SnowballArena.class);
	}
	
	public void onDisable(){}

}
