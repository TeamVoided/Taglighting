package org.teamvoided.taglighting.mixin.suports;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.level.block.NetherSproutsBlock;
import net.minecraft.world.level.block.RootsBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin({RootsBlock.class, NetherSproutsBlock.class})
public class NyliumPlantBlockMixin {
    @ModifyReturnValue(method = "mayPlaceOn", at = @At("RETURN"))
    private boolean tagPlacementCheck(boolean original, @Local(argsOnly = true) BlockState floor) {
        return floor.is(TaglightingBlockTags.SUPPORTS_NYLIUM_PLANTS);
    }
}
