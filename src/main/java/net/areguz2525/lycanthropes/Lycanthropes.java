package net.areguz2525.lycanthropes;

import com.mojang.logging.LogUtils;
import net.areguz2525.lycanthropes.block.ModBlocks;
import net.areguz2525.lycanthropes.item.ModCreativeModeTabs;
import net.areguz2525.lycanthropes.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Lycanthropes.MOD_ID)
public class Lycanthropes {
    public static final String MOD_ID = "lycanthropes";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Very Important Comment
    public Lycanthropes() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {

        if(event.getTab() == ModCreativeModeTabs.LYCANTHROPES_TAB) {
            event.accept(ModItems.RAW_SILVER);
            event.accept(ModItems.SILVER_INGOT);

            event.accept(ModBlocks.RAW_SILVER_BLOCK);
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModBlocks.SMOOTH_SILVER_BLOCK);
            event.accept(ModBlocks.SILVER_ORE);
            event.accept(ModBlocks.DEEPSLATE_SILVER_ORE);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}