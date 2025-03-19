package org.teamvoided.taglighting

import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("unused")
object Taglighting {
    const val MODID = "taglighting"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(Taglighting::class.simpleName)

    fun init() {
        log.info("Hello from Common")
    }

    fun id(path: String) = Identifier.of(MODID, path)
}
