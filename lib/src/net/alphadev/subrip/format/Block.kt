package net.alphadev.subrip.format

import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class Block(
    val sequenceNumber: Int,
    val startTimestamp: Instant,
    val endTimestamp: Instant,
    val subtitle: String
)
