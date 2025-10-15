package org.teamvoided.taglighting.data.tags

import net.minecraft.core.registries.Registries
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
    @JvmField
    val IS_NOT_ATTACKABLE = create("is_not_attackable")
    private fun create(id: String) = Registries.ENTITY_TYPE.tag(id(id))
}