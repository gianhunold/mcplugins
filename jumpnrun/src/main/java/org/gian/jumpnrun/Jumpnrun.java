package org.gian.jumpnrun;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.plugin.java.JavaPlugin;
import org.gian.jumpnrun.jumpnrun.commands.jumpnrun;
import org.gian.jumpnrun.jumpnrun.events.jumpnrunevents;

public final class Jumpnrun extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Generate Worlds
        WorldCreator wc_jumpnrun_easy = new WorldCreator("jumpnruneasy");
        wc_jumpnrun_easy.environment(World.Environment.NORMAL);
        wc_jumpnrun_easy.type(WorldType.FLAT);
        wc_jumpnrun_easy.generateStructures(false);
        wc_jumpnrun_easy.createWorld();

        WorldCreator wc_jumpnrun_medium = new WorldCreator("jumpnrunmedium");
        wc_jumpnrun_medium.environment(World.Environment.NORMAL);
        wc_jumpnrun_medium.type(WorldType.FLAT);
        wc_jumpnrun_medium.generateStructures(false);
        wc_jumpnrun_medium.createWorld();

        WorldCreator wc_jumpnrun_hard = new WorldCreator("jumpnrunhard");
        wc_jumpnrun_hard.environment(World.Environment.NORMAL);
        wc_jumpnrun_hard.type(WorldType.FLAT);
        wc_jumpnrun_hard.generateStructures(false);
        wc_jumpnrun_hard.createWorld();

        //Mod Change
        getCommand("jumpnrun").setExecutor((new jumpnrun()));

        //Listeners
        getServer().getPluginManager().registerEvents(new jumpnrunevents(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
