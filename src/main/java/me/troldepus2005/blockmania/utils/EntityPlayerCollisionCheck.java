package me.troldepus2005.blockmania.utils;

import me.troldepus2005.blockmania.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class EntityPlayerCollisionCheck {

    public static void CollisionChecker(FallingBlock fB){


       new BukkitRunnable() {

           ArrayList<Player> players = new ArrayList<Player> (Bukkit.getServer().getOnlinePlayers());

           @Override
           public void run() {

                if (fB.isOnGround() || !fB.isValid()) {
                    cancel();
                }

                //check if it hits player

                List<Entity> entities = fB.getNearbyEntities(Main.range.get(0),Main.range.get(1),Main.range.get(2));

                if (entities.isEmpty()) {
                    return;
                }

                for (int i = 0; entities.size() > i; i++) {

                    if (!players.contains(entities.get(i))) {
                        continue;
                    }

                    if (entities.get(i) instanceof Player) {
                        Player p = (Player) entities.get(i);
                        p.damage(new Config(Main.instance, false).getBlockDamage(fB.getBlockData().getMaterial().toString()));
                        fB.remove();
                        cancel();
                        break;
                    }

                }

           }
       }.runTaskTimer(Main.getMain(), Main.delay, Main.period);

    }

}


