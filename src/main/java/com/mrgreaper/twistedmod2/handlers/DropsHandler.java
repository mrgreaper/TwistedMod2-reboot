package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.entitys.entityBunnyMob;
import com.mrgreaper.twistedmod2.reference.ItemInfo;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
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

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
        random = new Random();
        dropped = random.nextInt(2) + 1;

        if (event.entityLiving instanceof EntityCow) {
            event.entityLiving.entityDropItem(new ItemStack(Items.apple), dropped);
        }
        if (event.entityLiving instanceof entityBunnyMob) {
            event.entityLiving.entityDropItem(new ItemStack(ItemInfo.itemDeadBunny), 1);
        }
    }
}
