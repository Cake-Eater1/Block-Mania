package me.troldepus2005.blockmania.utils;

import me.troldepus2005.blockmania.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Config {

        /**
     * @param instance instance of Main (main) class
     */
    public Config(Main instance, boolean startup) {
        Main.file = new File(instance.getDataFolder(), "config.yml");
        Main.fileConfiguration = YamlConfiguration.loadConfiguration(Main.file);
        if (startup) {
            //check if it is on startup, only ran on reload and onEnable
            loadDefault(instance);

            //load variables
            for (int x = 1; Main.fileConfiguration.getConfigurationSection("Wands." + x) != null; x++ ) {
                Main.wands.add(Main.fileConfiguration.getString("Wands." + x + "." + "Wand Type"));
                Main.blocks.add(Main.fileConfiguration.getString("Wands." + x + "." + "Block Type"));
                Main.damage.add(Main.fileConfiguration.getInt("Wands." + x + "." + "Damage"));
                Main.velocity.add(Main.fileConfiguration.getDouble("Wands." + x + "." + "Velocity"));
            }
            Main.offset.add(Main.fileConfiguration.getInt("Firing.Offset.x"));
            Main.offset.add(Main.fileConfiguration.getInt("Firing.Offset.y"));
            Main.offset.add(Main.fileConfiguration.getInt("Firing.Offset.z"));
            System.out.println(Main.offset);

            Main.range.add(Main.fileConfiguration.getInt("Detection.Hitbox.x"));
            Main.range.add(Main.fileConfiguration.getInt("Detection.Hitbox.y"));
            Main.range.add(Main.fileConfiguration.getInt("Detection.Hitbox.z"));
            Main.delay = Main.fileConfiguration.getInt("Detection.Delay");
            Main.period = Main.fileConfiguration.getInt("Detection.Period");

        }

    }

    // Save config.yml file
    public void save() {
        // Try to save the config.yml file configuration
        try {
            Main.fileConfiguration.save(Main.file);
        } catch (IOException exception) {
            exception.printStackTrace();

        }
    }

    // Get config.yml file
    public FileConfiguration get() {
        // Return config.yml file configuration
        return Main.fileConfiguration;
    }

    // Reload config.yml file
    public void reload() {
        // Try statement to prevent plugin failures
        try {
            new Config(Main.getMain(),true);
            Bukkit.getLogger().info("config.yml has been reloaded!"); // Send to console
            save(); // Save config
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // Load config.yml defaults (if file is deleted or corrupt)
    public void loadDefault(Main instance) {
        // If plugin folder doesn't exists, create one
        if (!instance.getDataFolder().exists()) {
            instance.getDataFolder().mkdir();
        }

//        this.file = new File(instance.getDataFolder(), "config.yml");

        // Check whether the file exists or not
        // If not, the file will be created and 'created-message' will be sent to the console
        // If so, the file loaded message will be sent to the console
        if (!Main.file.exists()) {
            try {
                // Try creating a new file
                Main.file.createNewFile();
                // Saving the default config.yml from the jar
                instance.saveResource("config.yml", true);
                // Send to console
                Bukkit.getLogger().info("config.yml has been created!");
            } catch (IOException e) {
                // Error message (creating new file)
                Bukkit.getLogger().warning("Couldn't create config.yml!");
            }
        } else {
            Main.fileConfiguration = YamlConfiguration.loadConfiguration(Main.file); // Load config
            Bukkit.getLogger().info("config.yml has been loaded!"); // Send to console
        }
    }

    //get variables from here

    public ArrayList getWandsType() {
        return Main.wands;
    }

    public ArrayList getWandsBlock() {
        return Main.blocks;
    }

    public ArrayList getWandsDamage() {
        return Main.damage;
    }

    public ArrayList getWandsVelocity() {
        return Main.velocity;
    }

    //can't initlize this variable before, as it changes on input

    public int getBlockDamage(String b) {
        for (int x = 1; true; x++) {
            if (b.equals(Main.fileConfiguration.getString("Wands." + x + "." + "Block Type"))) {
                return Main.fileConfiguration.getInt("Wands." + x + "." + "Damage");
            }
        }
    }

}
