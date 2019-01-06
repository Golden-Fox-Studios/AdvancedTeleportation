package com.superkooks.advancedteleportation;

import com.superkooks.advancedteleportation.blocks.BlockTeleporterPad;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = AdvancedTeleportation.MODID, version = AdvancedTeleportation.VERSION)
public class AdvancedTeleportation {
	public static final String MODID = "advancedteleportation";
	public static final String VERSION = "0.1";
	
	public static Block blockTeleporterPad;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Blocks
		blockTeleporterPad = new BlockTeleporterPad(Material.rock).setBlockName("TeleporterPad")
				.setBlockTextureName("advancedteleportation:blockTeleporterPad").setCreativeTab(tabAdvancedTeleportation);
	
		// Registering
		// Blocks
		GameRegistry.registerBlock(blockTeleporterPad,
				blockTeleporterPad.getUnlocalizedName().substring(5));
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Guis and stuff
		MinecraftForge.EVENT_BUS.register(new AdvancedTeleportationEventHandler());
	}
	
	public static CreativeTabs tabAdvancedTeleportation = new CreativeTabs("tabAdvancedTeleportation") {
		@Override
		public Item getTabIconItem() {
			System.out.println(Item.getItemFromBlock(blockTeleporterPad));
			return Item.getItemFromBlock(blockTeleporterPad);
		}
	};
}
