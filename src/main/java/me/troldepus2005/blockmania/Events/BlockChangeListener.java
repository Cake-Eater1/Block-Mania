package me.troldepus2005.blockmania.Events;

import me.troldepus2005.blockmania.Main;
import me.troldepus2005.blockmania.utils.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class BlockChangeListener implements Listener {

    @EventHandler
    public void onBlockChangeEvent(EntityChangeBlockEvent  e) {

        if (!new Config(Main.instance,false).getWandsBlock().contains(e.getTo().toString())) {
            return;
        }
        e.setCancelled(true);

    }

}
