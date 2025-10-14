package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingPotionTags.MAKES_MUD;

@Mixin(PotionItem.class)
public class PotionItemMixin {

    @ModifyExpressionValue(method = "useOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/alchemy/PotionContents;is(Lnet/minecraft/core/Holder;)Z"))
    boolean overridePotionCheck(boolean original, @Local PotionContents contents) {
        return contents.potion().isPresent() && contents.potion().get().is(MAKES_MUD) && contents.customEffects().isEmpty();

    }
}
