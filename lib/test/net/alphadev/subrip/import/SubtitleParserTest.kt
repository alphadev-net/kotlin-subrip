package net.alphadev.subrip.import

import de.sipgate.dachlatten.io.readResource
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlinx.io.readString

class SubtitleParserTest {
    @Test
    fun doTest() {
        readResource("speechpad-com-example.srt") { input ->
            val subtitle = parseSubtitle(input.readString())
            assertNotNull(subtitle)
        }
    }
}
