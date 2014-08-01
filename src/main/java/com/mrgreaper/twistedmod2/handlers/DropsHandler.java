package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.entitys.entityBunnyMob;
import com.mrgreaper.twistedmod2.reference.ItemInfo;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;

/**
 * Created by david on 22/06/2014.
 */
public class DropsHandler {
    //example drop handler

    public static Random random;
    public static int dropped;
    public static int dropped2;

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
        random = new Random();
        dropped = random.nextInt(2) + 1;
        dropped2 = random.nextInt(3) + 1;

        if (event.entityLiving instanceof entityBunnyMob) {
            event.entityLiving.entityDropItem(new ItemStack(ItemInfo.itemDeadBunny), 1);
        }
        if (event.entityLiving instanceof EntityPig) {
            event.entityLiving.entityDropItem(new ItemStack(ItemInfo.itemBaconUncooked), dropped2);
        }
    }
}
