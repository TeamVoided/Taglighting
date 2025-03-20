package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.pattern.CachedBlockPosition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Predicate;

import static org.teamvoided.taglighting.data.tags.TaglightingBlockTags.IRON_GOLEM_BASE;
import static org.teamvoided.taglighting.data.tags.TaglightingBlockTags.SNOW_GOLEM_BASE;

@Mixin(CarvedPumpkinBlock.class)
public class SpawnGolemMixin {
    @ModifyExpressionValue(method = "getSnowGolemDispenserPattern", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/pattern/CachedBlockPosition;matchesBlockState(Ljava/util/function/Predicate;)Ljava/util/function/Predicate;"))
    Predicate<CachedBlockPosition> snowGolemDispenser(Predicate<CachedBlockPosition> original) {
        return CachedBlockPosition.matchesBlockState((state) -> state.isIn(SNOW_GOLEM_BASE));
    }

    @ModifyExpressionValue(method = "getSnowGolemPattern", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/pattern/CachedBlockPosition;matchesBlockState(Ljava/util/function/Predicate;)Ljava/util/function/Predicate;", ordinal = 1))
    Predicate<CachedBlockPosition> snowGolem(Predicate<CachedBlockPosition> original) {
        return CachedBlockPosition.matchesBlockState((state) -> state.isIn(SNOW_GOLEM_BASE));
    }

    @ModifyExpressionValue(method = "getIronGolemDispenserPattern", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/pattern/CachedBlockPosition;matchesBlockState(Ljava/util/function/Predicate;)Ljava/util/function/Predicate;"))
    Predicate<CachedBlockPosition> ironGolemDispenser(Predicate<CachedBlockPosition> original) {
        return CachedBlockPosition.matchesBlockState((state) -> state.isIn(IRON_GOLEM_BASE));
    }

    @ModifyExpressionValue(method = "getIronGolemPattern", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/pattern/CachedBlockPosition;matchesBlockState(Ljava/util/function/Predicate;)Ljava/util/function/Predicate;", ordinal = 1))
    Predicate<CachedBlockPosition> ironGolem(Predicate<CachedBlockPosition> original) {
        return CachedBlockPosition.matchesBlockState((state) -> state.isIn(IRON_GOLEM_BASE));
    }

}
