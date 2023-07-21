package ml.jasper1229.cyclestorms;

import ml.jasper1229.cyclestorms.commands.Debug;
import ml.jasper1229.cyclestorms.utils.DelayedTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class CycleStorms extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("strike").setExecutor(new Debug());
        new DelayedTask(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
