package net.alphadev.subrip.exporter

import net.alphadev.subrip.format.Subtitle
import java.io.OutputStream

public fun formatSubtitleFile(subtitle: List<Subtitle>, destination: OutputStream) {
    try {
        formatSubtitle(subtitle)
    } catch (ex: Throwable) {
        throw SubtitleExportException(cause = ex)
    }
}