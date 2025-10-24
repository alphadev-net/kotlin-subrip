package net.alphadev.subrip.exporter

import kotlin.time.Duration

fun Duration.formatTime(): String = String.format(
    "%02d:%02d:%02d,%03d",
    inWholeHours,
    inWholeMinutes % 60,
    inWholeSeconds % 60,
    inWholeMilliseconds % 1000
)
