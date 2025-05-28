package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.entity.EntityType.*
import net.minecraft.registry.HolderLookup
import org.teamvoided.devin.FDOut
import org.teamvoided.devin.FutureLookup
import org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.JOHNNY_UNTARGETABLE
import org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.UNTARGETABLE
import org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.WARDEN_UNTARGETABLE
import org.teamvoided.taglighting.data.tags.TaglightingEntitiesTags.ZOGLIN_UNTARGETABLE

class EntityTagProvider(o: FDOut, r: FutureLookup) : FabricTagProvider.EntityTypeTagProvider(o, r) {
    override fun configure(arg: HolderLookup.Provider) {
        getOrCreateTagBuilder(UNTARGETABLE)
            .add(ARMOR_STAND)
        getOrCreateTagBuilder(WARDEN_UNTARGETABLE)
            .forceAddTag(UNTARGETABLE)
            .add(WARDEN)
        getOrCreateTagBuilder(ZOGLIN_UNTARGETABLE)
            .forceAddTag(UNTARGETABLE)
            .add(ZOGLIN, CREEPER)
        getOrCreateTagBuilder(JOHNNY_UNTARGETABLE)
            .forceAddTag(UNTARGETABLE)
    }
}
