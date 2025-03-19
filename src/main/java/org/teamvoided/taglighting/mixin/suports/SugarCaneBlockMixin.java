package org.teamvoided.taglighting.mixin.suports;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.fluid.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;
import org.teamvoided.taglighting.data.tags.TaglightingFluidTags;

@Mixin(SugarCaneBlock.class)
abstract class SugarCaneBlockMixin {
    @ModifyExpressionValue(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z", ordinal = 0))
    private boolean tagPlacementCheck(boolean original, @Local(ordinal = 1) BlockState state) {
        return state.isIn(TaglightingBlockTags.SUPPORTS_SUGAR_CANE);
    }

    @ModifyExpressionValue(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z", ordinal = 1))
    private boolean secondCheckOverride(boolean original) {
        return false;
    }

    @ModifyExpressionValue(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/FluidState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    private boolean hydrationFluidCheck(boolean original, @Local FluidState state) {
        return state.isIn(TaglightingFluidTags.SUGAR_CANE_HYDRATION);
    }

    @ModifyExpressionValue(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 1))
    private boolean hydrationBlockCheck(boolean original, @Local(ordinal = 2) BlockState state) {
        return state.isIn(TaglightingBlockTags.SUGAR_CANE_HYDRATION);
    }
}
