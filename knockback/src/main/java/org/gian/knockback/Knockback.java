package org.gian.knockback;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.plugin.java.JavaPlugin;
import org.gian.knockback.knockback.commands.knockback;
import org.gian.knockback.knockback.events.knockoff;

public final class Knockback extends JavaPlugin {

    public static String knockbackitem;
    public static int enchantlevel;

    @Override
    public void onEnable() {
        //Check for Config File | If not there, Create config File
        if (!getDataFolder().exists()){
            getLogger().info("Creating "+ getDataFolder() +" main directory ");
            getDataFolder().mkdir();
            //creating main plugin directory if not exists
            getLogger().info("Creating config file for: " + getDataFolder());
            this.getConfig().set("Knockback Item", "STICK");
            this.getConfig().set("Knockback Strenght", 7);
            this.saveConfig();
            // then saving the config
        }

        knockbackitem = this.getConfig().getString("Knockback Item");
        enchantlevel = this.getConfig().getInt("Knockback Strenght");

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
