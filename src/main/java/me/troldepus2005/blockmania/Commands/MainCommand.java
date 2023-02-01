package me.troldepus2005.blockmania.Commands;

import me.troldepus2005.blockmania.Main;
import me.troldepus2005.blockmania.utils.Config;
import me.troldepus2005.blockmania.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (args.length == 0) {

                new Message().defaultMessage(p, 1);
                return true;
            }

            if (args[0].equalsIgnoreCase("reload")) {

                if (!p.hasPermission("Blockmania.reload") && !p.hasPermission("Blockmania.*")){
                    new Message().MissingPerm(p, "Blockmania.reload");
                    return true;
                }

                new Message().Restarting(p);
                Bukkit.getLogger().warning("Blockmania being reload by " + p.getName());
                Bukkit.getLogger().warning("Blockmania being reload by " + p.getName());
                Bukkit.getLogger().warning("Blockmania being reload by " + p.getName());
                Bukkit.getLogger().warning("Blockmania being reload by " + p.getName());
                Bukkit.getLogger().warning("Blockmania being reload by " + p.getName());
                new Config(Main.getMain(), false).reload();
                return true;
            }



        }
        return true;
    }
}
