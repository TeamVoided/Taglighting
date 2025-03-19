package org.teamvoided.taglighting.mixin.suports;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags;
import org.teamvoided.taglighting.data.tags.TaglightingFluidTags;

@Mixin(SugarCaneBlock.class)
abstract class SugarCaneBlockMixin {
    @Redirect(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z", ordinal = 0))
    private boolean tagPlacementCheck(BlockState state, TagKey<Block> _tag) {
        return state.isIn(TaglightingBlockTags.SUPPORTS_SUGAR_CANE);
    }

    @Redirect(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z", ordinal = 1))
    private boolean secondCheckOverride(BlockState state, TagKey<Block> _tag) {
        return false;
    }

    @Redirect(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/FluidState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    private boolean hydrationFluidCheck(FluidState state, TagKey<Fluid> _tag) {
        return state.isIn(TaglightingFluidTags.SUGAR_CANE_HYDRATION);
    }

    @Redirect(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 1))
    private boolean hydrationBlockCheck(BlockState state, Block _block) {
        return state.isIn(TaglightingBlockTags.SUGAR_CANE_HYDRATION);
    }
}
