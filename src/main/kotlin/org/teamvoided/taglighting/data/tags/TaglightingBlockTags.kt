package org.teamvoided.taglighting.data.tags

import net.minecraft.block.Block
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import org.teamvoided.taglighting.Taglighting.id
import org.teamvoided.taglighting.misc.tag

object TaglightingBlockTags {
    val ALL_TAGS = mutableListOf<TagKey<Block>>()

    @JvmField
    val SUGAR_CANE_HYDRATION = create("sugar_cane_hydration")

    @JvmField
    val ENDERMAN_PLACEABLE = create("enderman_placeable")

    @JvmField
    val NETHER_PORTAL_FRAME = create("nether_portal_frame")

    @JvmField
    val PISTON_IMMOVABLE = create("piston_immovable")

    // Supports
    @JvmField
    val SUPPORTS_SUGAR_CANE = supports("sugar_cane")

    @JvmField
    val SUPPORTS_WITHER_ROSE = supports("wither_rose")

    @JvmField
    val SUPPORTS_CACTUS = supports("cactus")

    @JvmField
    val SUPPORTS_NETHER_WART = supports("nether_wart")

    @JvmField
    val SUPPORTS_NYLIUM_PLANTS = supports("nylium_plants")

    @JvmField
    val SUPPORTS_COCOA = supports("cocoa")

    @JvmField
    val SUPPORTS_END_CRYSTAL = supports("end_crystal")

    // Special Support
    @JvmField
    val SUPPORTS_SMALL_TOP = supports("small/top")

    @JvmField
    val SUPPORTS_SMALL_BOTTOM = supports("small/bottom")

    @JvmField
    val SUPPORTS_SMALL_SIDES = supports("small/sides")

    // functions
    private fun create(id: String): TagKey<Block> {
        val tag = RegistryKeys.BLOCK.tag(id(id))
        ALL_TAGS.add(tag)
        return tag
    }

    private fun supports(id: String) = create("supports/$id")
}
