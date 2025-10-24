package net.alphadev.subrip.import

import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

internal fun String.parseTimestamp(): Duration {
    val regex = Regex("""(\d{2}):(\d{2}):(\d{2}),(\d{3})""")
    val matchResult = regex.matchEntire(trim())
        ?: throw IllegalArgumentException("Invalid time format: $this")

    val (hours, minutes, secs, millis) = matchResult
        .groupValues.drop(1).map(String::toLong)

    return hours.hours + minutes.minutes + secs.seconds + millis.milliseconds
}
