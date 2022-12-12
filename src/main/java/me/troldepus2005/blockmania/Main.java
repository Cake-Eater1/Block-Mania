package me.troldepus2005.blockmania;

import me.troldepus2005.blockmania.Events.BlockChangeListener;
import me.troldepus2005.blockmania.Events.playerInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.block.EntityBlockStorage;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    public static Main main; // Instance

    public static Plugin plugin;


    @Override
    public void onEnable() {
        // Plugin startup logic

        //define main to instance
        main = this;

        //config magic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        //check if path plugins/expmines/users exist, if not create it
        File f = new File("plugins"+File.separator+"EXPMines"+File.separator+"users");
        if (!f.exists()) {
            f.mkdir();
            Bukkit.getLogger().info("User package created");
        }

        getServer().getPluginManager().registerEvents(new playerInteractListener(), this); // Register listeners
        getServer().getPluginManager().registerEvents(new BlockChangeListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    //get the main from the class Main, then return to the variable main, i think
    public static Main getMain(){
        return main;
    }

}
