package org.gian.admininfo.admininfo.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class worldlist implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String loadetworlds = Bukkit.getWorlds().toString();
        commandSender.sendMessage(loadetworlds);
        return false;
    }
}
