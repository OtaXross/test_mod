package com.amemod.ame_weapon;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(AmeMod.MOD_ID)
public class AmeMod {
    public static final String MOD_ID = "amemod";

    public AmeMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Items.register(modEventBus);
        Blocks.register(modEventBus);
    }

    public static class Items {
        private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
        public static final RegistryObject<Item> AMEME_INGOT = ITEMS.register("ame_ingot", () -> new Item(new Item.Properties()
                .group(ItemGroup.MATERIALS)));
        public static final RegistryObject<Item> AMEME_SWORD = ITEMS.register("ame_sword", () -> new Item(new Item.Properties()
                .group(ItemGroup.COMBAT)));
        public static final RegistryObject<Item> AMEME_BLOCK = ITEMS.register("ame_block", () -> new BlockItem(Blocks.AMEME_BLOCK.get(), (new Item.Properties())
                .group(ItemGroup.BUILDING_BLOCKS)));

        public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }
    }


    public static class Blocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final RegistryObject<Block> AMEME_BLOCK = BLOCKS.register("ame_block", () -> new Block(AbstractBlock.Properties
            .create(Material.IRON)
            .setRequiresTool()
            .hardnessAndResistance(1.0F, 50.0F)
            .sound(SoundType.METAL)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(1)
    ));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
  }
}