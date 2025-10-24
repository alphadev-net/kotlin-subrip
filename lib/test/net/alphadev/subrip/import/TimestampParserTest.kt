package net.alphadev.subrip.import

import kotlin.test.Test
import kotlin.test.assertEquals

class TimestampParserTest {
    @Test
    fun testSubtitleTimestampCorrectlyParses() {
        val timestamp = "01:02:03,004"

        val result = timestamp.parseTimestamp()
        assertEquals(1, result.inWholeHours)
        assertEquals(2, result.inWholeMinutes % 60)
        assertEquals(3, result.inWholeSeconds % 60)
        assertEquals(4, result.inWholeMilliseconds % 1000)
    }
}
