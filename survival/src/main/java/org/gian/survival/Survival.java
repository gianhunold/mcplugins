package org.gian.survival;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.plugin.java.JavaPlugin;
import org.gian.survival.survival.commands.feed;
import org.gian.survival.survival.commands.heal;
import org.gian.survival.survival.commands.levelrepair;
import org.gian.survival.survival.commands.survival;

public final class Survival extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Generate Worlds
        WorldCreator wc_survival = new WorldCreator("survival");
        wc_survival.environment(World.Environment.NORMAL);
        wc_survival.type(WorldType.NORMAL);
        wc_survival.generateStructures(true);
        wc_survival.createWorld();

        // Mod Changes
        getCommand("survival").setExecutor((new survival()));

        //Survival Commands
        getCommand("feed").setExecutor((new feed()));
        getCommand("heal").setExecutor((new heal()));
        getCommand("levelrepair").setExecutor(new levelrepair());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
