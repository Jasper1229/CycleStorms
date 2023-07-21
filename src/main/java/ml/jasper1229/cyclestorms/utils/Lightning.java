package ml.jasper1229.cyclestorms.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Server;

public class Lightning {
    private final long delay;
    private final Location location;

    public Lightning(long delay, Location location){
        this.delay = delay;
        this.location = location;
    }

    public void strike() {
        if (location.getWorld() == null) {Bukkit.getLogger().warning("World null? How."); return;}
        location.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, location, 20);
        Bukkit.getLogger().info("Sparks should have spawned");
        new DelayedTask(() -> {
            Bukkit.getLogger().info("Lightning should have struck");
            location.getWorld().strikeLightningEffect(location);
        }, 20);
    }
}
