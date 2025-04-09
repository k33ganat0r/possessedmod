package com.k33ganat0r.possessedmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Mod(PossessedMod.MOD_ID)
public class PossessedMod {
    public static final String MOD_ID = "possessedmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PossessedMod() {
        LOGGER.info("Possessed Mod Loaded!");
        MinecraftForge.EVENT_BUS.register(ProgressionHandler.class);
    }

    public static void enableCorruption() {
        try {
            // Ensure mods and mods_disabled folders exist
            Path disabledFolder = new File("mods_disabled").toPath();
            Path modsFolder = new File("mods").toPath();
            if (!Files.exists(disabledFolder)) {
                Files.createDirectories(disabledFolder);
            }
            if (!Files.exists(modsFolder)) {
                Files.createDirectories(modsFolder);
            }

            // Define file paths
            Path disabledModPath = disabledFolder.resolve("thebrokenscript-1.9.3-forge-1.20.1.jar");
            Path enabledModPath = modsFolder.resolve("thebrokenscript-1.9.3-forge-1.20.1.jar");

            LOGGER.info("Disabled Mod Path: {}", disabledModPath);
            LOGGER.info("Enabled Mod Path: {}", enabledModPath);

            // Copy the file from disabled to mods folder
            if (Files.exists(disabledModPath)) {
                Files.copy(disabledModPath, enabledModPath, StandardCopyOption.REPLACE_EXISTING);
                LOGGER.info("the_broken_script Copied to Mods Folder!");
            } else {
                LOGGER.error("The_broken_script file not found in disabled folder!");
                return;
            }

            // Trigger game closure and messaging
            triggerGameClosure();

        } catch (Exception e) {
            LOGGER.error("Error copying mod: {}", e.getMessage(), e);
        }
    }

    private static void triggerGameClosure() {
        // Ensure this runs on the main thread
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.execute(() -> {
            // Send message to chat
            if (minecraft.player != null) {
                Component message = Component.literal(" He's hereHe's hereHe's hereHe's hereHe's hereHe's hereHe's hereHe's nullnullnullnullnullnullnullnullnullnullnullnullnullnull hereHe's hereHe's hereHe's hereHe's here...");
                minecraft.player.displayClientMessage(message, false);
                LOGGER.warn("NULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULL");
            }

            // Schedule game closure
            new Thread(() -> {
                try {
                    // Short delay to ensure message is displayed
                    Thread.sleep(3000);

                    // Attempt to close the game
                    minecraft.stop();

                    // Force exit if stop() doesn't work
                    System.exit(1);
                } catch (InterruptedException e) {
                    LOGGER.error("Interruption during game closure: {}", e.getMessage());
                }
            }).start();
        });
    }
}