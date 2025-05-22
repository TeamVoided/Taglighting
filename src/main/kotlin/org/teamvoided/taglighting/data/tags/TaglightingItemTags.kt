package org.teamvoided.taglighting.data.tags

import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import org.teamvoided.taglighting.Taglighting.id
import org.teamvoided.taglighting.misc.tag

object TaglightingItemTags {
    val ALL_TAGS = mutableListOf<TagKey<Item>>()

    @JvmField
    val IRON_GOLEM_REPAIR_MATERIALS = create("iron_golem_repair_materials")

    private fun create(id: String): TagKey<Item> {
        val tag = RegistryKeys.ITEM.tag(id(id))
        ALL_TAGS.add(tag)
        return tag
    }
}
