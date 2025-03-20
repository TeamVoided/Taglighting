package org.teamvoided.taglighting.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.RegistrySetBuilder
import org.teamvoided.taglighting.Taglighting.log
import org.teamvoided.taglighting.data.gen.tag.*
import org.teamvoided.taglighting.data.tags.TaglightingFluidTags
import org.teamvoided.taglighting.misc.FutureProvider
import org.teamvoided.taglighting.misc.Pack

@Suppress("unused")
object TaglightingData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()

        val blockTags = pack.addProvider(::BlockTagProvider)
        pack.addProvider { o, r -> ItemTagProvider(o, r, blockTags) }
        pack.addProvider(::FluidTagProvider)
        pack.addProvider(::StructureTagProvider)
        // Assets
        pack.addProvider(::LangProvider)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
//        gen.add(RegistryKeys.BIOME, TemplateBiomes::boostrap)
    }

    class LangProvider(o: Pack, r: FutureProvider) : FabricLanguageProvider(o, r) {
        override fun generateTranslations(prov: HolderLookup.Provider, gen: TranslationBuilder) {
            gen.add(TaglightingFluidTags.SUGAR_CANE_HYDRATION, "Sugar Cane Hydration")
        }
    }
}
