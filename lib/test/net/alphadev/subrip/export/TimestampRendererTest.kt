package net.alphadev.subrip.export

import net.alphadev.subrip.exporter.formatTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class TimestampRendererTest {
    @Test
    fun testSubtitleTimestampRendering() {
        val duration = 1.hours + 2.minutes + 3.seconds + 4.milliseconds
        assertEquals("01:02:03,004", duration.formatTime())
    }
}
