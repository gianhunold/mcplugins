package org.gian.admininfo.admininfo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.gian.admininfo.Admininfo;

public class uptime implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        long diff =  System.currentTimeMillis()-Admininfo.serverStart;
        String serveruptime = (diff/86400000L + " Days" + (int)(diff/ 3600000L % 24L) + " Hours " + (int)(diff/ 60000L % 60L) + " Minutes " + (int)(diff/1000L % 60L) + "Secounds");
        commandSender.sendMessage(serveruptime);
        return false;
    }
}
