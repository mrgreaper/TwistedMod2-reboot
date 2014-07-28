package com.mrgreaper.twistedmod2.entitys;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.world.World;

/**
 * Created by david on 28/07/2014.
 */
public class entityBunnyMob extends EntityAnimal {
    public entityBunnyMob(World world) {
        super(world);
        this.setSize(1.0f, 1.0f);
        this.tasks.addTask(0, new EntityAIWander(this, 0.4d)); //so the first number is a priority then in brackets is this as its this and then the speed
        this.tasks.addTask(1, new EntityAIPanic(this, 0.9d));
        this.tasks.addTask(2, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAITempt(this, 0.4d, Items.carrot, false));//me,speed,tempting item,scared by movement

    }

    public boolean isAiEnabled() {
        return true;
    }

    protected void applyEntityAttributes() { //this sets the mobs attributes
        super.applyEntityAttributes(); //so any we dont define use the defaults
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0d);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4d);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    }


    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return new entityBunnyMob(worldObj);
    }
}
