package org.gian.knockback.knockback.commands;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.gian.knockback.Knockback;

import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class knockback implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        Player player = (Player) commandSender;
        Location knockbackmid = new Location(getServer().getWorld(Knockback.knockbackmap), Knockback.knockbackmap_x,Knockback.knockbackmap_y,Knockback.knockbackmap_z);

        player.getInventory().clear();
        player.teleport(knockbackmid);
        player.setHealth(20);
        player.setFoodLevel(20);

        player.getInventory().setHeldItemSlot(0);
        //player.getInventory().setItemInMainHand(new ItemStack(Material.STICK,1));
        player.getInventory().setItemInMainHand(new ItemStack(Material.getMaterial(Knockback.knockbackitem),1));
        ItemStack currentitem = player.getInventory().getItemInMainHand();
        ItemMeta meta = currentitem.getItemMeta();
        meta.addEnchant(Enchantment.KNOCKBACK, Knockback.enchantlevel, true);
        currentitem.setItemMeta(meta);

        player.setGameMode(GameMode.SURVIVAL);
        return false;
    }
}
