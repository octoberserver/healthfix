package org.octsrv.healthfix;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HealthListener {
    @SubscribeEvent
    public void onLivingTick(LivingEvent.LivingTickEvent event) {
        if (event.getEntity() instanceof Player p) {
            if (Float.isNaN(p.getHealth())) {
                p.setHealth((float) Config.fixedHealth);
                Healthfix.LOGGER.debug("Fixed Health of player {} from NaN to {}", p.getName(), Config.fixedHealth);
            }
        }
    }
}
