package org.teamvoided.taglighting.mixin.suports;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CocoaBlock;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;

@Mixin(CocoaBlock.class)
public class CocoaBlockMixin {
    @Redirect(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    boolean tagPlacementCheck(BlockState state, TagKey<Block> _tag) {
        return state.isIn(TaglightingBlockTags.SUPPORTS_COCOA);
    }
}
