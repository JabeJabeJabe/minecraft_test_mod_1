package net.milos.testmod1.block;

import net.milos.testmod1.TestMod1;
import net.milos.testmod1.block.custom.GummoBerryCropBlock;
import net.milos.testmod1.block.custom.GummoLampBlock;
import net.milos.testmod1.block.custom.GummoWorkstationBlock;
import net.milos.testmod1.block.custom.JumpyBlock;
import net.milos.testmod1.fluid.ModFluids;
import net.milos.testmod1.item.ModCreativeModeTab;
import net.milos.testmod1.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod1.MOD_ID);

    public static final RegistryObject<Block> GUMMO_BLOCK = registerBlock("gummo_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TESTMOD1_TAB);

    public static final RegistryObject<Block> GUMMO_ORE = registerBlock("gummo_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.TESTMOD1_TAB);
    public static final RegistryObject<Block> DEEPSLATE_GUMMO_ORE = registerBlock("deepslate_gummo_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.TESTMOD1_TAB);

    public static final RegistryObject<Block> ENDSTONE_GUMMO_ORE = registerBlock("endstone_gummo_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.TESTMOD1_TAB);
    public static final RegistryObject<Block> NETHERRACK_GUMMO_ORE = registerBlock("netherrack_gummo_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.TESTMOD1_TAB);


    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.TESTMOD1_TAB);

    public static final RegistryObject<Block> GUMMO_LAMP = registerBlock("gummo_lamp",
            () -> new GummoLampBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(1f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(GummoLampBlock.LIT) ? 15 : 0)), ModCreativeModeTab.TESTMOD1_TAB);

    public static final RegistryObject<Block> GUMMOBERRY_CROP = BLOCKS.register("gummoberry_crop",
            () -> new GummoBerryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<LiquidBlock> SOAP_WATER_BLOCK = BLOCKS.register("soap_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_SOAP_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<Block> GUMMO_WORKSTATION = registerBlock("gummo_workstation",
            () -> new GummoWorkstationBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TESTMOD1_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){
            BLOCKS.register(eventBus);
    }

}
