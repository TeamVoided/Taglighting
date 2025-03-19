package org.teamvoided.taglighting.mixin.suports;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.RootsBlock;
import net.minecraft.block.SproutsBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin({RootsBlock.class, SproutsBlock.class})
public class NyliumPlantBlockMixin {
    @ModifyReturnValue(method = "canPlantOnTop", at = @At("RETURN"))
    private boolean tagPlacementCheck(boolean original, @Local(argsOnly = true) BlockState floor) {
        return floor.isIn(TaglightingBlockTags.SUPPORTS_NYLIUM_PLANTS);
    }
}
