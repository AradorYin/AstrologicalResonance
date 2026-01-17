package io.github.aradoryin.astrologicalresonance.block;

import io.github.aradoryin.astrologicalresonance.AstrologicalResonance;
import io.github.aradoryin.astrologicalresonance.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModBlocks {
    /**
     * The DeferredRegister for {@link Block}s.
     * This handles the registration of blocks under the {@link AstrologicalResonance#MOD_ID} namespace.
     */
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AstrologicalResonance.MOD_ID);

    public static final DeferredBlock<Block> AMETHYST_CRYSTAL_BLOCK = registerBlock("amethyst_crystal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> CRYSTAL_DUST_BLOCK = registerBlock("crystal_dust_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> RESONATING_CRYSTAL_BLOCK = registerBlock("resonating_crystal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private  static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private ModBlocks() {}

    /**
     * Registers the block registry to the mod event bus.
     *
     * @param eventBus The {@link IEventBus} to register the blocks to.
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
