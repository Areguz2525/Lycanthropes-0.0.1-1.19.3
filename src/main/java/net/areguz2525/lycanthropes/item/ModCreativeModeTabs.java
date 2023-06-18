package net.areguz2525.lycanthropes.item;

import net.areguz2525.lycanthropes.Lycanthropes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Lycanthropes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab LYCANTHROPES_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        LYCANTHROPES_TAB = event.registerCreativeModeTab(new ResourceLocation(Lycanthropes.MOD_ID, "lycanthropes_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.SILVER_INGOT.get()))
                        .title(Component.translatable("creativemodetab.lycanthropes_tab")));
    }
}