package org.teamvoided.taglighting.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zoglin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.ZOGLIN_UNTARGETABLE;

@Mixin(Zoglin.class)
public class ZoglinEntityMixin {

    @ModifyReturnValue(method = "isTargetable", at = @At("RETURN"))
    boolean makeUntargetable(boolean original, LivingEntity target) {
        if (target.getType().is(ZOGLIN_UNTARGETABLE)) {
            return false;
        }
        return original;
    }

    @ModifyExpressionValue(method = "isTargetable", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getType()Lnet/minecraft/world/entity/EntityType;"))
    EntityType<?> preventVanilla(EntityType<?> original) {
        return null;
    }
}
