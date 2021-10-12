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
    fun testMinusVector() {
        val vector1 = Vector3(1.0, 2.0, 3.0)
        val vector2 = Vector3(4.0, 5.0, 6.0)
        val result = vector1 - vector2

        assertEquals(-3.0, result.x, Math.ulp(0.0))
        assertEquals(-3.0, result.y, Math.ulp(0.0))
        assertEquals(-3.0, result.z, Math.ulp(0.0))
    }

    @Test
    fun testTimesInt() {
        val vector = Vector3(1.0, 2.0, 3.0)
        val result = vector * 3

        assertEquals(3.0, result.x, Math.ulp(0.0))
        assertEquals(6.0, result.y, Math.ulp(0.0))
        assertEquals(9.0, result.z, Math.ulp(0.0))
    }

    @Test
    fun testTimesDouble() {
        val vector = Vector3(1.0, 2.0, 3.0)
        val result = vector * 3.0

        assertEquals(3.0, result.x, Math.ulp(0.0))
        assertEquals(6.0, result.y, Math.ulp(0.0))
        assertEquals(9.0, result.z, Math.ulp(0.0))
    }

    @Test
    fun testDivideInt() {
        val vector = Vector3(3.0, 6.0, 9.0)
        val result = vector / 3

        assertEquals(1.0, result.x, Math.ulp(0.0))
        assertEquals(2.0, result.y, Math.ulp(0.0))
        assertEquals(3.0, result.z, Math.ulp(0.0))
    }

    @Test
    fun testDivideDouble() {
        val vector = Vector3(3.0, 6.0, 9.0)
        val result = vector / 3.0

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

        assertEquals(32.0, result, Math.ulp(32.0))
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
    
    @Test
    fun testRandom() {
        val vector1 = Vector3.random()
        val vector2 = Vector3.random()

        assertNotEquals(vector1, vector2)
        assertTrue(0.0 <= vector1.x && vector1.x < 1.0)
        assertTrue(0.0 <= vector1.y && vector1.y < 1.0)
        assertTrue(0.0 <= vector1.z && vector1.z < 1.0)
        assertTrue(0.0 <= vector2.x && vector2.x < 1.0)
        assertTrue(0.0 <= vector2.y && vector2.y < 1.0)
        assertTrue(0.0 <= vector2.z && vector2.z < 1.0)
    }

    @Test
    fun testRandomMinMax() {
        val vector1 = Vector3.random(2.0, 3.0)
        val vector2 = Vector3.random(2.0, 4.0)

        assertNotEquals(vector1, vector2)
        assertTrue(2.0 <= vector1.x && vector1.x < 3.0)
        assertTrue(2.0 <= vector1.y && vector1.y < 3.0)
        assertTrue(2.0 <= vector1.z && vector1.z < 3.0)
        assertTrue(2.0 <= vector2.x && vector2.x < 4.0)
        assertTrue(2.0 <= vector2.y && vector2.y < 4.0)
        assertTrue(2.0 <= vector2.z && vector2.z < 4.0)
    }

    @Test
    fun testRandomInUnitSphere() {
        val vector1 = Vector3.randomInUnitSphere()
        val vector2 = Vector3.randomInUnitSphere()

        assertNotEquals(vector1, vector2)
        assertTrue(-1.0 <= vector1.x && vector1.x < 1.0)
        assertTrue(-1.0 <= vector1.y && vector1.y < 1.0)
        assertTrue(-1.0 <= vector1.z && vector1.z < 1.0)
        assertTrue(-1.0 <= vector2.x && vector2.x < 1.0)
        assertTrue(-1.0 <= vector2.y && vector2.y < 1.0)
        assertTrue(-1.0 <= vector2.z && vector2.z < 1.0)
    }

    @Test
    fun testRandomUnitVector() {
        val vector1 = Vector3.randomUnitVector()
        val vector2 = Vector3.randomUnitVector()

        assertNotEquals(vector1, vector2)
        assertTrue(-1.0 <= vector1.x && vector1.x < 1.0)
        assertTrue(-1.0 <= vector1.y && vector1.y < 1.0)
        assertTrue(-1.0 <= vector1.z && vector1.z < 1.0)
        assertTrue(-1.0 <= vector2.x && vector2.x < 1.0)
        assertTrue(-1.0 <= vector2.y && vector2.y < 1.0)
        assertTrue(-1.0 <= vector2.z && vector2.z < 1.0)
    }

    @Test
    fun testRandomInUnitDisk() {
        val vector1 = Vector3.randomInUnitDisk()
        val vector2 = Vector3.randomInUnitDisk()

        assertNotEquals(vector1, vector2)
        assertTrue(-1.0 <= vector1.x && vector1.x < 1.0)
        assertTrue(-1.0 <= vector1.y && vector1.y < 1.0)
        assertEquals(0.0, vector1.z, Math.ulp(0.0))
        assertTrue(-1.0 <= vector2.x && vector2.x < 1.0)
        assertTrue(-1.0 <= vector2.y && vector2.y < 1.0)
        assertEquals(0.0, vector2.z, Math.ulp(0.0))
    }

    @Test
    fun testNearZeroTrue() {
        val vector = Vector3(1e-20, 1e-20, 1e-20)

        assertTrue(vector.nearZero())
    }

    @Test
    fun testNearZeroFalse() {
        val vector = Vector3(1e-15, 1e-15, 1e-15)

        assertFalse(vector.nearZero())
    }

    @Test
    fun testReflect() {
        val vector = Vector3(1.0, 1.0, 0.0)
        val normal = Vector3(0.0, -1.0, 0.0)
        val reflected = vector.reflect(normal)

        assertEquals(1.0, reflected.x, Math.ulp(1.0))
        assertEquals(-1.0, reflected.y, Math.ulp(-1.0))
        assertEquals(0.0, reflected.z, Math.ulp(0.0))
    }

    @Test
    fun testRefract() {
        val vector = Vector3(1.0, 1.0, 0.0)
        val normal = Vector3(0.0, -1.0, 0.0)
        val refracted = vector.refract(normal, 1.0)

        assertEquals(1.0, refracted.x, Math.ulp(0.0))
        assertEquals(0.0, refracted.y, Math.ulp(0.0))
        assertEquals(0.0, refracted.z, Math.ulp(0.0))
    }
}