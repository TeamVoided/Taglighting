package org.teamvoided.taglighting.data.tags

import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import org.teamvoided.taglighting.Taglighting.id
import org.teamvoided.taglighting.misc.tag

object TaglightingItemTags {
    val ALL_TAGS = mutableListOf<TagKey<Item>>()

    @JvmField
    val IRON_GOLEM_REPAIR_MATERIALS = create("iron_golem_repair_materials")

    private fun create(id: String): TagKey<Item> {
        val tag = Registries.ITEM.tag(id(id))
        ALL_TAGS.add(tag)
        return tag
    }
}
