package io.github.isif00.minecraftencoder;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftEncoder extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[INFO] MinecraftEncoder is starting up");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[INFO] MinecraftEncoder is shutting down");
    }
}
