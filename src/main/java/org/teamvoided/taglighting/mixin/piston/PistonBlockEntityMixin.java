package org.teamvoided.taglighting.mixin.piston;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.PistonBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(PistonBlockEntity.class)
public class PistonBlockEntityMixin {
    @Shadow
    private BlockState movedState;

    @ModifyReturnValue(method = "isMovingHoneyBlock", at = @At("RETURN"))
    boolean tagCheck(boolean original) {
        return this.movedState.isIn(TaglightingBlockTags.MOB_MOVING_STICKY_BLOCK);
    }

    @ModifyExpressionValue(method = "pushEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private static boolean isNonEntityMoving(boolean original, @Local(argsOnly = true) PistonBlockEntity entity) {
        var state = entity.getMovedBlockState();
        return state.isIn(TaglightingBlockTags.UNIQUE_STICKY_BLOCK) && !state.isIn(TaglightingBlockTags.MOB_MOVING_STICKY_BLOCK);
    }
}
