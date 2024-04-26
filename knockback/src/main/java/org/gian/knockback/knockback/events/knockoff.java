package org.gian.knockback.knockback.events;

import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import static org.bukkit.Bukkit.getServer;

public class knockoff implements Listener {
    @EventHandler
    public void onHungerDeplete (FoodLevelChangeEvent event) {
        String w = event.getEntity().getWorld().getName();
        if (w.equals("knockbackmap")) {
            event.setCancelled(true);
            HumanEntity player = event.getEntity();
            player.setFoodLevel(20);
        }
    }
    @EventHandler
    public  void onHealtDeplete (PlayerItemDamageEvent event) {
        String w = event.getPlayer().getWorld().getName();
        if (w.equals("knockbackmap")) {
            event.setCancelled(true);
            HumanEntity player = event.getPlayer();
            player.setHealth(20);
        }
    }
    @EventHandler
    public  void onPlayerDropItem (PlayerDropItemEvent event) {
        String w = event.getPlayer().getWorld().getName();
        if (w.equals("knockbackmap")) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public  void onDropOffPlatform (PlayerMoveEvent event) {
        String w = event.getPlayer().getWorld().getName();
        if (w.equals("knockbackmap")) {
            Location tolocation = event.getTo();
            int newY = tolocation.getBlockY();
            if (newY <= 80) {
                Player player = event.getPlayer();
                Location knockbackmid = new Location(getServer().getWorld("knockbackmap"), 0.5,101,0.5);
                player.teleport(knockbackmid);
                player.setHealth(20);
            }
        }
    }
    @EventHandler
    public void onFallDamage (EntityDamageEvent event) {
        String w = event.getEntity().getWorld().getName();
        if (w.equals("knockbackmap")) {
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                event.setCancelled(true);
            }
        }
    }

}
