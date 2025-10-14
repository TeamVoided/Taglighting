package org.teamvoided.taglighting.mixin.portal;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.PortalShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(PortalShape.class)
public class AreaHelperMixin {
    @ModifyReturnValue(method = "method_30487", at = @At("RETURN"))
    private static boolean tagPlacementCheck(boolean original, BlockState state) {
        return state.is(TaglightingBlockTags.NETHER_PORTAL_FRAME);
    }
}
