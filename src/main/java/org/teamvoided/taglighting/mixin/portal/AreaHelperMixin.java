package org.teamvoided.taglighting.mixin.portal;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.dimension.AreaHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(AreaHelper.class)
public class AreaHelperMixin {
    @Inject(method = "method_30487", at = @At("RETURN"), cancellable = true)
    private static void tagPlacementCheck(BlockState state, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(state.isIn(TaglightingBlockTags.NETHER_PORTAL_FRAME));
    }
}
