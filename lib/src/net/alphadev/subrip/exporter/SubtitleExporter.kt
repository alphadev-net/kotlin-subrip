package net.alphadev.subrip.exporter

import net.alphadev.subrip.format.Subtitle

fun formatSubtitle(subtitle: List<Subtitle>): String = try {
    ""
} catch (ex: Throwable) {
    throw SubtitleExportException(cause = ex)
}