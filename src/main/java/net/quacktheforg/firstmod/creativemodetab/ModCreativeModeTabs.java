package net.quacktheforg.firstmod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.quacktheforg.firstmod.FirstMod;
import net.quacktheforg.firstmod.item.ModItems;

public class ModCreativeModeTabs {
    public static final CreativeModeTab RUBY_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, "ruby_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY))
                    .title(Component.translatable("creativemodetab.first-mod.ruby_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RUBY);

                    }).build());

    public static void registerCreativeModeTabs() {
        FirstMod.LOGGER.info("Registering Creative Mode Tabs for" + FirstMod.MOD_ID);
    }
}
