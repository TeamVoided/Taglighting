package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.RegistryKeys.STRUCTURE_FEATURE
import net.minecraft.world.gen.feature.StructureFeature
import org.teamvoided.devin.FutureLookup
import org.teamvoided.devin.FDOut

class StructureTagProvider(o: FDOut, r: FutureLookup) : FabricTagProvider<StructureFeature>(o, STRUCTURE_FEATURE, r) {
    override fun configure(arg: HolderLookup.Provider) {
    }
}
