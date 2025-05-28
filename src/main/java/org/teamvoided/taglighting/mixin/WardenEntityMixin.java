package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.warden.WardenEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.WARDEN_UNTARGETABLE;

@Mixin(WardenEntity.class)
public class WardenEntityMixin {

    @ModifyReturnValue(method = "isEnemy", at = @At("RETURN"))
    boolean makeUntargetable(boolean original, Entity entity) {
        if (entity instanceof LivingEntity living && living.getType().isIn(WARDEN_UNTARGETABLE)) {
            return false;
        }
        return original;
    }

    @ModifyExpressionValue(method = "isEnemy", at= @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getType()Lnet/minecraft/entity/EntityType;"))
    EntityType<?> preventVanilla(EntityType<?> original){
        return null;
    }
}
