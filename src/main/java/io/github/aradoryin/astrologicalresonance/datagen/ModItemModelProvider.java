package io.github.aradoryin.astrologicalresonance.datagen;

import io.github.aradoryin.astrologicalresonance.AstrologicalResonance;
import io.github.aradoryin.astrologicalresonance.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AstrologicalResonance.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.AMETHYST_CRYSTAL.get());
        basicItem(ModItems.CRYSTAL_DUST.get());
        basicItem(ModItems.RESONATING_CRYSTAL.get());
    }
}
