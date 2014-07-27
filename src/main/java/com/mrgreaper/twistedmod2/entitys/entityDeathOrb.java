package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.handlers.SoundHandler;
import com.mrgreaper.twistedmod2.reference.FluidInfo;
import com.mrgreaper.twistedmod2.reference.ItemInfo;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by david on 27/07/2014.
 */
public class entityDeathOrb extends Entity {
    public entityDeathOrb(World world) {
        super(world);
    }

    private double startY;
    private double targetY;
    public int counter;
    private float tone = 0F;
    private float RA = 3F;

    @Override
    protected void entityInit() {

    }

    public entityDeathOrb(World world, double x, double y, double z) {
        this(world);

        posX = x;
        startY = posY = y;
        posZ = z;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        startY = nbttagcompound.getShort("Start");
        targetY = nbttagcompound.getShort("Target");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("Start", (short) startY);
        nbttagcompound.setShort("Target", (short) targetY);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!worldObj.isRemote) {

            if (targetY == 0 || Math.abs(posY - targetY) < 0.25) { //are we at the target?
                targetY = startY + worldObj.rand.nextDouble() * RA; //ah yes then lets get a new target!
                SoundHandler.onEntityPlay("deathOrbLaunch", this.worldObj, this, 1, tone);
                //Sounds.DEATH_ORB_LAUNCH.onEntityPlay(worldObj, this, 1, tone);
                RA = RA - 0.1F;
                tone = tone + 0.1F;
                counter++;
                if (counter == 20) {
                    tone = 1;
                    RA = 5F;
                    Random randomGenerator = new Random();
                    int randomInt = randomGenerator.nextInt(3);
                    SoundHandler.onEntityPlay("exp_trail", this.worldObj, this, 1, 1);
                    //Sounds.EXP_TRAIL.onEntityPlay(worldObj, this, 1, 1);
                    switch (randomInt) {//changed from if to switch to make it neater

                        case 0:
                            if (!this.worldObj.isRemote) {
                                this.entityDropItem(new ItemStack(ItemInfo.itemRedballoon), 1);
                            }
                            this.setDead();
                            break;
                        case 1:
                            if (!this.worldObj.isRemote) {
                                this.entityDropItem(new ItemStack(ItemInfo.itemOrphanLeg), 1);
                            }
                            this.setDead();
                            break;
                        case 2:
                            if (!this.worldObj.isRemote) {
                                this.entityDropItem(new ItemStack(FluidInfo.orphanTearsBucket), 1);
                            }
                            this.setDead();
                            break;
                    }
                }
            }

            if (posY < targetY) { //are we bellow the targe?
                motionY = 0.05; //move up
            } else { //ah then we must be above the target
                motionY = -0.05; //move down
            }

        }
        setPosition(posX + motionX, posY + motionY, posZ + motionZ);
    }
}
