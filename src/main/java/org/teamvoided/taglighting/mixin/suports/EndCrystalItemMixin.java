package org.teamvoided.taglighting.mixin.suports;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.item.EndCrystalItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(EndCrystalItem.class)
public class EndCrystalItemMixin {
    @ModifyExpressionValue(method = "useOnBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 0))
    private boolean tagPlacementCheck(boolean original, @Local BlockState state) {
        return state.isIn(TaglightingBlockTags.SUPPORTS_END_CRYSTAL);
    }

    @ModifyExpressionValue(method = "useOnBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 1))
    private boolean checkOverride(boolean original) {
        return false;
    }
}
