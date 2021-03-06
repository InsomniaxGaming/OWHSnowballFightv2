package info.insomniax.bukkit.core;

import java.util.Random;

import info.insomniax.bukkit.owhsnowballfight.SnowballArena;
import mc.alk.arena.BattleArena;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPlugin extends JavaPlugin{
	
	Random rand = new Random();
	FileConfiguration config = null;
	
	boolean useListsFreeze = false;
	boolean useListsRock = false;
	
	//Wrapper class for all things bukkit!
	
	public void onEnable()
	{
		
		this.saveDefaultConfig();

	    BattleArena.registerCompetition(
	                      this, "OWHSnowballFightv2", "sb", SnowballArena.class);
	    
	    config = this.getConfig();

		// Return true for using timed lists, false for probability
		useListsFreeze = config.getBoolean("useListsForFreeze",false);
		useListsRock = config.getBoolean("useListsForRock", false);
	}
	
	public void onDisable()
	{
		this.saveConfig();
	}
	
	public boolean wasProbable(int numerator, int denominator)
	{
		return rand.nextInt(denominator) < numerator;
	}
	
	public void consoleInfo(String message)
	{
		this.getLogger().info(message);
	}
	
	public boolean useListsForFreeze()
	{
		return useListsFreeze;
	}
	
	public boolean useListsForRock()
	{
		return useListsRock;
	}

}
