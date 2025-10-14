package net.alphadev.subrip.format

import kotlinx.serialization.Serializable

@Serializable
data class Subtitle(
    val blocks: List<Block>
)
