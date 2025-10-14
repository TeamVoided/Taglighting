package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.JOHNNY_UNTARGETABLE;

@Mixin(NearestAttackableTargetGoal.class)
public abstract class JohnnyTargetGoalMixin extends TargetGoal {

    public JohnnyTargetGoalMixin(Mob mob, boolean bl) {
        super(mob, bl);
    }

    @ModifyExpressionValue(method = "findTarget", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/ai/goal/target/NearestAttackableTargetGoal;targetConditions:Lnet/minecraft/world/entity/ai/targeting/TargetingConditions;"))
    private TargetingConditions makeUntargetable(TargetingConditions original) {
        if (this.mob instanceof VindicatorAccessor vindicator && vindicator.taglighting_isJohnny()) {
            return original.copy().selector(living -> !living.getType().is(JOHNNY_UNTARGETABLE));
        }
        return original;
    }
}
