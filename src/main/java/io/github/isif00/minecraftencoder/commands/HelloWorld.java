package io.github.isif00.minecraftencoder.commands;

import io.github.isif00.minecraftencoder.MinecraftEncoder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static io.github.isif00.minecraftencoder.MinecraftEncoder.getBytes;
import static org.bukkit.Bukkit.getServer;

public class HelloWorld implements CommandExecutor {
    public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args) {

        if (!(Sender instanceof Player)) {
           return true;
        }
        Player player = (Player) Sender;

        // hello world command
        if (cmd.getName().equalsIgnoreCase("hello")){
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Hello, Coder!");
            player.sendMessage(ChatColor.GREEN + "Hello, world!");
        }
        return true;
    }
}
