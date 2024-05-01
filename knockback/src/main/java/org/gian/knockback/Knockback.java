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
    public static String knockbackmap;
    public static long knockbackmap_x;
    public static int knockbackmap_y;
    public static long knockbackmap_z;

    @Override
    public void onEnable() {
        //Check for Config File | If not there, Create config File
        if (!getDataFolder().exists()){
            getLogger().info("Creating "+ getDataFolder() +" main directory ");
            getDataFolder().mkdir();
            //creating main plugin directory if not exists
            getLogger().info("Creating config file for: " + getDataFolder());
            this.getConfig().set("knockback-item", "STICK");
            this.getConfig().set("knockback-strenght", 7);
            this.getConfig().set("knockback-map", "knockbackmap");
            this.getConfig().set("knockback-map-x", 0.5);
            this.getConfig().set("knockback-map-y", 101);
            this.getConfig().set("knockback-map-z", 0.5);
            this.saveConfig();
            // then saving the config
        }

        knockbackitem = this.getConfig().getString("knockback-item");
        enchantlevel = this.getConfig().getInt("knockback-strenght");
        knockbackmap = this.getConfig().getString("knockback-map");

        knockbackmap_x = this.getConfig().getLong("knockback-map-x");
        knockbackmap_y = this.getConfig().getInt("knockback-map-y");
        knockbackmap_z = this.getConfig().getLong("knockback-map-z");

        // Plugin startup logic

        //Generate Worlds
        WorldCreator wc = new WorldCreator(knockbackmap);
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
