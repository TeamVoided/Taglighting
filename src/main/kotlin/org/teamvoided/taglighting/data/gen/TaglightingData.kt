package org.teamvoided.taglighting.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import org.teamvoided.devin.FDOut
import org.teamvoided.devin.FutureLookup
import org.teamvoided.taglighting.Taglighting.log
import org.teamvoided.taglighting.data.gen.tag.*
import org.teamvoided.taglighting.data.tags.TaglightingFluidTags
import org.teamvoided.taglighting.data.tags.TaglightingItemTags

@Suppress("unused")
object TaglightingData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()

        val blockTags = pack.addProvider(::BlockTagProvider)
        pack.addProvider { o, r -> ItemTagProvider(o, r, blockTags) }
        pack.addProvider(::EntityTagProvider)
        pack.addProvider(::FluidTagProvider)
//        pack.addProvider(::StructureTagProvider)
        pack.addProvider(::PotionTagProvider)
        // Assets
        pack.addProvider(::LangProvider)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
//        gen.add(RegistryKeys.BIOME, TemplateBiomes::boostrap)
    }

    class LangProvider(o: FDOut, r: FutureLookup) : FabricLanguageProvider(o, r) {
        override fun generateTranslations(prov: HolderLookup.Provider, gen: TranslationBuilder) {
            gen.add(TaglightingFluidTags.SUGAR_CANE_HYDRATION, "Sugar Cane Hydration")
            gen.add(TaglightingItemTags.IRON_GOLEM_REPAIR_MATERIALS, "Iron Golem Repair Materials")
        }
    }
}
