package net.alphadev.subrip.import

import de.sipgate.dachlatten.io.readResource
import kotlinx.io.readString
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class SubtitleParserTest {
    @Test
    fun speechpadSampleCorrectlyDecodes() {
        readResource("speechpad-com-example.srt") {
            val subtitles = parseSubtitle(it.readString())

            assertEquals(3, subtitles.size)
        }
    }

    @Test
    fun speechpadSampleCorrectlyDecodesSubtitlesAndInOrder() {
        readResource("speechpad-com-example.srt") {
            val subtitles = parseSubtitle(it.readString())
            assertEquals("- Here's what I love most\nabout food and diet.", subtitles[0].subtitle)
            assertEquals("We all eat several times a day,\nand we're totally in charge", subtitles[1].subtitle)
            assertEquals("of what goes on our plate\nand what stays off.", subtitles[2].subtitle)
        }
    }

    @Test
    fun speechpadSampleCorrectlyDecodesTimestampsAndInOrder() {
        readResource("speechpad-com-example.srt") {
            val subtitles = parseSubtitle(it.readString())
            assertEquals(0.seconds + 498.milliseconds, subtitles[0].startTime)
            assertEquals(2.seconds + 827.milliseconds, subtitles[1].startTime)
            assertEquals(6.seconds + 383.milliseconds, subtitles[2].startTime)

            assertEquals(2.seconds + 827.milliseconds, subtitles[0].endTime)
            assertEquals(6.seconds + 383.milliseconds, subtitles[1].endTime)
            assertEquals(9.seconds + 427.milliseconds, subtitles[2].endTime)
        }
    }
}
