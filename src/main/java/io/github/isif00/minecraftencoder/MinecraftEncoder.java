package io.github.isif00.minecraftencoder;

import io.github.isif00.minecraftencoder.commands.HelloWorld;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MinecraftEncoder extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[INFO] MinecraftEncoder is starting up");
        Objects.requireNonNull(getCommand("hello")).setExecutor(new HelloWorld());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[INFO] MinecraftEncoder is shutting down");
    }
}
