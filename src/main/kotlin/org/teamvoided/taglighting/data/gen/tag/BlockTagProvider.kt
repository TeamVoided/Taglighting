package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider
import net.minecraft.block.Blocks.*
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.tag.BlockTags
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags.ALL_TAGS
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags as Tags
import org.teamvoided.devin.FDOut
import org.teamvoided.devin.FutureLookup

class BlockTagProvider(o: FDOut, r: FutureLookup) : BlockTagProvider(o, r) {
    override fun configure(provider: HolderLookup.Provider) {
        getOrCreateTagBuilder(Tags.SUGAR_CANE_HYDRATION)
            .add(ICE)
            .add(FROSTED_ICE)

        getOrCreateTagBuilder(Tags.ENDERMAN_PLACEABLE)
            .forceAddTag(BlockTags.ENDERMAN_HOLDABLE)

        getOrCreateTagBuilder(Tags.NETHER_PORTAL_FRAME)
            .add(OBSIDIAN)

        getOrCreateTagBuilder(Tags.PISTON_IMMOVABLE)
            .add(OBSIDIAN)
            .add(CRYING_OBSIDIAN)
            .add(RESPAWN_ANCHOR)
            .add(REINFORCED_DEEPSLATE)

        getOrCreateTagBuilder(Tags.UNIQUE_STICKY_BLOCK)
            .add(SLIME_BLOCK)
            .addTag(Tags.MOB_MOVING_STICKY_BLOCK)

        getOrCreateTagBuilder(Tags.MOB_MOVING_STICKY_BLOCK)
            .add(HONEY_BLOCK)

        getOrCreateTagBuilder(Tags.SNOW_GOLEM_BASE)
            .add(SNOW_BLOCK)

        getOrCreateTagBuilder(Tags.IRON_GOLEM_BASE)
            .add(IRON_BLOCK)

        getOrCreateTagBuilder(Tags.CANNOT_CONNECT_TO)
            .forceAddTag(BlockTags.LEAVES)
            .forceAddTag(BlockTags.SHULKER_BOXES)
            .add(BARRIER, CARVED_PUMPKIN, JACK_O_LANTERN, MELON, PUMPKIN)

        supports()
//        testing()
    }

    private fun supports() {
        getOrCreateTagBuilder(Tags.SUPPORTS_SUGAR_CANE)
            .forceAddTag(BlockTags.DIRT)
            .forceAddTag(BlockTags.SAND)

        getOrCreateTagBuilder(Tags.SUPPORTS_WITHER_ROSE)
            .forceAddTag(BlockTags.DIRT)
            .add(FARMLAND)
            .add(NETHERRACK)
            .add(SOUL_SAND)
            .add(SOUL_SOIL)

        getOrCreateTagBuilder(Tags.SUPPORTS_CACTUS)
            .forceAddTag(BlockTags.SAND)

        getOrCreateTagBuilder(Tags.SUPPORTS_NETHER_WART)
            .add(SOUL_SAND)

        getOrCreateTagBuilder(Tags.SUPPORTS_NYLIUM_PLANTS)
            .forceAddTag(BlockTags.NYLIUM)
            .add(SOUL_SOIL)
            .forceAddTag(BlockTags.DIRT)
            .add(FARMLAND)

        getOrCreateTagBuilder(Tags.SUPPORTS_COCOA)
            .forceAddTag(BlockTags.JUNGLE_LOGS)

        getOrCreateTagBuilder(Tags.SUPPORTS_END_CRYSTAL)
            .add(OBSIDIAN)
            .add(BEDROCK)
    }

    @Suppress("unused")
    private fun testing() = ALL_TAGS.filter { it != Tags.PISTON_IMMOVABLE }.forEach {
        getOrCreateTagBuilder(it).add(DIAMOND_BLOCK, NETHERITE_BLOCK, GOLD_BLOCK, EMERALD_BLOCK)
    }
}
