package me.troldepus2005.blockmania.utils;

import me.troldepus2005.blockmania.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.ArrayList;

public class utils {

    static Main main = Main.getMain();

    public static File getFile(){
        File f = new File(main.getDataFolder(), "config.yml");
        return f;
    }

    public static FileConfiguration getConfig(){
        File f = utils.getFile();
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        return c;
    }

    public static ArrayList getWandsType() {
        ArrayList<String> wands = new ArrayList<String>();
        FileConfiguration config = utils.getConfig();
        for (int x = 1; config.getConfigurationSection("Wands." + x) != null; x++ ) {
            wands.add(config.getString("Wands." + x + "." +"Wand Type"));
        }
        return wands;
    }

    public static ArrayList getWandsBlock() {
        ArrayList<String> blocks = new ArrayList<String>();
        FileConfiguration config = utils.getConfig();
        for (int x = 1; config.getConfigurationSection("Wands." + x) != null; x++) {
            blocks.add(config.getString("Wands." + x + "." +"Block Type"));
        }
        return blocks;
    }

    public static ArrayList getWandsDamage() {
        ArrayList<Integer> damage = new ArrayList<Integer>();
        FileConfiguration config = utils.getConfig();
        for (int x = 1; config.getConfigurationSection("Wands." + x) != null; x++) {
            damage.add(config.getInt("Wands." + x + "." +"Damage"));
        }
        return damage;
    }

    public static ArrayList getWandsVelocity() {
        ArrayList<Double> velocity = new ArrayList<Double>();
        FileConfiguration config = utils.getConfig();
        for (int x = 1; config.getConfigurationSection("Wands." + x) != null;  x++) {
            velocity.add(config.getDouble("Wands." + x + "." +"Velocity"));
        }
        return velocity;
    }

}
