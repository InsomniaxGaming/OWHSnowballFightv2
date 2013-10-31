package info.insomniax.bukkit.core;

import java.util.Random;

import info.insomniax.bukkit.owhsnowballfight.SnowballArena;
import mc.alk.arena.BattleArena;

import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPlugin extends JavaPlugin{
	
	Random rand = new Random();
	
	//Wrapper class for all things bukkit!
	
	public void onEnable(){

	    BattleArena.registerCompetition(
	                      this, "OWHSnowballFightv2", "sb", SnowballArena.class);
	}
	
	public void onDisable(){}
	
	public boolean wasProbable(int numerator, int denominator)
	{
		return rand.nextInt(denominator) <= numerator;
	}

}
