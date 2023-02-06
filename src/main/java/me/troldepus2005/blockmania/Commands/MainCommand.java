package me.troldepus2005.blockmania.Commands;

import me.troldepus2005.blockmania.Main;
import me.troldepus2005.blockmania.utils.Config;
import me.troldepus2005.blockmania.utils.Message;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

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

                if (!p.hasPermission("Blockmania.reload")){
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
            } else if (args[0].equalsIgnoreCase("give")) {

                if (!p.hasPermission("Blockmania.give")){
                    new Message().MissingPerm(p, "Blockmania.give");

                    return true;
                }

                ArrayList wands = new Config(Main.instance, false).getWandsType();
                ArrayList names = new Config(Main.instance, false).getWandsName();
                ArrayList wandsType = new Config(Main.instance,false).getWandsType();

                for (int x = 0; wands.size() > x; x++) {

                    ItemStack item = new ItemStack (Material.valueOf(wandsType.get(x).toString()) , 64);
                    ItemMeta meta = item.getItemMeta();
                    meta.displayName(Component.text (ChatColor.translateAlternateColorCodes('§', (String) names.get(x))));
                    item.setItemMeta(meta);
                    p.getInventory().addItem(item);

                }

            } else {

                new Message().defaultMessage(p, 1);
                return true;

            }



        }
        return true;
    }
}
