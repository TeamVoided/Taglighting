package org.teamvoided.taglighting.mixin.piston;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(PistonStructureResolver.class)
public abstract class PistonHandlerMixin {
    @Shadow
    private static boolean isSticky(BlockState blockState) {
        throw new UnsupportedOperationException("Mixin did not apply!");
    }

    @ModifyReturnValue(method = "isSticky", at = @At("RETURN"))
    private static boolean isUniqueStickBlock(boolean original, BlockState state) {
        return state.is(TaglightingBlockTags.UNIQUE_STICKY_BLOCK);
    }

    @ModifyReturnValue(method = "canStickToEachOther", at = @At("RETURN"))
    private static boolean isAdjacentBlockStuck(boolean original, BlockState state, BlockState adjacentState) {
        return !(isSticky(state) && (state != adjacentState && isSticky(adjacentState)));
    }
}
