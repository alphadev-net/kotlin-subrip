package net.alphadev.subrip.import

import de.sipgate.dachlatten.io.readResource
import kotlinx.io.readString
import kotlin.test.Test
import kotlin.test.assertEquals

class SubtitleParserTest {
    @Test
    fun speechpadSampleCorrectlyDecodes() {
        readResource("speechpad-com-example.srt") {
            val subtitles = parseSubtitle(it.readString())

            assertEquals(3, subtitles.size)

            val firstEntry = subtitles[0]
            assertEquals(1, firstEntry.sequenceNumber)
            assertEquals("- Here's what I love most\nabout food and diet.", firstEntry.subtitle)
        }
    }
}
