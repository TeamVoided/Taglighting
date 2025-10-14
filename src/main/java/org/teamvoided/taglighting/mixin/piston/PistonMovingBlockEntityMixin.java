package org.teamvoided.taglighting.mixin.piston;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.level.block.piston.PistonMovingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(PistonMovingBlockEntity.class)
public class PistonMovingBlockEntityMixin {
    @Shadow
    private BlockState movedState;

    @ModifyReturnValue(method = "isStickyForEntities", at = @At("RETURN"))
    boolean tagCheck(boolean original) {
        return this.movedState.is(TaglightingBlockTags.MOB_MOVING_STICKY_BLOCK);
    }

    @ModifyExpressionValue(method = "moveCollidedEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"))
    private static boolean isNonEntityMoving(boolean original, @Local(argsOnly = true) PistonMovingBlockEntity entity) {
        var state = entity.getMovedState();
        return state.is(TaglightingBlockTags.UNIQUE_STICKY_BLOCK) && !state.is(TaglightingBlockTags.MOB_MOVING_STICKY_BLOCK);
    }
}
