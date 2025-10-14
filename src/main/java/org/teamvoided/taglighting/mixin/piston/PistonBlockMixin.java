package org.teamvoided.taglighting.mixin.piston;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(PistonBaseBlock.class)
public class PistonBlockMixin {
    @ModifyExpressionValue(method = "isPushable", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", ordinal = 0))
    private static boolean tagMoveCheck(boolean original, @Local(argsOnly = true) BlockState state) {
        return state.is(TaglightingBlockTags.PISTON_IMMOVABLE);
    }

    @ModifyExpressionValue(method = "isPushable", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", ordinal = 1))
    private static boolean overrideMoveOne(boolean original) {
        return false;
    }

    @ModifyExpressionValue(method = "isPushable", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", ordinal = 2))
    private static boolean overrideMoveTwo(boolean original) {
        return false;
    }

    @ModifyExpressionValue(method = "isPushable", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", ordinal = 3))
    private static boolean overrideMoveThree(boolean original) {
        return false;
    }
}
