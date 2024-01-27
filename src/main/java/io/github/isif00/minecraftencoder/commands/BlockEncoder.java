package io.github.isif00.minecraftencoder.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static java.lang.Math.cbrt;
import static org.bukkit.Bukkit.getServer;

public class BlockEncoder implements CommandExecutor {
    private final Material[] materials;
    private final Material[] encodedMaterial = new Material[2000];
    private final byte[] bytes;

    public BlockEncoder(Material[] materials, byte[] bytes) {
        this.materials = materials;
        this.bytes = bytes;
    }

    //XYZ 68 80 80
    public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args) {
        // toblocks command
        if (cmd.getName().equalsIgnoreCase("toblocks")) {
            World world = Bukkit.getWorld("world");

            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Blocking");
            int i = 0;
            for (byte value : bytes) {
                if (value >= 0 && materials[value] != null) {
                    getServer().getConsoleSender().sendMessage("the byte: " + ChatColor.DARK_PURPLE + String.valueOf(value) + " is represented by: " + ChatColor.RED + materials[value].toString());
                    encodedMaterial[i] = materials[value];
                    i++;
                } else {
                    getServer().getConsoleSender().sendMessage("Invalid byte value: " + value);
                }
            }

            int x = 70;
            int y = 70;
            int z = 70;

            int dimension = (int) cbrt(encodedMaterial.length);

            int index = 0;
            for (int ii = 0; ii < dimension; ii++) {
                for (int j = 0; j < dimension; j++) {
                    for (int k = 0; k < dimension; k++) {
                        if (index < encodedMaterial.length && encodedMaterial[index] != null) {
                            Location location = new Location(world, x + ii, y + j, z + k);
                            Material material = encodedMaterial[index];
                            assert world != null;
                            world.getBlockAt(location).setType(material);
                            index++;
                        }
                    }
                }
            }
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "SHIT IS DONE " );


            return true;
        }
        return true;
    }
}