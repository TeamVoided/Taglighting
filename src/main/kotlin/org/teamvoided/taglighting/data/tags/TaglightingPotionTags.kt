package org.teamvoided.taglighting.data.tags

import net.minecraft.registry.RegistryKeys
import org.teamvoided.taglighting.Taglighting.id
import org.teamvoided.taglighting.misc.tag

object TaglightingPotionTags {
    @JvmField
    val MAKES_MUD = create("makes_mud")
    private fun create(id: String) = RegistryKeys.POTION.tag(id(id))
}