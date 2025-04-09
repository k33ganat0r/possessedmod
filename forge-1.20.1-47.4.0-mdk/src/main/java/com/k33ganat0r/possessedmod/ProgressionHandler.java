package com.k33ganat0r.possessedmod;

import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.Event;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

@Mod.EventBusSubscriber(modid = PossessedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ProgressionHandler {

    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void onAdvancement(AdvancementEvent event) {
        // Explicitly log to verify method is being called
        LOGGER.info("Advancement Event Triggered: {}", event.getAdvancement().getId());

        // Null check to prevent potential null pointer exceptions
        if (event.getAdvancement() != null &&
                "fomo:level_5/tbs_start".equals(event.getAdvancement().getId().toString())) {
            LOGGER.info("Say goodbye to your world");
            PossessedMod.enableCorruption();
        }
    }
}