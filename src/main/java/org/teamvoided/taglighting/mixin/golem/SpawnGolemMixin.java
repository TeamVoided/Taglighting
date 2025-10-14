package org.teamvoided.taglighting.mixin.golem;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Predicate;

import static org.teamvoided.taglighting.data.tags.TaglightingBlockTags.IRON_GOLEM_BASE;
import static org.teamvoided.taglighting.data.tags.TaglightingBlockTags.SNOW_GOLEM_BASE;

@Mixin(CarvedPumpkinBlock.class)
public class SpawnGolemMixin {
    @ModifyExpressionValue(method = "getOrCreateSnowGolemBase", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/pattern/BlockInWorld;hasState(Ljava/util/function/Predicate;)Ljava/util/function/Predicate;"))
    Predicate<BlockInWorld> snowGolemDispenser(Predicate<BlockInWorld> original) {
        return BlockInWorld.hasState((state) -> state.is(SNOW_GOLEM_BASE));
    }

    @ModifyExpressionValue(method = "getOrCreateSnowGolemFull", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/pattern/BlockInWorld;hasState(Ljava/util/function/Predicate;)Ljava/util/function/Predicate;", ordinal = 1))
    Predicate<BlockInWorld> snowGolem(Predicate<BlockInWorld> original) {
        return BlockInWorld.hasState((state) -> state.is(SNOW_GOLEM_BASE));
    }

    @ModifyExpressionValue(method = "getOrCreateIronGolemBase", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/pattern/BlockInWorld;hasState(Ljava/util/function/Predicate;)Ljava/util/function/Predicate;"))
    Predicate<BlockInWorld> ironGolemDispenser(Predicate<BlockInWorld> original) {
        return BlockInWorld.hasState((state) -> state.is(IRON_GOLEM_BASE));
    }

    @ModifyExpressionValue(method = "getOrCreateIronGolemFull", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/pattern/BlockInWorld;hasState(Ljava/util/function/Predicate;)Ljava/util/function/Predicate;", ordinal = 1))
    Predicate<BlockInWorld> ironGolem(Predicate<BlockInWorld> original) {
        return BlockInWorld.hasState((state) -> state.is(IRON_GOLEM_BASE));
    }

}
