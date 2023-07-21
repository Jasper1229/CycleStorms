package ml.jasper1229.cyclestorms;

import ml.jasper1229.cyclestorms.commands.Debug;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class CycleStorms extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getCommand("strike").setExecutor(new Debug());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin instance;
}
