package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider
import net.minecraft.block.Blocks.*
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.tag.BlockTags
import org.teamvoided.taglighting.misc.FutureProvider
import org.teamvoided.taglighting.misc.Pack
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags as Tags
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags.ALL_TAGS

class BlockTagProvider(o: Pack, r: FutureProvider) : BlockTagProvider(o, r) {
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

        supports()
        supportsSpecial()
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
    }

    private fun supportsSpecial() {
        getOrCreateTagBuilder(Tags.SUPPORTS_SMALL_TOP)
            .forceAddTag(BlockTags.FENCES)
            .forceAddTag(BlockTags.WALLS)

        getOrCreateTagBuilder(Tags.SUPPORTS_SMALL_BOTTOM)
            .forceAddTag(BlockTags.FENCES)
            .forceAddTag(BlockTags.WALLS)

        getOrCreateTagBuilder(BlockTags.WALL_POST_OVERRIDE)
            .forceAddTag(BlockTags.BUTTONS)
            .add(LEVER)
    }


    private fun testing() = ALL_TAGS.forEach {
        getOrCreateTagBuilder(it).add(DIAMOND_BLOCK, NETHERITE_BLOCK, GOLD_BLOCK, EMERALD_BLOCK)
    }

}
