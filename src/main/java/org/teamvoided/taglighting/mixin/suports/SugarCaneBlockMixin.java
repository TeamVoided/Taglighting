package org.teamvoided.taglighting.mixin.suports;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;
import org.teamvoided.taglighting.data.tags.TaglightingFluidTags;

@Mixin(SugarCaneBlock.class)
abstract class SugarCaneBlockMixin {
    @ModifyExpressionValue(method = "canSurvive", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/tags/TagKey;)Z", ordinal = 0))
    private boolean tagPlacementCheck(boolean original, @Local(ordinal = 1) BlockState state) {
        return state.is(TaglightingBlockTags.SUPPORTS_SUGAR_CANE);
    }

    @ModifyExpressionValue(method = "canSurvive", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/tags/TagKey;)Z", ordinal = 1))
    private boolean secondCheckOverride(boolean original) {
        return false;
    }

    @ModifyExpressionValue(method = "canSurvive", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/material/FluidState;is(Lnet/minecraft/tags/TagKey;)Z"))
    private boolean hydrationFluidCheck(boolean original, @Local FluidState state) {
        return state.is(TaglightingFluidTags.SUGAR_CANE_HYDRATION);
    }

    @ModifyExpressionValue(method = "canSurvive", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", ordinal = 1))
    private boolean hydrationBlockCheck(boolean original, BlockState state, LevelReader world, @Local(ordinal = 1) BlockPos blockPos, @Local Direction dir) {
        return world.getBlockState(blockPos.relative(dir)).is(TaglightingBlockTags.SUGAR_CANE_HYDRATION);
    }
}
