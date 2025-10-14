package net.alphadev.subrip.import

import net.alphadev.subrip.format.Subtitle

fun parseSubtitle(input: String): Subtitle? = try {
    null
} catch (ex: Throwable) {
    throw SubtitleImportException(cause = ex)
}