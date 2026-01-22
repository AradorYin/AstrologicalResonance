package io.github.aradoryin.astrologicalresonance.item;

import io.github.aradoryin.astrologicalresonance.AstrologicalResonance;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    /**
     * The DeferredRegister for {@link Item}s.
     * This handles the registration of items under the {@link AstrologicalResonance#MOD_ID} namespace.
     */
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AstrologicalResonance.MOD_ID);

    /**
     * The Amethyst Crystal item. <p>
     * <b>Class:</b> {@link Item} <br>
     * <b>Properties:</b>
     * <ul>
     *     <li>Stack Size: 64</li>
     * </ul>
     */
    public static final DeferredItem<Item> AMETHYST_CRYSTAL = ITEMS.register("amethyst_crystal", () -> new Item(new Item.Properties()));

    /**
     * The Crystal Dust item. <p>
     * <b>Class:</b> {@link Item} <br>
     * <b>Properties:</b>
     * <ul>
     *     <li>Stack Size: 64</li>
     * </ul>
     */
    public static final DeferredItem<Item> CRYSTAL_DUST = ITEMS.register("crystal_dust", () -> new Item(new Item.Properties()));

    /**
     * The Resonating Crystal item. <p>
     * <b>Class:</b> {@link Item} <br>
     * <b>Properties:</b>
     * <ul>
     *     <li>Stack Size: 64</li>
     * </ul>
     */
    public static final DeferredItem<Item> RESONATING_CRYSTAL = ITEMS.register("resonating_crystal", () -> new Item(new Item.Properties()));

    private ModItems() {
    }

    /**
     * Registers the item registry to the mod event bus.
     *
     * @param eventBus The {@link IEventBus} to register the items to.
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
