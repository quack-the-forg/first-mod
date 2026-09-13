package net.quacktheforg.firstmod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.quacktheforg.firstmod.FirstMod;
import net.quacktheforg.firstmod.item.ModItems;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final CreativeModeTab RUBY_ITEM_TAB = registerTab(
            "ruby_items",
            () -> new ItemStack(ModItems.RUBY),
            output -> output.accept(ModItems.RUBY)
    );

    private static CreativeModeTab registerTab(
            String name,
            Supplier<ItemStack> icon,
            Consumer<CreativeModeTab.Output> items
    ) {
        ResourceKey<CreativeModeTab> key = ResourceKey.create(
                BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, name)
        );

        CreativeModeTab tab = FabricCreativeModeTab.builder()
                .icon(icon)
                .title(Component.translatable(
                        "creativemodetab." + FirstMod.MOD_ID + "." + name
                ))
                .displayItems((parameters, output) -> items.accept(output))
                .build();

        return Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                key,
                tab
        );
    }

    public static void registerCreativeModeTabs() {
        FirstMod.LOGGER.info("Registering Creative Mode Tabs for " + FirstMod.MOD_ID);
    }
}
