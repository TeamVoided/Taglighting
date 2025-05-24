@file:Suppress("unused")

package org.teamvoided.taglighting.misc

import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

fun <T> RegistryKey<Registry<T>>.tag(id: Identifier): TagKey<T> = TagKey.of<T>(this, id)
