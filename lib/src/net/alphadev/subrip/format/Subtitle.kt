package net.alphadev.subrip.format

import kotlin.time.Duration

data class Subtitle(
    val startTime: Duration,
    val endTime: Duration,
    val subtitle: String
)
