package org.teamvoided.taglighting.data.tags

import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block
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

    @JvmField
    val UNIQUE_STICKY_BLOCK = create("unique_sticky_block")

    @JvmField
    val MOB_MOVING_STICKY_BLOCK = create("mob_moving_sticky_block")

    @JvmField
    val SNOW_GOLEM_BASE = create("snow_golem_base")

    @JvmField
    val IRON_GOLEM_BASE = create("iron_golem_base")

    @JvmField
    val CANNOT_CONNECT_TO = create("cannot_connect_to")

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



    // functions
    private fun create(id: String): TagKey<Block> {
        val tag = Registries.BLOCK.tag(id(id))
        ALL_TAGS.add(tag)
        return tag
    }

    private fun supports(id: String) = create("supports/$id")
}
