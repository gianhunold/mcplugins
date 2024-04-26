package org.gian.knockback;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.plugin.java.JavaPlugin;
import org.gian.knockback.knockback.commands.knockback;
import org.gian.knockback.knockback.events.knockoff;

public final class Knockback extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Generate Worlds
        WorldCreator wc = new WorldCreator("knockbackmap");
        wc.environment(World.Environment.NORMAL);
        wc.type(WorldType.FLAT);
        wc.createWorld();

        //Mod Change
        getCommand("knockback").setExecutor(new knockback());

        //Listeners
        getServer().getPluginManager().registerEvents(new knockoff(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
