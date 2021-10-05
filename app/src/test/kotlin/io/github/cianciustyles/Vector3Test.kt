package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class Vector3Test {
    @Test
    fun testNoArgsConstructor() {
        val vector = Vector3()

        assertEquals(0.0, vector.x, Math.ulp(0.0))
        assertEquals(0.0, vector.y, Math.ulp(0.0))
        assertEquals(0.0, vector.z, Math.ulp(0.0))
    }

    @Test
    fun testConstructor() {
        val x = 2.1
        val y = 3.4
        val z = 1.9
        val vector = Vector3(x, y, z)

        assertEquals(x, vector.x, Math.ulp(0.0))
        assertEquals(y, vector.y, Math.ulp(0.0))
        assertEquals(z, vector.z, Math.ulp(0.0))
    }

    @Test
    fun testUnaryMinus() {
        val x = 2.1
        val y = 3.4
        val z = 1.9
        val vector = Vector3(x, y, z)
        val inverse = -vector

        assertEquals(-x, inverse.x, Math.ulp(0.0))
        assertEquals(-y, inverse.y, Math.ulp(0.0))
        assertEquals(-z, inverse.z, Math.ulp(0.0))
    }

    @Test
    fun testPlus() {
        val vector1 = Vector3(1.0, 2.0, 3.0)
        val vector2 = Vector3(4.0, 5.0, 6.0)
        val result = vector1 + vector2

        assertEquals(5.0, result.x, Math.ulp(0.0))
        assertEquals(7.0, result.y, Math.ulp(0.0))
        assertEquals(9.0, result.z, Math.ulp(0.0))
    }

    @Test
    fun testMultiply() {
        val vector = Vector3(1.0, 2.0, 3.0)
        val result = vector * 3

        assertEquals(3.0, result.x, Math.ulp(0.0))
        assertEquals(6.0, result.y, Math.ulp(0.0))
        assertEquals(9.0, result.z, Math.ulp(0.0))
    }

    @Test
    fun testDivide() {
        val vector = Vector3(3.0, 6.0, 9.0)
        val result = vector / 3

        assertEquals(1.0, result.x, Math.ulp(0.0))
        assertEquals(2.0, result.y, Math.ulp(0.0))
        assertEquals(3.0, result.z, Math.ulp(0.0))
    }

    @Test
    fun testLength() {
        val vector = Vector3(2.0, 3.0, 6.0)

        assertEquals(7.0, vector.length(), Math.ulp(0.0))
    }

    @Test
    fun testToString() {
        val vector = Vector3(1.0, 2.0, 3.0)

        assertEquals("1.0 2.0 3.0", vector.toString())
    }

    @Test
    fun testDotProduct() {
        val vector1 = Vector3(1.0, 2.0 , 3.0)
        val vector2 = Vector3(4.0, 5.0, 6.0)
        val result = vector1 dot vector2

        assertEquals(4.0, result.x, Math.ulp(0.0))
        assertEquals(10.0, result.y, Math.ulp(0.0))
        assertEquals(18.0, result.z, Math.ulp(0.0))
    }

    @Test
    fun testCrossProduct() {
        val vector1 = Vector3(1.0, 2.0, 3.0)
        val vector2 = Vector3(4.0, 5.0, 6.0)
        val result = vector1 cross vector2

        assertEquals(-3.0, result.x, Math.ulp(0.0))
        assertEquals(6.0, result.y, Math.ulp(0.0))
        assertEquals(-3.0, result.z, Math.ulp(0.0))
    }

    @Test
    fun testUnitVector() {
        val vector = Vector3(1.0, 2.0, 3.0)
        val length = vector.length()
        val unitVector = vector.unit()

        assertEquals(1.0 / length, unitVector.x, Math.ulp(0.0))
        assertEquals(2.0 / length, unitVector.y, Math.ulp(0.0))
        assertEquals(3.0 / length, unitVector.z, Math.ulp(0.0))
    }
}