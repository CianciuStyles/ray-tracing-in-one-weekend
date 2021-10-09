package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class RayTest {
    @Test
    fun testAtX() {
        val ray = Ray(
            direction = Vector3(1.0, 0.0, 0.0)
        )

        val expected = Point3(2.0, 0.0, 0.0)
        assertEquals(expected, ray.at(2.0))
    }

    @Test
    fun testAtY() {
        val ray = Ray(
            direction = Vector3(0.0, 3.0, 0.0)
        )

        val expected = Point3(0.0, 9.0, 0.0)
        assertEquals(expected, ray.at(3.0))
    }

    @Test
    fun testAtZ() {
        val ray = Ray(
            direction = Vector3(0.0, 0.0, 2.0)
        )

        val expected = Point3(0.0, 0.0, 8.0)
        assertEquals(expected, ray.at(4.0))
    }

    @Test
    fun testRayColorZeroDepth() {
        val ray = Ray()
        val metalColor = Color(0.5, 0.6, 0.7)
        val hittable = Sphere(material = Lambertian())

        val rayColor = ray.rayColor(hittable, 0)

        assertNotEquals(rayColor, metalColor)
        assertEquals(rayColor, Color.BLACK)
    }

    @Test
    fun testRayColorNoHit() {
        val direction = Vector3(z = 1.0)
        val ray = Ray(direction = direction)
        val hittable = Sphere(material = Lambertian())

        val rayColor = ray.rayColor(hittable, 1000)

        assertNotEquals(Color.BLACK, rayColor)

        val t = (direction.unit().y + 1.0) * 0.5
        assertEquals(Color.WHITE * (1.0 - t) + Color.BLUE * t, rayColor)
    }
}