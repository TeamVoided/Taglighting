package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.warden.Warden;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.WARDEN_UNTARGETABLE;

@Mixin(Warden.class)
public class WardenEntityMixin {

    @ModifyReturnValue(method = "canTargetEntity", at = @At("RETURN"))
    boolean makeUntargetable(boolean original, Entity entity) {
        if (entity instanceof LivingEntity living && living.getType().is(WARDEN_UNTARGETABLE)) {
            return false;
        }
        return original;
    }

    @ModifyExpressionValue(method = "canTargetEntity", at= @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getType()Lnet/minecraft/world/entity/EntityType;"))
    EntityType<?> preventVanilla(EntityType<?> original){
        return null;
    }
}
