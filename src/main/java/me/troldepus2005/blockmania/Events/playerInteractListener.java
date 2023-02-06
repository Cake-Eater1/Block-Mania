package me.troldepus2005.blockmania.Events;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.RegionContainer;
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
import java.util.List;

public class playerInteractListener implements Listener {



    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        RegionContainer regionContainer = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regionManager = regionContainer.get(BukkitAdapter.adapt(p.getLocation().getWorld()));

        List<String> regions = regionManager.getApplicableRegionsIDs(BukkitAdapter.asBlockVector(p.getLocation()));
        Flag flag = (WorldGuard.getInstance().getFlagRegistry().get("allow-block-mania"));

        for (int o = 0; regions.size() > o ; o++) {

            if (regionManager.getRegion(regions.get(o)).getFlag(flag) == null) {
                continue;
            }

            Action a = e.getAction();

            if (!(a.equals(Action.RIGHT_CLICK_AIR))) {
                return;
            }

            Material i = p.getInventory().getItemInMainHand().getType();

            ArrayList wands = new Config(Main.instance, false).getWandsType();
            ArrayList names = new Config(Main.instance, false).getWandsName();
            ArrayList wandsBlock = new Config(Main.instance,false).getWandsBlock();
            ArrayList wandsVelocity = new Config(Main.instance,false).getWandsVelocity();


            for (int x = 0; wands.size() != x; x++) {

                if (!p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(names.get(x).toString())) {
                    continue;
                }

                if (!wands.get(x).toString().equals(i.toString())) {
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

            break;

        }



    }

}
