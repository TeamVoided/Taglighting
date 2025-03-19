package org.teamvoided.taglighting.mixin.suports;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.WitherRoseBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(WitherRoseBlock.class)
abstract class WitherRoseBlockMixin {
    @ModifyReturnValue(method = "canPlantOnTop", at = @At("RETURN"))
    boolean tagPlacementCheck(boolean original, @Local(argsOnly = true) BlockState floor) {
        return floor.isIn(TaglightingBlockTags.SUPPORTS_WITHER_ROSE);
    }
}
