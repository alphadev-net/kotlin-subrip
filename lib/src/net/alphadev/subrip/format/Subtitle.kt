package net.alphadev.subrip.format

import kotlin.time.Duration

public data class Subtitle(
    val startTime: Duration,
    val endTime: Duration,
    val subtitle: String
)
