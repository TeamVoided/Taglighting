package org.teamvoided.taglighting.mixin.portal;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
    @Redirect(method = "shouldLightPortalAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private static boolean tagPlacementCheck(BlockState instance, Block block) {
        return instance.isIn(TaglightingBlockTags.NETHER_PORTAL_FRAME);
    }
}
