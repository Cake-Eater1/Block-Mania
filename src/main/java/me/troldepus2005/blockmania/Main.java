package me.troldepus2005.blockmania;

import com.sk89q.worldguard.WorldGuard;
import me.troldepus2005.blockmania.Commands.MainCommand;
import me.troldepus2005.blockmania.Events.BlockChangeListener;
import me.troldepus2005.blockmania.Events.TabCompleteListener;
import me.troldepus2005.blockmania.Events.playerInteractListener;
import me.troldepus2005.blockmania.Worldguard.WorldGuardFlags;
import me.troldepus2005.blockmania.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public static Main main; // Main class
    public static Main instance; // Instance

    public static Plugin plugin;

    //For Config

    // Create file and file configuration variable
    public static File file;
    public static FileConfiguration fileConfiguration;

    // Initialize variables before setting them, still for config

    // Wand variables
    public static ArrayList<String> wands = new ArrayList<String>();
    public static ArrayList<String> blocks = new ArrayList<String>();
    public static ArrayList<Integer> damage = new ArrayList<Integer>();
    public static ArrayList<Double> velocity = new ArrayList<Double>();
    public static ArrayList<Integer> offset = new ArrayList<Integer>();
    public static ArrayList<String> name = new ArrayList<String>();
    // Detection Variables
    public static ArrayList<Integer> range = new ArrayList<Integer>();
    public static int delay;
    public static int period;



    @Override
    public void onEnable() {

        for (int i = 1; i > 20; i++) {

            System.out.println("STARTING");

        }

        new Config(this,true); // Get config file
        // Plugin startup logic

        //define main to instance
        main = this; // set main
        instance = this; // Set instance

        //Worldguard depend
        if (WorldGuard.getInstance() != null) {
            Bukkit.getLogger().info("WorldGuard found");
            new WorldGuardFlags().onLoad();
        }

        getServer().getPluginManager().registerEvents(new playerInteractListener(), this); // Register listeners
        getServer().getPluginManager().registerEvents(new BlockChangeListener(), this);

        //Tab Complete Listener
        this.getCommand("blockmania").setTabCompleter(new TabCompleteListener());

        //Commands
        getServer().getPluginCommand("Blockmania").setExecutor(new MainCommand());



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
