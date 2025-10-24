package net.alphadev.subrip.exporter

import net.alphadev.subrip.format.Subtitle

fun formatSubtitle(subtitles: List<Subtitle>): String = try {
    subtitles.mapIndexed { idx, sub ->
        val sequenceNumber = idx + 1
        val startTime = sub.startTime.formatTime()
        val endTime = sub.endTime.formatTime()
        "$sequenceNumber\n$startTime --> $endTime\n${sub.subtitle}"
    }.joinToString("\n\n") + "\n"
} catch (ex: Throwable) {
    throw SubtitleExportException(cause = ex)
}
