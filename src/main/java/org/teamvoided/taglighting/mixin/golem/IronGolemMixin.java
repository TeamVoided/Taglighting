package org.teamvoided.taglighting.mixin.golem;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.taglighting.data.tags.TaglightingItemTags.IRON_GOLEM_REPAIR_MATERIALS;

@Mixin(IronGolem.class)
public class IronGolemMixin {

    @ModifyExpressionValue(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    boolean changeRepairMaterial(boolean original, @Local ItemStack stack) {
        return stack.is(IRON_GOLEM_REPAIR_MATERIALS);
    }
}
