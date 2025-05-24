package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.FluidTagProvider
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.tag.FluidTags
import org.teamvoided.taglighting.data.tags.TaglightingFluidTags
import org.teamvoided.devin.FutureLookup
import org.teamvoided.devin.FDOut

class FluidTagProvider(o: FDOut, r: FutureLookup) : FluidTagProvider(o, r) {
    override fun configure(arg: HolderLookup.Provider) {
        getOrCreateTagBuilder(TaglightingFluidTags.SUGAR_CANE_HYDRATION)
            .forceAddTag(FluidTags.WATER)
    }
}
