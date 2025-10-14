package net.alphadev.subrip.exporter

import net.alphadev.subrip.format.Subtitle
import java.io.OutputStream

fun formatSubtitleFile(subtitle: Subtitle, destination: OutputStream) {
    try {
        formatSubtitle(subtitle)
    } catch (ex: Throwable) {
        throw SubtitleExportException(cause = ex)
    }
}