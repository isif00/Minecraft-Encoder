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
import java.util.Objects;


public final class MinecraftEncoder extends JavaPlugin {

    public static final int MATERIAL_LENGTH = Material.values().length;

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
    public Material[] lookUpTable(){
        Material[] materials = new Material[MATERIAL_LENGTH];
        for (int i = 0; i < MATERIAL_LENGTH; i++) {
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + Material.values()[i].toString());
            materials[i] = Material.values()[i];
        }
        return materials;
    }

    public static byte[] getBytes() throws IOException {
        File file = new File("/home/isifoo/Projects/Others/minecraftEncoder/plugins/Server/eula.txt");

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
