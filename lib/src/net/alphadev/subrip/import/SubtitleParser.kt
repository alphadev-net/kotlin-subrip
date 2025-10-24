package net.alphadev.subrip.import

import net.alphadev.subrip.format.Subtitle

fun parseSubtitle(input: String): List<Subtitle> = try {
    val subtitles = mutableListOf<Subtitle>()
    val groups = input.trim().split(Regex("\n\\s*\n+"))

    for (group in groups) {
        val lines = group.lines().map { it.trim() }.filter { it.isNotEmpty() }
        if (lines.size < 3) continue

        try {
            val sequenceNumber = lines[0].toInt()
            val timeLine = lines[1]
            val textLines = lines.drop(2)

            val times = timeLine.split("-->").map { it.trim() }
            if (times.size != 2) continue

            val startTime = times[0].parseTimestamp()
            val endTime = times[1].parseTimestamp()
            val subtitle = textLines.joinToString("\n")

            subtitles.add(
                Subtitle(
                    sequenceNumber = sequenceNumber,
                    startTime = startTime,
                    endTime = endTime,
                    subtitle = subtitle
                )
            )
        } catch (e: Exception) {
            // Skip malformed entries
        }
    }

    subtitles
} catch (ex: Throwable) {
    throw SubtitleImportException(cause = ex)
}
