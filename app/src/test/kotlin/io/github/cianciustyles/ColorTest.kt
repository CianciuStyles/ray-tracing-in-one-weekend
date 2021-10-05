package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class ColorTest {
    @Test
    fun testPlus() {
        val color1 = Color(0.2, 0.4, 0.6)
        val color2 = Color(0.1, 0.5, 0.3)
        val result = color1 + color2

        assertEquals(0.3, result.r, Math.ulp(0.3))
        assertEquals(0.9, result.g, Math.ulp(0.9))
        assertEquals(0.9, result.b, Math.ulp(0.9))
    }

    @Test
    fun testTimesDouble() {
        val color = Color(0.1, 0.2, 0.3)
        val result = color * 3.0

        assertEquals(0.3, result.r, Math.ulp(0.3))
        assertEquals(0.6, result.g, Math.ulp(0.6))
        assertEquals(0.9, result.b, Math.ulp(0.9))
    }

    @Test
    fun testTimesInt() {
        val color = Color(0.1, 0.2, 0.3)
        val result = color * 3

        assertEquals(0.3, result.r, Math.ulp(0.3))
        assertEquals(0.6, result.g, Math.ulp(0.6))
        assertEquals(0.9, result.b, Math.ulp(0.9))
    }

    @Test
    fun testToString() {
        val color = Color(0.25, 0.5, 1.0)

        assertEquals("63 127 255", color.toString())
    }
}