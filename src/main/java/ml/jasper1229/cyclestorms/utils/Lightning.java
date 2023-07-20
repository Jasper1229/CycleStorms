package ml.jasper1229.cyclestorms.utils;

import org.bukkit.Location;
public class Lightning {
    private final int delay;
    private final Location location;

    public Lightning(int delay, Location location){
        this.delay = delay;
        this.location = location;
    }

    public void strike() {
        location.getWorld().strikeLightningEffect(location);
    }
}
