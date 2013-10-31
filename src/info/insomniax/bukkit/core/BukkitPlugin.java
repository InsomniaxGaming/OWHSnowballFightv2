package info.insomniax.bukkit.core;

import java.util.Random;

import info.insomniax.bukkit.owhsnowballfight.SnowballArena;
import mc.alk.arena.BattleArena;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPlugin extends JavaPlugin{
	
	Random rand = new Random();
	FileConfiguration config = null;
	
	boolean useLists = false;
	
	//Wrapper class for all things bukkit!
	
	public void onEnable(){

	    BattleArena.registerCompetition(
	                      this, "OWHSnowballFightv2", "sb", SnowballArena.class);
	    
	    config = this.getConfig();

		// Return true for using timed lists, false for probability
		useLists = config.getBoolean("useLists",false);
	}
	
	public void onDisable(){}
	
	public boolean wasProbable(int numerator, int denominator)
	{
		return rand.nextInt(denominator) < numerator;
	}
	
	public boolean useLists()
	{
		return useLists;
	}

}
