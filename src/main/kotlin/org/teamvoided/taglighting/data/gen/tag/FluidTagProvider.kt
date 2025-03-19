package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.FluidTagProvider
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.tag.FluidTags
import org.teamvoided.taglighting.data.tags.TaglightingFluidTags
import org.teamvoided.taglighting.misc.FutureProvider
import org.teamvoided.taglighting.misc.Pack

class FluidTagProvider(o: Pack, r: FutureProvider) : FluidTagProvider(o, r) {
    override fun configure(arg: HolderLookup.Provider) {
        getOrCreateTagBuilder(TaglightingFluidTags.CANE_HYDRATION)
            .forceAddTag(FluidTags.WATER)
    }
}
