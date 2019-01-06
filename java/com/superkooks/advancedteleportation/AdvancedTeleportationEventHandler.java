package com.superkooks.advancedteleportation;

import com.superkooks.advancedteleportation.blocks.BlockTeleporterPad;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class AdvancedTeleportationEventHandler {
	@SubscribeEvent
	public void checkStandingOn(LivingUpdateEvent event) {
		if (event.entityLiving != null && event.entityLiving instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.entityLiving;
			World world = player.worldObj;
			Block block = world.getBlock((int) player.posX - 1, (int) player.posY - 1, (int) player.posZ); 

			if (block instanceof BlockTeleporterPad) {
				player.mountEntity((Entity)null);
				player.setPositionAndUpdate(player.posX - 10, player.posY, player.posZ);
			}
		}
	} 
}
