package net.alphadev.subrip.exporter

import net.alphadev.subrip.format.Subtitle

fun formatSubtitle(subtitle: Subtitle): String = try {
    //Json.encodeToString(JsonFeedInternal.serializer(), jsonFeed.toJsonFeedInternal()) + "\n"
    ""
} catch (ex: Throwable) {
    throw SubtitleExportException(cause = ex)
}