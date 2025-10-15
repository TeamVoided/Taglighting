package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks.*
import org.teamvoided.devin.FDOut
import org.teamvoided.devin.FutureLookup
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags.ALL_TAGS
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags as Tags

class BlockTagProvider(o: FDOut, r: FutureLookup) : BlockTagProvider(o, r) {

    override fun addTags(provider: HolderLookup.Provider) {

        valueLookupBuilder(Tags.SUGAR_CANE_HYDRATION)
            .add(ICE, FROSTED_ICE)

        valueLookupBuilder(Tags.ENDERMAN_PLACEABLE)
            .forceAddTag(BlockTags.ENDERMAN_HOLDABLE)

        valueLookupBuilder(Tags.NETHER_PORTAL_FRAME)
            .add(OBSIDIAN)

        valueLookupBuilder(Tags.PISTON_IMMOVABLE)
            .add(OBSIDIAN, CRYING_OBSIDIAN, RESPAWN_ANCHOR, REINFORCED_DEEPSLATE)

        valueLookupBuilder(Tags.UNIQUE_STICKY_BLOCK)
            .add(SLIME_BLOCK)
            .addTag(Tags.MOB_MOVING_STICKY_BLOCK)

        valueLookupBuilder(Tags.MOB_MOVING_STICKY_BLOCK)
            .add(HONEY_BLOCK)

        valueLookupBuilder(Tags.SNOW_GOLEM_BASE)
            .add(SNOW_BLOCK)

        valueLookupBuilder(Tags.IRON_GOLEM_BASE)
            .add(IRON_BLOCK)

        valueLookupBuilder(Tags.CANNOT_CONNECT_TO)
            .forceAddTag(BlockTags.LEAVES)
            .forceAddTag(BlockTags.SHULKER_BOXES)
            .add(BARRIER, CARVED_PUMPKIN, JACK_O_LANTERN, MELON, PUMPKIN)

        supports()
//        testing()
    }

    private fun supports() {
        valueLookupBuilder(Tags.SUPPORTS_SUGAR_CANE)
            .forceAddTag(BlockTags.DIRT)
            .forceAddTag(BlockTags.SAND)

        valueLookupBuilder(Tags.SUPPORTS_WITHER_ROSE)
            .forceAddTag(BlockTags.DIRT)
            .add(FARMLAND, NETHERRACK, SOUL_SAND, SOUL_SOIL)

        valueLookupBuilder(Tags.SUPPORTS_CACTUS)
            .forceAddTag(BlockTags.SAND)

        valueLookupBuilder(Tags.SUPPORTS_NETHER_WART)
            .add(SOUL_SAND)

        valueLookupBuilder(Tags.SUPPORTS_NYLIUM_PLANTS)
            .forceAddTag(BlockTags.NYLIUM)
            .add(SOUL_SOIL)
            .forceAddTag(BlockTags.DIRT)
            .add(FARMLAND)

        valueLookupBuilder(Tags.SUPPORTS_COCOA)
            .forceAddTag(BlockTags.JUNGLE_LOGS)

        valueLookupBuilder(Tags.SUPPORTS_END_CRYSTAL)
            .add(OBSIDIAN, BEDROCK)
    }

    @Suppress("unused")
    private fun testing() = ALL_TAGS.filter { it != Tags.PISTON_IMMOVABLE }.forEach {
        valueLookupBuilder(it).add(DIAMOND_BLOCK, NETHERITE_BLOCK, GOLD_BLOCK, EMERALD_BLOCK)
    }
}
