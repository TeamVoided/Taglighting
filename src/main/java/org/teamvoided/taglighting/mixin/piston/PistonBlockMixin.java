package org.teamvoided.taglighting.mixin.piston;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(PistonBlock.class)
public class PistonBlockMixin {

    @Redirect(method = "isMovable", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 0))
    private static boolean tagMoveCheck(BlockState state, Block _block) {
        return state.isIn(TaglightingBlockTags.PISTON_IMMOVABLE);
    }

    @Redirect(method = "isMovable", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 1))
    private static boolean overrideMoveOne(BlockState state, Block _block) {
        return false;
    }

    @Redirect(method = "isMovable", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 2))
    private static boolean overrideMoveTwo(BlockState state, Block _block) {
        return false;
    }

    @Redirect(method = "isMovable", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 3))
    private static boolean overrideMoveThree(BlockState state, Block _block) {
        return false;
    }
}
