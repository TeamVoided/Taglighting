package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider
import net.minecraft.registry.HolderLookup
import org.teamvoided.taglighting.misc.FutureProvider
import org.teamvoided.taglighting.misc.Pack

class ItemTagProvider(o: Pack, r: FutureProvider, blockTags: BlockTagProvider) : ItemTagProvider(o, r, blockTags) {
    override fun configure(arg: HolderLookup.Provider) {
    }
}
