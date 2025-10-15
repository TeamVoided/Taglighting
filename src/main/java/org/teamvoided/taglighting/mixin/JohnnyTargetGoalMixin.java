package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.JOHNNY_UNTARGETABLE;

@Mixin(targets = "net.minecraft.world.entity.monster.Vindicator.VindicatorJohnnyAttackGoal")
public abstract class JohnnyTargetGoalMixin {
    @ModifyReturnValue(method = "method_64467", at = @At("RETURN"))
    private static boolean makeUntargetable(boolean original, LivingEntity entity) {
        return original && entity.getType().is(JOHNNY_UNTARGETABLE);
    }
}
