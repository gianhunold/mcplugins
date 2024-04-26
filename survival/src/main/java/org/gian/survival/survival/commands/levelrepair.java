package org.gian.survival.survival.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class levelrepair implements CommandExecutor {

    private  static  boolean damageable1;
    static {
        try {
            Class.forName("org.bukkit.inventory.meta.Damageable");
            damageable1 = true;
        } catch (ClassNotFoundException ignored) {

        }
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        int currentlevel = player.getLevel();
        ItemStack currentitem = player.getInventory().getItemInMainHand();
        ItemMeta meta = currentitem.getItemMeta();
        if (damageable1) {
            int needetlevel = (int)Math.ceil(((float)(((Damageable)meta).getDamage())/(float)(currentitem.getType().getMaxDurability()) *5));
            if (needetlevel < currentlevel ) {
                player.setLevel(currentlevel-needetlevel);
                ((Damageable) meta).setDamage(0);
                currentitem.setItemMeta(meta);
            }
        }
        return false;
    }
}
