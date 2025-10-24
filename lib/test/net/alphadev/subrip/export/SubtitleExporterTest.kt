package net.alphadev.subrip.export

import de.sipgate.dachlatten.io.readResource
import kotlinx.io.readString
import net.alphadev.subrip.exporter.formatSubtitle
import net.alphadev.subrip.format.Subtitle
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class SubtitleExporterTest {
    @Test
    fun testSubtitleExporterProducesCorrectResult() {
        val data = buildList {
            add(Subtitle(
                startTime = 498.milliseconds,
                endTime = 2.seconds + 827.milliseconds,
                subtitle = "- Here's what I love most\nabout food and diet."
            ))

            add(Subtitle(
                startTime = 2.seconds + 827.milliseconds,
                endTime = 6.seconds + 383.milliseconds,
                subtitle = "We all eat several times a day,\nand we're totally in charge"
            ))

            add(Subtitle(
                startTime = 6.seconds + 383.milliseconds,
                endTime = 9.seconds + 427.milliseconds,
                subtitle = "of what goes on our plate\nand what stays off."
            ))
        }

        val exportedSrt = formatSubtitle(data)
        assertFalse(exportedSrt.isBlank())

        readResource("speechpad-com-example.srt") {
            assertEquals(it.readString(), exportedSrt)
        }
    }
}