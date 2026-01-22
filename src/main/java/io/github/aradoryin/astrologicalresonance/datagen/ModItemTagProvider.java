package io.github.aradoryin.astrologicalresonance.datagen;

import io.github.aradoryin.astrologicalresonance.AstrologicalResonance;
import io.github.aradoryin.astrologicalresonance.item.ModItems;
import io.github.aradoryin.astrologicalresonance.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, AstrologicalResonance.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_CRYSTALS)
                .add(ModItems.AMETHYST_CRYSTAL.get(),
                        Items.AMETHYST_SHARD);
    }
}
