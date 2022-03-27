package yamahari.ilikewood.event;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.resource.PathResourcePack;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.IModPlugin;
import yamahari.ilikewood.config.ILikeWoodConfig;
import yamahari.ilikewood.util.Constants;
import yamahari.ilikewood.util.Util;

import java.io.IOException;

@Mod.EventBusSubscriber(value = {
    Dist.CLIENT,
    Dist.DEDICATED_SERVER
}, modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class AddPackFindersEventHandler {
    @SubscribeEvent
    public static void onAddPackFinders(final AddPackFindersEvent event) {
        for (final IModPlugin plugin : ILikeWood.PLUGINS) {
            final var modId = plugin.getModId();
            final var pluginModFile = ModList.get().getModFileById(plugin.getPluginModId()).getFile();
            ILikeWoodConfig.getAll().forEach(config -> {
                if (config.isEnabled()) {
                    final var resourcePath = pluginModFile.findResource(Util.toPath(Util.toRegistryName(
                        Constants.MOD_ID,
                        "resources"
                    ), config.name()));
                    final var pack = new PathResourcePack(
                        pluginModFile.getFileName() + ":" + resourcePath,
                        resourcePath
                    );
                    final PackMetadataSection metaDataSection;
                    try {
                        metaDataSection = pack.getMetadataSection(PackMetadataSection.SERIALIZER);
                    }
                    catch (final IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (metaDataSection != null) {
                        event.addRepositorySource((consumer, constructor) -> consumer.accept(constructor.create(
                            String.format(
                                "%s:%s-%s",
                                Constants.MOD_ID,
                                config.name(),
                                modId
                            ),
                            new TextComponent(String.format(
                                "%s - %s - %s resources",
                                Constants.MOD_ID,
                                config.name(),
                                modId
                            )),
                            true,
                            () -> pack,
                            metaDataSection,
                            Pack.Position.BOTTOM,
                            PackSource.BUILT_IN,
                            true
                        )));
                    }
                }
            });
        }
    }
}