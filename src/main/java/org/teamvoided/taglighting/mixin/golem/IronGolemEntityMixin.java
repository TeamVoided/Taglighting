package org.teamvoided.taglighting.mixin.golem;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingItemTags.IRON_GOLEM_REPAIR_MATERIALS;

@Mixin(IronGolemEntity.class)
public class IronGolemEntityMixin {

    @ModifyExpressionValue(method = "interactMob", at= @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    boolean changeRepairMaterial(boolean original, @Local ItemStack stack){
        return stack.isIn(IRON_GOLEM_REPAIR_MATERIALS);
    }
}
