package io.github.isif00.minecraftencoder.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static io.github.isif00.minecraftencoder.MinecraftEncoder.getBytes;
import static org.bukkit.Bukkit.getServer;

public class BlockEncoder implements CommandExecutor {
    private final Material[] materials;
    private final byte[] bytes;

    public BlockEncoder(Material[] materials, byte[] bytes) {
        this.materials = materials;
        this.bytes = bytes;
    }

    public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args) {
        // toblocks command
        if (cmd.getName().equalsIgnoreCase("toblocks")){
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Blocking");

            for (byte value : bytes) {
                if (materials[value] != Material.GRAVEL || materials[value] != Material.AIR || materials[value] != Material.WATER || materials[value] != Material.LAVA) {
                    getServer().getConsoleSender().sendMessage(ChatColor.RED + materials[value].toString());
                }
            }
        }
        return true;
    }
}
