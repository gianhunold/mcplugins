package org.gian.survival.survival.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class survival implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        Location jumpnrunserver = new Location(Bukkit.getWorld("survival"), -0.5,69,0.5);
        player.getInventory().clear();
        player.teleport(jumpnrunserver);
        return false;
    }
}
