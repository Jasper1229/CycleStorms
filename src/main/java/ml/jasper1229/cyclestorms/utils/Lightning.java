package ml.jasper1229.cyclestorms.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;

public class Lightning {
    private final int delay;
    private final Location location;

    public Lightning(int delay, Location location){
        this.delay = delay;
        this.location = location;
    }

    public void strike() {
        if (location.getWorld() == null) {Bukkit.getLogger().warning("World null? How."); return;}
        location.getWorld().strikeLightningEffect(location);
    }
}
