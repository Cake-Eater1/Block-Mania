package me.troldepus2005.blockmania.utils;

import me.troldepus2005.blockmania.Main;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
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

               List<Entity> entities = fB.getNearbyEntities(2,2,2);

               if (entities.isEmpty()) {
                   return;
               }

               if (players.isEmpty()) {
                   return;
               }

               System.out.println(entities);
//               System.out.println(players);

                if (players.contains(entities.get(1))) {

                    System.out.println("4");
                    cancel();
                }

               }
           }.runTaskTimer(Main.getMain(), 10L, 1L);

        }

//    taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getMain(), new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("1");
//
//            if (fB.isOnGround() || !fB.isValid()) {
//                System.out.println("2");
//                Bukkit.getScheduler().cancelTask(taskId);
//
//            }
//
//            System.out.println("3");
//
//            //check if it hits player
//            if (fB.getNearbyEntities(2,2,2).contains(players)) {
//
//                System.out.println("4");
//
//
//            }
//
//            System.out.println("5");
//
//            @NotNull List<Entity> nearbyEntities = fB.getNearbyEntities(2,2,2);
//
//            System.out.println(fB.getNearbyEntities(2, 2,2));
//            System.out.println(nearbyEntities);
//        }
//    }, 3L, 1L);


}
