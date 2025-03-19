package org.teamvoided.taglighting.mixin.suports;

import net.minecraft.block.BlockState;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(NetherWartBlock.class)
public class NetherWartBlockMixin {
    @Inject(method = "canPlantOnTop", at = @At("RETURN"), cancellable = true)
    private void tagPlacementCheck(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(floor.isIn(TaglightingBlockTags.SUPPORTS_NETHER_WART));
    }
}
