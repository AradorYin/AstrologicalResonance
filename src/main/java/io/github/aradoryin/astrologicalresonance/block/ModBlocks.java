package io.github.aradoryin.astrologicalresonance.block;

import io.github.aradoryin.astrologicalresonance.AstrologicalResonance;
import io.github.aradoryin.astrologicalresonance.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    /**
     * The DeferredRegister for {@link Block}s.
     * This handles the registration of blocks under the {@link AstrologicalResonance#MOD_ID} namespace.
     */
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AstrologicalResonance.MOD_ID);

    /**
     * The storage block for the Amethyst Crystal. <p>
     * <B>Class:</B> {@link Block} <br>
     * <B>Properties:</b>
     * <ul>
     *     <li>Strength: 4.0</li>
     *     <li>Requires Correct Tool: Yes</li>
     *     <li>Sound: {@link SoundType#AMETHYST}</li>
     * </ul>
     */
    public static final DeferredBlock<Block> AMETHYST_CRYSTAL_BLOCK = registerBlock("amethyst_crystal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    /**
     * The storage block for Crystal Dust. <p>
     * <B>Class:</B> {@link Block} <br>
     * <B>Properties:</b>
     * <ul>
     *     <li>Strength: 4.0</li>
     *     <li>Requires Correct Tool: Yes</li>
     *     <li>Sound: {@link SoundType#AMETHYST}</li>
     * </ul>
     */
    public static final DeferredBlock<Block> CRYSTAL_DUST_BLOCK = registerBlock("crystal_dust_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    /**
     * The storage block for the Resonating Crystal. <p>
     * <B>Class:</B> {@link Block} <br>
     * <B>Properties:</b>
     * <ul>
     *     <li>Strength: 4.0</li>
     *     <li>Requires Correct Tool: Yes</li>
     *     <li>Sound: {@link SoundType#AMETHYST}</li>
     * </ul>
     */
    public static final DeferredBlock<Block> RESONATING_CRYSTAL_BLOCK = registerBlock("resonating_crystal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    private ModBlocks() {
    }

    /**
     * Registers a block and creates a corresponding {@link BlockItem}. <p>
     * This helper method simplifies registration by ensuring that whenever a block is added,
     * an item version of that block is automatically registered under the same name in {@link ModItems}.
     *
     * @param name  The registry name of the block (e.g., "amethyst_crystal_block").
     * @param block A supplier that returns the new {@link Block} instance.
     * @param <T>   The type of the block.
     * @return The {@link DeferredBlock} containing the registered block.
     */
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    /**
     * Registers a {@link BlockItem} for the given block using the {@link ModItems} registry.
     *
     * @param name  The registry name for the item (usually matches the block name).
     * @param block The {@link DeferredBlock} of the block to create an item for.
     * @param <T>   The type of the block.
     */
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    /**
     * Registers the block registry to the mod event bus.
     *
     * @param eventBus The {@link IEventBus} to register the blocks to.
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
