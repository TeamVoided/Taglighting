@file:Suppress("unused")

package org.teamvoided.taglighting.misc

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.Holder
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import java.util.concurrent.CompletableFuture

fun <T> RegistryKey<Registry<T>>.tag(id: Identifier): TagKey<T> = TagKey.of<T>(this, id)


// Import from devin
typealias Pack = FabricDataOutput
typealias FutureProvider = CompletableFuture<HolderLookup.Provider>

fun <T> FabricTagProvider<T>.FabricTagBuilder.add(holder: Holder<T>): FabricTagProvider<T>.FabricTagBuilder {
    this.add(holder.value())
    return this
}

fun <T> FabricTagProvider<T>.FabricTagBuilder.add(vararg holders: Holder<T>): FabricTagProvider<T>.FabricTagBuilder {
    for (holder in holders) this.add(holder)
    return this
}