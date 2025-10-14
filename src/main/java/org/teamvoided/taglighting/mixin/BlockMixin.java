package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingBlockTags.CANNOT_CONNECT_TO;

@Mixin(Block.class)
public class BlockMixin {
    @ModifyReturnValue(method = "isExceptionForConnection", at = @At("RETURN"))
    private static boolean modifyCannotConnect(boolean original, BlockState state) {
        return state.is(CANNOT_CONNECT_TO);
    }
}
