package ml.jasper1229.cyclestorms.commands;

import ml.jasper1229.cyclestorms.utils.Lightning;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Debug implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = Bukkit.getPlayer(args[0]);
        if (player == null) {return true;}

        Lightning lightning = new Lightning(20, player.getLocation());
        lightning.strike();
        return true;
    }
}
