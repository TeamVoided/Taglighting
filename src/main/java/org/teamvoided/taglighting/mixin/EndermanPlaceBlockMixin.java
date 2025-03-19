package org.teamvoided.taglighting.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(EndermanEntity.PlaceBlockGoal.class)
public class EndermanPlaceBlockMixin {
    @Inject(method = "canPlaceOn", at = @At("RETURN"), cancellable = true)
    void tagPlacementCheck(World world, BlockPos posAbove, BlockState carriedState, BlockState stateAbove, BlockState state, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) cir.setReturnValue(carriedState.isIn(TaglightingBlockTags.ENDERMAN_PLACEABLE));
    }
}
