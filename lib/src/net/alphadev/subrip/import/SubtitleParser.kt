package net.alphadev.subrip.import

import net.alphadev.subrip.format.Subtitle

fun parseSubtitle(input: String): List<Subtitle> = try {
    val subtitles = mutableMapOf<Int, Subtitle>()
    val groups = input.trim().split(Regex("\n\\s*\n+"))

    for (group in groups) {
        val groupWithIndex = group.parseGroup()
        subtitles[groupWithIndex.first] = groupWithIndex.second
    }

    subtitles.toSortedMap().values.toList()
} catch (ex: Throwable) {
    throw SubtitleImportException(cause = ex)
}

private fun String.parseGroup(): Pair<Int, Subtitle> {
    val lines = lines().map { it.trim() }.filter { it.isNotEmpty() }
    if (lines.size < 3) throw SubtitleImportException("Encountered invalid entry")

    try {
        val sequenceNumber = lines[0].toInt()
        val timeLine = lines[1]
        val textLines = lines.drop(2)

        val times = timeLine.split("-->").map { it.trim() }
        if (times.size != 2) throw SubtitleImportException("Encountered invalid Timestamp values")

        val startTime = times[0].parseTimestamp()
        val endTime = times[1].parseTimestamp()
        val subtitle = textLines.joinToString("\n")

        return sequenceNumber to Subtitle(
            startTime = startTime,
            endTime = endTime,
            subtitle = subtitle
        )
    } catch (e: Exception) {
        throw SubtitleImportException(cause = e)
    }
}
