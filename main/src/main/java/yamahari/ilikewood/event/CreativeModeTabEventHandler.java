package yamahari.ilikewood.event;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.config.ILikeWoodConfig;
import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.registry.objecttype.WoodenItemType;
import yamahari.ilikewood.registry.objecttype.WoodenTieredItemType;
import yamahari.ilikewood.util.Constants;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class CreativeModeTabEventHandler
{
    @SubscribeEvent
    public static void onCreativeModeTabEventBuildContentsHandler(final CreativeModeTabEvent.BuildContents event)
    {
        final CreativeModeTab tab = event.getTab();
        if (tab == CreativeModeTabs.COMBAT) {
            ILikeWood.ITEM_REGISTRY.getRegistryObjects(WoodenItemType.BOW).forEach(event::accept);
            ILikeWood.ITEM_REGISTRY.getRegistryObjects(WoodenItemType.CROSSBOW).forEach(event::accept);

            ILikeWood.TIERED_ITEM_REGISTRY.getRegistryObjects(WoodenTieredItemType.SWORD).forEach(event::accept);
            ILikeWood.TIERED_ITEM_REGISTRY.getRegistryObjects(WoodenTieredItemType.AXE).forEach(event::accept);
        } else if (tab == CreativeModeTabs.INGREDIENTS) {
            ILikeWood.ITEM_REGISTRY.getRegistryObjects(WoodenItemType.STICK).forEach(event::accept);
        } else if (tab == CreativeModeTabs.REDSTONE_BLOCKS) {
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.CHEST).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.COMPOSTER).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.LECTERN).forEach(event::accept);
        } else if (tab == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            WoodenBlockType.getBeds()
                .flatMap(ILikeWood.BLOCK_ITEM_REGISTRY::getRegistryObjects)
                .forEach(event::accept);

            ILikeWood.ITEM_REGISTRY.getRegistryObjects(WoodenItemType.ITEM_FRAME).forEach(event::accept);
            ILikeWood.ITEM_REGISTRY.getRegistryObjects(WoodenItemType.PAINTING).forEach(event::accept);

            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.CHEST).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.SCAFFOLDING).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.CAMPFIRE).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.SOUL_CAMPFIRE).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.LADDER).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.CRAFTING_TABLE).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.BOOKSHELF).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.COMPOSTER).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.LECTERN).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.TORCH).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.SOUL_TORCH).forEach(event::accept);
        } else if (tab == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            ILikeWood.ITEM_REGISTRY.getRegistryObjects(WoodenItemType.FISHING_ROD).forEach(event::accept);

            ILikeWood.TIERED_ITEM_REGISTRY.getRegistryObjects(WoodenTieredItemType.HOE).forEach(event::accept);
            ILikeWood.TIERED_ITEM_REGISTRY.getRegistryObjects(WoodenTieredItemType.AXE).forEach(event::accept);
            ILikeWood.TIERED_ITEM_REGISTRY.getRegistryObjects(WoodenTieredItemType.PICKAXE).forEach(event::accept);
            ILikeWood.TIERED_ITEM_REGISTRY.getRegistryObjects(WoodenTieredItemType.SHOVEL).forEach(event::accept);
        } else if (tab == CreativeModeTabs.BUILDING_BLOCKS) {
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.WALL).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.PANELS).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.PANELS_STAIRS).forEach(event::accept);
            ILikeWood.BLOCK_ITEM_REGISTRY.getRegistryObjects(WoodenBlockType.PANELS_SLAB).forEach(event::accept);
        }
    }
}
