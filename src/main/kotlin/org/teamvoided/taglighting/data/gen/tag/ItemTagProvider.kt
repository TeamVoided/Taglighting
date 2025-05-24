package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider
import net.minecraft.item.Items
import net.minecraft.registry.HolderLookup
import org.teamvoided.taglighting.data.tags.TaglightingItemTags.ALL_TAGS
import org.teamvoided.taglighting.data.tags.TaglightingItemTags.IRON_GOLEM_REPAIR_MATERIALS
import org.teamvoided.devin.FutureLookup
import org.teamvoided.devin.FDOut

class ItemTagProvider(o: FDOut, r: FutureLookup, blockTags: BlockTagProvider) : ItemTagProvider(o, r, blockTags) {
    override fun configure(arg: HolderLookup.Provider) {
        getOrCreateTagBuilder(IRON_GOLEM_REPAIR_MATERIALS).add(Items.IRON_INGOT)
//        testing()
    }

    @Suppress("unused")
    private fun testing() = ALL_TAGS.forEach { getOrCreateTagBuilder(it).add(Items.NETHERITE_INGOT) }
}
