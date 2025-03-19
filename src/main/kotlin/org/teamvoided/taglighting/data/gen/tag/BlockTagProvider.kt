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
        //Nullium Tags
        getOrCreateTagBuilder(TaglightingBlockTags.CANE_HYDRATION)
            .add(Blocks.ICE)
            .add(Blocks.FROSTED_ICE)

        getOrCreateTagBuilder(TaglightingBlockTags.CANE_SUPPORT)
            .forceAddTag(BlockTags.DIRT)
            .forceAddTag(BlockTags.SAND)

        getOrCreateTagBuilder(TaglightingBlockTags.WITHER_ROSE_SUPPORT)
            .forceAddTag(BlockTags.DIRT)
            .add(Blocks.FARMLAND)
            .add(Blocks.NETHERRACK)
            .add(Blocks.SOUL_SOIL)
            .add(Blocks.SOUL_SAND)

        getOrCreateTagBuilder(TaglightingBlockTags.SUPPORT_SMALL_TOP)
            .forceAddTag(BlockTags.FENCES)
            .forceAddTag(BlockTags.WALLS)

        getOrCreateTagBuilder(TaglightingBlockTags.SUPPORT_SMALL_BOTTOM)
            .forceAddTag(BlockTags.FENCES)
            .forceAddTag(BlockTags.WALLS)

        getOrCreateTagBuilder(TaglightingBlockTags.ENDERMAN_PLACEABLE)
            .forceAddTag(BlockTags.ENDERMAN_HOLDABLE)

        getOrCreateTagBuilder(TaglightingBlockTags.CACTUS_SUPPORT)
            .add(Blocks.CACTUS)
            .forceAddTag(BlockTags.SAND)

        getOrCreateTagBuilder(TaglightingBlockTags.NETHER_WART_SUPPORT)
            .add(Blocks.SOUL_SAND)

        getOrCreateTagBuilder(TaglightingBlockTags.NYLIUM_PLANTS_SUPPORT)
            .forceAddTag(BlockTags.NYLIUM)
            .add(Blocks.SOUL_SOIL)
            .forceAddTag(BlockTags.DIRT)
            .add(Blocks.FARMLAND)

        getOrCreateTagBuilder(TaglightingBlockTags.PORTAL_BLOCKS)
            .add(Blocks.OBSIDIAN)
            .add(Blocks.CRYING_OBSIDIAN)

        // Vanilla Tags
        getOrCreateTagBuilder(BlockTags.WALL_POST_OVERRIDE)
            .forceAddTag(BlockTags.BUTTONS)
            .add(Blocks.LEVER)

    }
}
