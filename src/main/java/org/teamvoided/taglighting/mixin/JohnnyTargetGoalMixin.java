package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.JOHNNY_UNTARGETABLE;

@Mixin(TargetGoal.class)
public abstract class JohnnyTargetGoalMixin extends TrackTargetGoal {
    public JohnnyTargetGoalMixin(MobEntity mob, boolean checkVisibility) {
        super(mob, checkVisibility);
    }

    @ModifyExpressionValue(method = "findClosestTarget", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/ai/goal/TargetGoal;targetPredicate:Lnet/minecraft/entity/ai/TargetPredicate;"))
    private TargetPredicate makeUntargetable(TargetPredicate original) {
        if (this.mob instanceof VindicatorEntityAccessor vindicator && vindicator.taglighting_johnny()) {
            return TargetPredicate.createAttackable().setBaseMaxDistance(this.getFollowRange()).setPredicate(living -> !living.getType().isIn(JOHNNY_UNTARGETABLE));
        }
        return original;
    }
}
