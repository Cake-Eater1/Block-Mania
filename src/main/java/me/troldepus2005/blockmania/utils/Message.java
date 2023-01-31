package me.troldepus2005.blockmania.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class Message {

    public void Message () {
    }

    public void Prefix (Player player) {
        player.sendMessage (ChatColor.BLUE + "" + ChatColor.BOLD + "Block" + ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "mania");
    }

    public void defaultMessage(Player player, int page) {
        if (page == 1) {
            new Message().Prefix(player);
            player.sendMessage("1.");
            player.sendMessage(ChatColor.DARK_BLUE + "Commands:");
            player.sendMessage(ChatColor.BLUE + "" + ChatColor.ITALIC + "/Blockmania restart");
        }
    }

    public void MissingPerm(Player player, String permission) {
        new Message().Prefix(player);
        player.sendMessage("");
        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Missing Permission");
        player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + permission);
    }

    public void Restarting(Player player) {
        new Message().Prefix(player);
        player.sendMessage("");
        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Restarting");
        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Restarting");
        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Restarting");
    }

}
