package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class Point3Test {
    @Test
    fun testPlusVector3() {
        val point = Point3(1.0, 2.0, 3.0)
        val vector = Vector3(2.0, 1.0, 3.0)
        val result = point + vector

        assertEquals(3.0, result.x, Math.ulp(3.0))
        assertEquals(3.0, result.y, Math.ulp(3.0))
        assertEquals(6.0, result.z, Math.ulp(6.0))
    }

    @Test
    fun testMinusVector3() {
        val point = Point3(1.0, 2.0, 3.0)
        val vector = Vector3(2.0, 1.0, 3.0)
        val result = point - vector

        assertEquals(-1.0, result.x, Math.ulp(-1.0))
        assertEquals(1.0, result.y, Math.ulp(1.0))
        assertEquals(0.0, result.z, Math.ulp(0.0))
    }

    @Test
    fun testMinusPoint3() {
        val point1 = Point3(1.0, 4.0, 3.0)
        val point2 = Point3(3.0, 1.0, 5.0)
        val result = point1 - point2

        assertEquals(-2.0, result.x, Math.ulp(-2.0))
        assertEquals(3.0, result.y, Math.ulp(3.0))
        assertEquals(-2.0, result.z, Math.ulp(-2.0))
    }
}