package org.teamvoided.taglighting.data.tags

import net.minecraft.core.registries.Registries
import org.teamvoided.taglighting.Taglighting.id
import org.teamvoided.taglighting.misc.tag

object TaglightingFluidTags {
    @JvmField
    val SUGAR_CANE_HYDRATION = create("sugar_cane_hydration")
    private fun create(id: String) = Registries.FLUID.tag(id(id))
}