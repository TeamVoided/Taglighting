package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.RegistryKeys.STRUCTURE_FEATURE
import net.minecraft.world.gen.feature.StructureFeature
import org.teamvoided.taglighting.misc.FutureProvider
import org.teamvoided.taglighting.misc.Pack

class StructureTagProvider(o: Pack, r: FutureProvider) : FabricTagProvider<StructureFeature>(o, STRUCTURE_FEATURE, r) {
    override fun configure(arg: HolderLookup.Provider) {
    }
}
