package net.alphadev.subrip.import

import net.alphadev.subrip.format.Subtitle

fun parseSubtitle(input: String): List<Subtitle> = try {
    emptyList()
} catch (ex: Throwable) {
    throw SubtitleImportException(cause = ex)
}
