package me.troldepus2005.blockmania.Events;

import me.troldepus2005.blockmania.utils.utils;
import org.bukkit.block.EntityBlockStorage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class BlockChangeListener implements Listener {

    @EventHandler
    public void onBlockChangeEvent(EntityChangeBlockEvent  e) {

        if (!utils.getWandsBlock().contains(e.getTo().toString())) {
            return;
        }
        e.setCancelled(true);

    }

}
