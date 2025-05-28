package org.teamvoided.taglighting.data.tags

import net.minecraft.registry.RegistryKeys
import org.teamvoided.taglighting.Taglighting.id
import org.teamvoided.taglighting.misc.tag

object TaglightingEntitiesTags {
    val UNTARGETABLE = create("untargetable")
    @JvmField
    val WARDEN_UNTARGETABLE = create("warden_untargetable")
    @JvmField
    val ZOGLIN_UNTARGETABLE = create("zoglin_untargetable")
    @JvmField
    val JOHNNY_UNTARGETABLE = create("johnny_untargetable")
    private fun create(id: String) = RegistryKeys.ENTITY_TYPE.tag(id(id))
}