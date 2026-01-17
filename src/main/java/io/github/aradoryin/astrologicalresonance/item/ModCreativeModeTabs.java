package io.github.aradoryin.astrologicalresonance.item;

import io.github.aradoryin.astrologicalresonance.AstrologicalResonance;
import io.github.aradoryin.astrologicalresonance.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    /**
     * The DeferredRegister for {@link CreativeModeTab}s.
     * This handles the registration of creative mode tabs under the {@link AstrologicalResonance#MOD_ID} namespace.
     */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AstrologicalResonance.MOD_ID);

    public static final Supplier<CreativeModeTab> ASTROLOGICAL_RESONANCE_TAB = CREATIVE_MOD_TABS.register("astrological_resonance_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AMETHYST_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.astrologicalresonance.astrological_resonance"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.AMETHYST_CRYSTAL);
                        output.accept(ModBlocks.AMETHYST_CRYSTAL_BLOCK);
                        output.accept(ModItems.CRYSTAL_DUST);
                        output.accept(ModBlocks.CRYSTAL_DUST_BLOCK);
                        output.accept(ModItems.RESONATING_CRYSTAL);
                        output.accept(ModBlocks.RESONATING_CRYSTAL_BLOCK);
                    }))
                    .build());

    private ModCreativeModeTabs() {}

    /**
     * Registers the creative mode tab registry to the mod event bus.
     *
     * @param eventBus The {@link IEventBus} to register the creative mode tabs to.
     */
    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
