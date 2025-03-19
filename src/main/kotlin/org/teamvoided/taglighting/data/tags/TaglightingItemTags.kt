package org.teamvoided.taglighting.data.tags

import net.minecraft.registry.RegistryKeys
import org.teamvoided.taglighting.Taglighting.id
import org.teamvoided.taglighting.misc.tag

object TaglightingItemTags {
    private fun create(id: String) = RegistryKeys.ITEM.tag(id(id))
}
