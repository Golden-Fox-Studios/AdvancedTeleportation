package com.superkooks.advancedteleportation;

import com.superkooks.advancedteleportation.blocks.BlockTeleporterPad;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class AdvancedTeleportationEventHandler {
	@SubscribeEvent
	public void makePath(LivingUpdateEvent event) {
		if (event.entityLiving != null && event.entityLiving instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.entityLiving;
			Vec3 playerLocation = Vec3.createVectorHelper(player.posX, player.posY + player.getYOffset(), player.posZ);
			World world = player.worldObj;
			Block block = world.getBlock((int) playerLocation.xCoord - 1, (int) playerLocation.yCoord, (int) playerLocation.zCoord); 

			if (block instanceof BlockTeleporterPad) {
				System.out.println("teleporting");
				player.mountEntity((Entity)null);
				player.setPositionAndUpdate(playerLocation.xCoord - 11, playerLocation.yCoord, playerLocation.zCoord);
			}
		}
	} 
}
