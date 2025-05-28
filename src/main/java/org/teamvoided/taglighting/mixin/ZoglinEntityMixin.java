package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZoglinEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.ZOGLIN_UNTARGETABLE;

@Mixin(ZoglinEntity.class)
public class ZoglinEntityMixin {

    @ModifyReturnValue(method = "shouldAttack", at = @At("RETURN"))
    boolean makeUntargetable(boolean original, LivingEntity target) {
        if (target.getType().isIn(ZOGLIN_UNTARGETABLE)) {
            return false;
        }
        return original;
    }

    @ModifyExpressionValue(method = "shouldAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getType()Lnet/minecraft/entity/EntityType;"))
    EntityType<?> preventVanilla(EntityType<?> original) {
        return null;
    }
}
