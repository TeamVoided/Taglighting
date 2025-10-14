package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries.POTION
import net.minecraft.world.item.alchemy.Potion
import net.minecraft.world.item.alchemy.Potions
import org.teamvoided.devin.FDOut
import org.teamvoided.devin.FutureLookup
import org.teamvoided.devin.tag.add
import org.teamvoided.taglighting.data.tags.TaglightingPotionTags.MAKES_MUD

class PotionTagProvider(o: FDOut, r: FutureLookup) : FabricTagProvider<Potion>(o, POTION, r) {
    override fun addTags(arg: HolderLookup.Provider) {
        getOrCreateTagBuilder(MAKES_MUD).add(Potions.WATER)
    }
}
