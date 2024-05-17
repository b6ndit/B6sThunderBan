package main.base.thunderban.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.class_3218;
import net.minecraft.class_3222;

public interface PlayerBannedEvent {
   Event<PlayerBannedEvent> EVENT = EventFactory.createArrayBacked(PlayerBannedEvent.class, (listeners) -> {
      return (bannedPlayer, world) -> {
         PlayerBannedEvent[] var3 = listeners;
         int var4 = listeners.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            PlayerBannedEvent playerBannedEventListener = var3[var5];
            playerBannedEventListener.onPlayerBan(bannedPlayer, world);
         }

      };
   });

   void onPlayerBan(class_3222 var1, class_3218 var2);
}
