package me.troldepus2005.blockmania.utils;

import me.troldepus2005.blockmania.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Message {

    public void Message () {
    }

    public void Prefix (Player player) {
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_BLUE + "▓" + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE + "Blockmania " + ChatColor.GRAY + "v" + Main.getMain().getDescription().getVersion());;
    }

    public void defaultMessage(Player player, int page) {
        if (page == 1) {
            new Message().Prefix(player);
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_BLUE + "▓" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Commands:");
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_BLUE + "▓" + ChatColor.DARK_GRAY + "] " + "" + ChatColor.ITALIC + "/Blockmania reload");
        }
    }

    public void MissingPerm(Player player, String permission) {
        new Message().Prefix(player);
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_BLUE + "▓" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "" + ChatColor.BOLD + "Missing Permission");
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_BLUE + "▓" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "" + ChatColor.ITALIC + permission);
    }

    public void Restarting(Player player) {
        new Message().Prefix(player);
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_BLUE + "▓" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "" + ChatColor.BOLD + "reloading");
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_BLUE + "▓" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "" + ChatColor.BOLD + "reloading");
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_BLUE + "▓" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "" + ChatColor.BOLD + "reloading");
    }

}
