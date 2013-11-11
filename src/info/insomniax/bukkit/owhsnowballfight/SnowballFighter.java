package info.insomniax.bukkit.owhsnowballfight;

public class SnowballFighter {

    String name = "";
    
    //How many hits this player has taken
    int hitsTaken = 0;
    
    //How many hits against enemies this player has successfully made
    int hitsApplied = 0;
    	
    public SnowballFighter(String name)
    {
    	this.name = name;
    }
    	
    public String getName()
    {
    	return name;
    }
    
    public int getHitsTaken()
    {
    	return hitsTaken;
    }
    
    public int getHitsApplied()
    {
    	return hitsApplied;
    }
    
    public void setName(String name)
    {
    	this.name = name;
    }
    
    public void setHitsTaken(int hits)
    {
    	this.hitsTaken = hits;
    }
    
    public void setHitsApplied(int hits)
    {
    	this.hitsApplied = hits;
    }
    
    public void addHitTaken()
    {
    	hitsTaken++;
    }
    
    public void addHitApplied()
    {
    	hitsApplied++;
    }
}

