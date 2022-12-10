package me.troldepus2005.blockmania;

import me.troldepus2005.blockmania.utils.config;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    public static Main instance; // Instance

    public Logger logger = Logger.getLogger(getDescription().getName()); // Set console logger

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this; // Set instance

        new config(this, true); // Get config file

//        new ConveyorBeltChecker(); // Start runnable

//        getServer().getPluginManager().registerEvents(new Listeners(this), this); // Register listeners

        logger.info("Plugin enabled"); // Inform console that the plugin is enabled

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        instance = null; // Set instance to null

        logger.info("Plugin disabled"); // Inform console that the plugin is disabled
    }
}
