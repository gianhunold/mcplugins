package org.gian.admininfo;

import org.bukkit.plugin.java.JavaPlugin;
import org.gian.admininfo.admininfo.commands.uptime;
import org.gian.admininfo.admininfo.commands.worldlist;

public final class Admininfo extends JavaPlugin {
    public static long serverStart;

    @Override
    public void onEnable() {
        // Plugin startup logic

        serverStart = System.currentTimeMillis();

        //Commands
        getCommand("worldlist").setExecutor((new worldlist()));
        getCommand("uptime").setExecutor((new uptime()));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
