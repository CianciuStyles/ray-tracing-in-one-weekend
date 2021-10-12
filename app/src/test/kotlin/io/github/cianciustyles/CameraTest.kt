package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class CameraTest {
    @Test
    fun testGetRay() {
        val lookFrom = Point3(0.0, 0.0, 0.0)
        val lookAt = Point3(0.0, 0.0, -1.0)
        val camera = Camera(
            lookFrom,
            lookAt,
            Vector3(0.0, 1.0, 0.0),
            90.0,
            16.0 / 9.0,
            0.0,
            (lookFrom - lookAt).length()
        )

        val ray = camera.getRay(0.5, 0.5)

        assertEquals(Point3(), ray.origin)
        assertEquals(Vector3(z = -1.0), ray.direction)
    }
}