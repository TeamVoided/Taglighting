package org.teamvoided.taglighting.mixin.suports;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherWartBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(NetherWartBlock.class)
public class NetherWartBlockMixin {
    @ModifyReturnValue(method = "canPlantOnTop", at = @At("RETURN"))
    private boolean tagPlacementCheck(boolean original, @Local(argsOnly = true) BlockState floor) {
        return floor.isIn(TaglightingBlockTags.SUPPORTS_NETHER_WART);
    }
}
