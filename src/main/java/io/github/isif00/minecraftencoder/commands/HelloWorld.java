package io.github.isif00.minecraftencoder.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloWorld implements CommandExecutor {
    public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args) {
        if (!(Sender instanceof Player)) {
           return true;
        }
        Player player = (Player) Sender;

        // hello world command
        if (cmd.getName().equalsIgnoreCase("hello")){
            player.sendMessage("Hello, world!");
        }
        return true;
    }
}
