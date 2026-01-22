package io.github.aradoryin.astrologicalresonance.datagen;

import io.github.aradoryin.astrologicalresonance.block.ModBlocks;
import io.github.aradoryin.astrologicalresonance.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    /**
     * Generates a pair of recipes for converting between an item and its storage block. <p>
     * This helper creates:
     * <ul>
     *     <li>A <b>Shaped Recipe</b> to compress 9 {@code unpackedItem}s into 1 {@code packedItem} (3x3 grid).</li>
     *     <li>A <b>Shapeless Recipe</b> to decompress 1 {@code packedItem} back into 9 {@code unpackedItem}s.</li>
     * </ul>
     *
     * @param recipeOutput The {@link RecipeOutput} to save the recipes to.
     * @param unpackedItem The individual item (e.g., an ingot or gem).
     * @param packedItem   The storage block representation of the item.
     */
    protected static void nineBlockStorageRecipes(RecipeOutput recipeOutput, ItemLike unpackedItem, ItemLike packedItem) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, unpackedItem, 9)
                .requires(packedItem)
                .group(unpackedItem.toString())
                .unlockedBy(getHasName(packedItem), has(packedItem))
                .save(recipeOutput); // .save(recipeOutput, ResourceLocation.parse(unpackedName));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, packedItem)
                .define('#', unpackedItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(packedItem.toString())
                .unlockedBy(getHasName(unpackedItem), has(unpackedItem))
                .save(recipeOutput); // .save(recipeOutput, ResourceLocation.parse(packedName));
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        nineBlockStorageRecipes(recipeOutput, ModItems.AMETHYST_CRYSTAL, ModBlocks.AMETHYST_CRYSTAL_BLOCK);
        nineBlockStorageRecipes(recipeOutput, ModItems.CRYSTAL_DUST, ModBlocks.CRYSTAL_DUST_BLOCK);
        nineBlockStorageRecipes(recipeOutput, ModItems.RESONATING_CRYSTAL, ModBlocks.RESONATING_CRYSTAL_BLOCK);

        oreSmelting(recipeOutput, List.of(ModItems.AMETHYST_CRYSTAL.get()), RecipeCategory.MISC,
                ModItems.RESONATING_CRYSTAL.get(), 0.7f, 200, "amethyst_crystal");
        oreBlasting(recipeOutput, List.of(ModItems.AMETHYST_CRYSTAL.get()), RecipeCategory.MISC,
                ModItems.RESONATING_CRYSTAL.get(), 0.7f, 100, "amethyst_crystal");
        oreSmelting(recipeOutput, List.of(Items.AMETHYST_SHARD), RecipeCategory.MISC,
                ModItems.AMETHYST_CRYSTAL.get(), 0.7f, 200, "amethyst_shard");
        oreBlasting(recipeOutput, List.of(Items.AMETHYST_SHARD), RecipeCategory.MISC,
                ModItems.AMETHYST_CRYSTAL.get(), 0.7f, 100, "amethyst_shard");
    }
}
