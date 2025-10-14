@file:Suppress("unused")

package org.teamvoided.taglighting.misc

import net.minecraft.core.Registry
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey

fun <T> ResourceKey<Registry<T>>.tag(id: ResourceLocation): TagKey<T> = TagKey.create<T>(this, id)
