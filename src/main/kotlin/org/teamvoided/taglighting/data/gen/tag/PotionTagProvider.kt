package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.potion.Potion
import net.minecraft.potion.Potions
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.RegistryKeys.POTION
import org.teamvoided.taglighting.data.tags.TaglightingPotionTags.MAKES_MUD
import org.teamvoided.taglighting.misc.FutureProvider
import org.teamvoided.taglighting.misc.Pack
import org.teamvoided.taglighting.misc.add

class PotionTagProvider(o: Pack, r: FutureProvider) : FabricTagProvider<Potion>(o, POTION, r) {
    override fun configure(arg: HolderLookup.Provider) {
        getOrCreateTagBuilder(MAKES_MUD).add(Potions.WATER)
    }
}
