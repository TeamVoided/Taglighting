package org.teamvoided.taglighting.mixin.suports.special;

import net.minecraft.block.Block;
import net.minecraft.block.WallMountedBlock;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(WallMountedBlock.class)
abstract class WallMountedBlockMixin {
    @Inject(method = "canPlaceAt(Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;)Z", at = @At("RETURN"), cancellable = true)
    private static void tagPlacementCheck(WorldView world, BlockPos pos, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            TagKey<Block> tag = switch (direction) {
                case DOWN -> TaglightingBlockTags.SUPPORTS_SMALL_TOP;
                case UP -> TaglightingBlockTags.SUPPORTS_SMALL_BOTTOM;
                default -> TaglightingBlockTags.SUPPORTS_SMALL_SIDES;
            };
            cir.setReturnValue(world.getBlockState(pos.offset(direction)).isIn(tag));
        }
    }
}
