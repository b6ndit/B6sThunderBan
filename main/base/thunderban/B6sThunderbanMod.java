package main.base.thunderban;

import main.base.thunderban.event.PlayerBannedEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.class_1299;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_3730;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class B6sThunderbanMod implements ModInitializer {
   public static final Logger LOGGER = LoggerFactory.getLogger("B6's Thunderban");

   public void onInitialize() {
      LOGGER.info("Initializing B6's Thunderban... (Version: {})", ((ModContainer)FabricLoader.getInstance().getModContainer("b6s-thunderban").orElseThrow(NullPointerException::new)).getMetadata().getVersion().getFriendlyString());
      PlayerBannedEvent.EVENT.register((bannedPlayer, world) -> {
         class_1299.field_6112.method_5899(world, (class_2487)null, (class_2561)null, bannedPlayer, bannedPlayer.method_24515(), class_3730.field_16461, true, false);
      });
   }
}
