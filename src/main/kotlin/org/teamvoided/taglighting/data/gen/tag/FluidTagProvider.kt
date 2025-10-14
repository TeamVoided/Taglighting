package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.FluidTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.FluidTags
import org.teamvoided.devin.FDOut
import org.teamvoided.devin.FutureLookup
import org.teamvoided.taglighting.data.tags.TaglightingFluidTags

class FluidTagProvider(o: FDOut, r: FutureLookup) : FluidTagProvider(o, r) {
    override fun addTags(arg: HolderLookup.Provider) {
        getOrCreateTagBuilder(TaglightingFluidTags.SUGAR_CANE_HYDRATION)
            .forceAddTag(FluidTags.WATER)
    }
}
