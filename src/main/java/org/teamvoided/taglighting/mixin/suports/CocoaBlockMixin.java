package org.teamvoided.taglighting.mixin.suports;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.CocoaBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(CocoaBlock.class)
public class CocoaBlockMixin {
    @ModifyExpressionValue(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    boolean tagPlacementCheck(boolean original, @Local(ordinal = 1) BlockState state) {
        return state.isIn(TaglightingBlockTags.SUPPORTS_COCOA);
    }
}
