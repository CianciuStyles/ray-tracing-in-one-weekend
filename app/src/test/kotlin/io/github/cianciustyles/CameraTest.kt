package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class CameraTest {
    @Test
    fun testGetRay() {
        val camera = Camera()

        val ray = camera.getRay(0.5, 0.5)

        assertEquals(Point3(), ray.origin)
        assertEquals(Vector3(z = -1.0), ray.direction)
    }
}