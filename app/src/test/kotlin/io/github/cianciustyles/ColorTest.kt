package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class ColorTest {
    @Test
    fun testToString() {
        val color = Color(0.25, 0.5, 1.0)

        assertEquals("63 127 255", color.toString())
    }
}