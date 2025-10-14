package org.teamvoided.taglighting.mixin;

import net.minecraft.world.entity.monster.Vindicator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Vindicator.class)
public interface VindicatorAccessor {
    @Accessor("isJohnny")
    boolean taglighting_isJohnny();
}
