package me.troldepus2005.blockmania.Events;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteListener implements TabCompleter {

    @Override
    public List<String> onTabComplete (CommandSender sender, Command cmd, String label, String[] args){
        List<String> l = new ArrayList<String>();
        if(cmd.getName().equalsIgnoreCase("blockmania") && args.length >= 0){
            if(sender instanceof Player){
                Player p = (Player) sender;

                if(p.hasPermission("blockmania.restart")) {
                    l.add("reload");
                }

                if (p.hasPermission("blockmania.give")) {
                    l.add("give");
                }
                return l;

            }
        }
        return l;
    }

}
