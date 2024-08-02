package org.octsrv.healthfix;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Healthfix.MODID)
public class Healthfix {
    public static final String MODID = "healthfix";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Healthfix() {
        MinecraftForge.EVENT_BUS.register(new HealthListener());

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
