package main.base.thunderban.mixin;

import com.mojang.authlib.GameProfile;
import java.util.Collection;
import java.util.Iterator;
import main.base.thunderban.event.PlayerBannedEvent;
import net.minecraft.class_2168;
import net.minecraft.class_2561;
import net.minecraft.class_3016;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_3016.class})
public class BanCommandMixin {
   @Inject(
      method = {"ban"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/server/command/ServerCommandSource;sendFeedback(Lnet/minecraft/text/Text;Z)V",
   shift = Shift.AFTER
)}
   )
   private static void invokePlayerBannedEvent(class_2168 source, Collection<GameProfile> targets, class_2561 reason, CallbackInfoReturnable<Integer> cir) {
      Iterator var4 = targets.iterator();

      while(var4.hasNext()) {
         GameProfile gameProfile = (GameProfile)var4.next();
         ((PlayerBannedEvent)PlayerBannedEvent.EVENT.invoker()).onPlayerBan(source.method_9211().method_3760().method_14602(gameProfile.getId()), source.method_9225());
      }

   }
}
