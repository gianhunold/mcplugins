package org.gian.jumpnrun.jumpnrun.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jumpnrun implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Location jumpnrunserver = new Location(Bukkit.getWorld("jumpnruneasy"), 10.5, -63, 4.5);
            if (strings[0].equals("easy")) {
                jumpnrunserver = new Location(Bukkit.getWorld("jumpnruneasy"), 10.5, -63, 4.5);
            }
            if (strings[0].equals("medium")) {
                jumpnrunserver = new Location(Bukkit.getWorld("jumpnrunmedium"), 0.5, -63, 0.5);
            }
            if (strings[0].equals("hard")) {
                jumpnrunserver = new Location(Bukkit.getWorld("jumpnrunhard"), 0.5, -63, 0.5);
            }
            player.getInventory().clear();
            player.teleport(jumpnrunserver);
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1) {
            return Arrays.asList("easy", "medium", "hard");
        }
        return new ArrayList<>();
    }
}