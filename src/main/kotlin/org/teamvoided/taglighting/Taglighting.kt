package org.teamvoided.taglighting

import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("unused")
object Taglighting {
    const val MODID = "taglighting"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(Taglighting::class.simpleName)

    fun init() {
        log.info("Taglight, Tagkeep, Tagboss!")
    }

    fun id(path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(MODID, path)
}
