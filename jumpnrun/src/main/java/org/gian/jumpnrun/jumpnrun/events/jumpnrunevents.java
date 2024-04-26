package org.gian.jumpnrun.jumpnrun.events;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import static org.bukkit.Bukkit.getServer;

public class jumpnrunevents implements Listener {
    Location jumpnruncheckpointlocation = new Location(Bukkit.getWorld("jumpnruneasy"), 10.5, -63, 4.5);;

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public  void onDropOffPlatform (PlayerMoveEvent event) {
        String w = event.getPlayer().getWorld().getName();
        Player player = event.getPlayer();
        if (w.matches("^jumpnrun(?:medium|easy|hard)?$")) {
            Location tolocation = event.getTo();
            int newY = tolocation.getBlockY();
            if (newY <= -70) {
                player.teleport(jumpnruncheckpointlocation);;
                player.setHealth(20);
            }
        }
    }
    @EventHandler
    public void onFallDamage (EntityDamageEvent event) {
        String w = event.getEntity().getWorld().getName();
        if (w.matches("^jumpnrun(?:medium|easy|hard)?$")) {
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public  void onkillPressurePlate (PlayerInteractEvent event) {
        String w = event.getPlayer().getWorld().getName();
        if (w.matches("^jumpnrun(?:medium|easy|hard)?$")) {
            if (event.getAction().equals(Action.PHYSICAL)) {
                if (event.getClickedBlock().getType().equals(Material.OAK_PRESSURE_PLATE)) {
                    event.getPlayer().teleport(jumpnruncheckpointlocation);;
                    event.getPlayer().setHealth(20);
                }
            }
        }
    }
    @EventHandler
    public  void onCheckpointPressurePlate (PlayerInteractEvent event) {
        String w = event.getPlayer().getWorld().getName();
        if (w.matches("^jumpnrun(?:medium|easy|hard)?$")) {
            if (event.getAction().equals(Action.PHYSICAL)) {
                if (event.getClickedBlock().getType().equals(Material.HEAVY_WEIGHTED_PRESSURE_PLATE)) {
                    if (!jumpnruncheckpointlocation.equals(event.getClickedBlock().getLocation())) {
                        Player player = event.getPlayer();
                        player.sendTitle("Checkpoint", "");
                        jumpnruncheckpointlocation = event.getClickedBlock().getLocation();
                    }
                }
            }
        }
    }
    @EventHandler
    public  void onEndPressurePlate (PlayerInteractEvent event) {
        String w = event.getPlayer().getWorld().getName();
        if (w.matches("^jumpnrun(?:medium|easy|hard)?$")) {
            if (event.getAction().equals(Action.PHYSICAL)) {
                if (event.getClickedBlock().getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE)) {
                    Player player = event.getPlayer();
                    player.sendTitle("Jump and Run Geschafft", "Gratuliere " + player.getName());
                    Location jumpnrunserver = player.getWorld().getSpawnLocation();
                    player.getInventory().clear();
                    jumpnruncheckpointlocation = player.getWorld().getSpawnLocation();
                    player.teleport(jumpnrunserver);
                }
            }
        }
    }
}

