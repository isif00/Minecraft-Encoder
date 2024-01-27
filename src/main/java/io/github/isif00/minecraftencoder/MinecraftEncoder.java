package io.github.isif00.minecraftencoder;

import io.github.isif00.minecraftencoder.commands.BlockEncoder;
import io.github.isif00.minecraftencoder.commands.HelloWorld;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public final class MinecraftEncoder extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[INFO] MinecraftEncoder is starting up");            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "hello coder");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "hello coder");

        // register the commands
        Objects.requireNonNull(getCommand("hello")).setExecutor(new HelloWorld());


        try {
            Objects.requireNonNull(getCommand("toblocks")).setExecutor(new BlockEncoder(lookUpTable(), getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // create an array to store the block types
    public Material[] lookUpTable() {
        Material[] materials = new Material[200];
        for (int i = 0; i < 200; i++) {
            if (Material.values()[i] == Material.AIR
                    || Material.values()[i] == Material.SAND
                    || Material.values()[i] == Material.WATER
                    || Material.values()[i] == Material.LAVA
                    || Material.values()[i] == Material.SUSPICIOUS_GRAVEL
                    || Material.values()[i] == Material.SUSPICIOUS_SAND
                    || Material.values()[i] == Material.OAK_SAPLING
                    || Material.values()[i] == Material.SPRUCE_SAPLING
                    || Material.values()[i] == Material.BIRCH_SAPLING
                    || Material.values()[i] == Material.JUNGLE_SAPLING
                    || Material.values()[i] == Material.ACACIA_SAPLING
                    || Material.values()[i] == Material.CHERRY_SAPLING
                    || Material.values()[i] == Material.DARK_OAK_SAPLING
                    || Material.values()[i] == Material.BEDROCK
            ) {
                materials[i] = Material.values()[i+1];
                getServer().getConsoleSender().sendMessage(ChatColor.GREEN + String.valueOf(i) + " is " + ChatColor.DARK_PURPLE + materials[i].toString());
            } else {
                materials[i] = Material.values()[i];
                getServer().getConsoleSender().sendMessage(ChatColor.GREEN + String.valueOf(i) + " is " + ChatColor.DARK_PURPLE + materials[i].toString());
            }
        }
        Set<Material> setMaterials = new HashSet<>(Arrays.asList(materials));
        return setMaterials.toArray(new Material[0]);
    }



    public static byte[] getBytes() throws IOException {
        File file = new File("/home/isifoo/Projects/Others/minecraftEncoder/plugins/Server/server.properties");

        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + file.getPath());
        }
        // Get the length of the file to determine the size of the byte array
        long length = file.length();

        // Create a byte array to hold all the bytes in the file
        byte[] b = new byte[(int) length];

        // Create a FileInputStream
        try (FileInputStream fin = new FileInputStream(file)) {
            // Read all bytes into the byte array
            fin.read(b);
        }
        return b;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[INFO] MinecraftEncoder is shutting down");
    }
}
