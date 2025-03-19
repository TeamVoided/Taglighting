package org.teamvoided.taglighting.mixin.piston;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(PistonHandler.class)
public class PistonHandlerMixin {
    @Shadow
    private static boolean isBlockSticky(BlockState state) {
        throw new UnsupportedOperationException("Mixin did not apply!");
    }

    @ModifyReturnValue(method = "isBlockSticky ", at = @At("RETURN"))
    private static boolean isUniqueStickBlock(boolean original, BlockState state) {
        return state.isIn(TaglightingBlockTags.UNIQUE_STICKY_BLOCK);
    }

    @ModifyReturnValue(method = "isAdjacentBlockStuck", at = @At("RETURN"))
    private static boolean isAdjacentBlockStuck(boolean original, BlockState state, BlockState adjacentState) {
        return !(isBlockSticky(state) && (state != adjacentState && isBlockSticky(adjacentState)));
    }
}
