package me.troldepus2005.blockmania.Events;

import me.troldepus2005.blockmania.Main;
import me.troldepus2005.blockmania.utils.Config;
import me.troldepus2005.blockmania.utils.EntityPlayerCollisionCheck;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class playerInteractListener implements Listener {



    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Action a = e.getAction();

        if (!(a.equals(Action.RIGHT_CLICK_AIR))) {
            return;
        }

        Player p = e.getPlayer();
        Material i = p.getInventory().getItemInMainHand().getType();

        ArrayList wands = new Config(Main.instance, false).getWandsType();
        ArrayList wandsBlock = new Config(Main.instance,false).getWandsBlock();
        ArrayList wandsVelocity = new Config(Main.instance,false).getWandsVelocity();

        for (int x = 0; wands.size() != x; x++) {
            if (!wands.get(x).equals(i.toString())) {
                continue;
            }

            FallingBlock fB = p.getWorld().spawnFallingBlock(p.getLocation().add(Main.offset.get(0), Main.offset.get(1), Main.offset.get(2)), Material.getMaterial((String) wandsBlock.get(x)) , (byte) 0);
            fB.setVelocity(new Vector(p.getLocation().getDirection().getX() , p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ()).multiply((Double) wandsVelocity.get(x)));

            EntityPlayerCollisionCheck.CollisionChecker(fB);

            ItemStack t = p.getInventory().getItem(e.getHand());
            t.setAmount(t.getAmount()-1);
            p.getInventory().setItem(e.getHand(), t);

            break;

        }

    }

}
