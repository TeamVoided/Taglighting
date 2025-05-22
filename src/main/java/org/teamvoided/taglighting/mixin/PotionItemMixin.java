package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.PotionItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingPotionTags.MAKES_MUD;

@Mixin(PotionItem.class)
public class PotionItemMixin {

    @ModifyExpressionValue(method = "useOnBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/component/type/PotionContentsComponent;matches(Lnet/minecraft/registry/Holder;)Z"))
    boolean overridePotionCheck(boolean original, @Local PotionContentsComponent contents) {
        return contents.potion().isPresent() && contents.potion().get().isIn(MAKES_MUD) && contents.customEffects().isEmpty();

    }
}
