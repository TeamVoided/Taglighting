package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(targets = "net.minecraft.entity.mob.EndermanEntity.PlaceBlockGoal")
public class EndermanPlaceBlockMixin {
    @ModifyReturnValue(method = "canPlaceOn", at = @At("RETURN"))
    boolean tagPlacementCheck(boolean original, @Local(argsOnly = true, ordinal = 0) BlockState carriedState) {
        return original && carriedState.isIn(TaglightingBlockTags.ENDERMAN_PLACEABLE);
    }
}
