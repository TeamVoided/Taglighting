package org.teamvoided.taglighting.mixin.portal;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
    @WrapOperation(method = "shouldLightPortalAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private static boolean tagPlacementCheck(BlockState instance, Block block, Operation<Boolean> original) {
        return instance.isIn(TaglightingBlockTags.NETHER_PORTAL_FRAME);
    }
}
