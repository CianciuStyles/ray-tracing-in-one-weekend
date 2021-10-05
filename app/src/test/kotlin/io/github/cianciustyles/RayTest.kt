package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class RayTest {
    @Test
    fun testAtX() {
        val origin = Point3(0.0, 0.0, 0.0)
        val direction = Vector3(1.0, 0.0, 0.0)
        val ray = Ray(origin, direction)

        val expected = Point3(2.0, 0.0, 0.0)
        assertEquals(expected, ray.at(2.0))
    }

    @Test
    fun testAtY() {
        val origin = Point3(0.0, 0.0, 0.0)
        val direction = Vector3(0.0, 3.0, 0.0)
        val ray = Ray(origin, direction)

        val expected = Point3(0.0, 9.0, 0.0)
        assertEquals(expected, ray.at(3.0))
    }

    @Test
    fun testAtZ() {
        val origin = Point3(0.0, 0.0, 0.0)
        val direction = Vector3(0.0, 0.0, 2.0)
        val ray = Ray(origin, direction)

        val expected = Point3(0.0, 0.0, 8.0)
        assertEquals(expected, ray.at(4.0))
    }
}