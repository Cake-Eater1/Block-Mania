package me.troldepus2005.blockmania.Events;

import me.troldepus2005.blockmania.Main;
import me.troldepus2005.blockmania.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class playerInteractListener implements Listener {



    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Action a = e.getAction();

        if (!(a.equals(Action.RIGHT_CLICK_AIR))) {
            return;
        }

        Player p = e.getPlayer();
        Material i = p.getInventory().getItemInMainHand().getType();

        ArrayList wands = utils.getWandsType();
        ArrayList wandsBlock = utils.getWandsBlock();
        ArrayList wandsVelocity = utils.getWandsVelocity();
        for (int x = 0; true; x++) {
            if (!wands.get(x).equals(i.toString())) {
                continue;
            }

            FallingBlock fB = p.getWorld().spawnFallingBlock(p.getLocation().add(0, 2, 0), Material.getMaterial((String) wandsBlock.get(x)) , (byte) 0);
            fB.setVelocity(new Vector(p.getLocation().getDirection().getX() , p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ()).multiply((Double) wandsVelocity.get(x)));


            break;

        }

    }

}
