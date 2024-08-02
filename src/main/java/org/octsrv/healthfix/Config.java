package org.octsrv.healthfix;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = Healthfix.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.DoubleValue FIXED_HEALTH = BUILDER
        .comment("修復NaN後的血量")
        .defineInRange("fixedHealth", 20f, 0f, Float.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static double fixedHealth;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        fixedHealth = FIXED_HEALTH.get();
    }
}
