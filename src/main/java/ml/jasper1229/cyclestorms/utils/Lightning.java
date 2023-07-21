package ml.jasper1229.cyclestorms.utils;

import ml.jasper1229.cyclestorms.CycleStorms;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import java.util.Random;
import org.bukkit.scheduler.BukkitRunnable;

public class Lightning {
    private final long delay;
    private final Location location;

    public Lightning(long delay, Location location) {
        this.delay = delay;
        this.location = location;
    }

    public void strike() {
        if (location.getWorld() == null) {Bukkit.getLogger().warning("World null? How."); return;}
        Bukkit.getLogger().info("Sparks should have spawned");
        new BukkitRunnable() {
            int ticks = 0;
            Random rand = new Random();
            @Override
            public void run() {
                if(ticks>=30){
                    cancel();
                }
                if(rand.nextInt(100) >= 60) { // plays sound 40% of the time
                    location.getWorld().playSound(location, Sound.ENTITY_ELDER_GUARDIAN_AMBIENT_LAND, 5, 1.5F);
                    location.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, location, 3, rand.nextInt(8)-4,1,rand.nextInt(8)-4);
                    location.getWorld().spawnParticle(Particle.REVERSE_PORTAL, location, 3, rand.nextInt(8)-4,1,rand.nextInt(8)-4);
                    location.getWorld().spawnParticle(Particle.CRIT_MAGIC, location, 3, rand.nextInt(8)-4,1,rand.nextInt(8)-4);
                    location.getWorld().spawnParticle(Particle.CRIMSON_SPORE, location, 6, rand.nextInt(8)-4,1,rand.nextInt(8)-4);

                }
                ticks++;
            }
        }.runTaskTimer(CycleStorms.instance, 0,1);
        location.getWorld().playSound(location, Sound.BLOCK_BEACON_ACTIVATE, 100, 0.95F);
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getLogger().info("Lightning should have struck");
                location.getWorld().strikeLightningEffect(location);
                location.getWorld().playSound(location, Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 100, 2);
            }
        }.runTaskLater(CycleStorms.instance, 30);
    }
}
