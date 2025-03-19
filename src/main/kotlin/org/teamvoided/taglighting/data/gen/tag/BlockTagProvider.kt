package org.teamvoided.taglighting.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider
import net.minecraft.block.Blocks
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.tag.BlockTags
import org.teamvoided.taglighting.misc.FutureProvider
import org.teamvoided.taglighting.misc.Pack
import org.teamvoided.taglighting.data.tags.TaglightingBlockTags

class BlockTagProvider(o: Pack, r: FutureProvider) : BlockTagProvider(o, r) {
    override fun configure(provider: HolderLookup.Provider) {
        getOrCreateTagBuilder(TaglightingBlockTags.SUGAR_CANE_HYDRATION)
            .add(Blocks.ICE)
            .add(Blocks.FROSTED_ICE)

        getOrCreateTagBuilder(TaglightingBlockTags.ENDERMAN_PLACEABLE)
            .forceAddTag(BlockTags.ENDERMAN_HOLDABLE)

        getOrCreateTagBuilder(TaglightingBlockTags.NETHER_PORTAL_FRAME)
            .add(Blocks.OBSIDIAN)

        supports()
        supportsSpecial()
    }

    private fun supports() {
        getOrCreateTagBuilder(TaglightingBlockTags.SUPPORTS_SUGAR_CANE)
            .forceAddTag(BlockTags.DIRT)
            .forceAddTag(BlockTags.SAND)

        getOrCreateTagBuilder(TaglightingBlockTags.SUPPORTS_WITHER_ROSE)
            .forceAddTag(BlockTags.DIRT)
            .add(Blocks.FARMLAND)
            .add(Blocks.NETHERRACK)
            .add(Blocks.SOUL_SAND)
            .add(Blocks.SOUL_SOIL)

        getOrCreateTagBuilder(TaglightingBlockTags.SUPPORTS_CACTUS)
            .forceAddTag(BlockTags.SAND)

        getOrCreateTagBuilder(TaglightingBlockTags.SUPPORTS_NETHER_WART)
            .add(Blocks.SOUL_SAND)

        getOrCreateTagBuilder(TaglightingBlockTags.SUPPORTS_NYLIUM_PLANTS)
            .forceAddTag(BlockTags.NYLIUM)
            .add(Blocks.SOUL_SOIL)
            .forceAddTag(BlockTags.DIRT)
            .add(Blocks.FARMLAND)
    }

    private fun supportsSpecial() {
        getOrCreateTagBuilder(TaglightingBlockTags.SUPPORTS_SMALL_TOP)
            .forceAddTag(BlockTags.FENCES)
            .forceAddTag(BlockTags.WALLS)

        getOrCreateTagBuilder(TaglightingBlockTags.SUPPORTS_SMALL_BOTTOM)
            .forceAddTag(BlockTags.FENCES)
            .forceAddTag(BlockTags.WALLS)

        getOrCreateTagBuilder(BlockTags.WALL_POST_OVERRIDE)
            .forceAddTag(BlockTags.BUTTONS)
            .add(Blocks.LEVER)
    }
}
