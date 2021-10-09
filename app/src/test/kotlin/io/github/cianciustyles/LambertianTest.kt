package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class LambertianTest() {
    @Test
    fun testScatter() {
        val color = Color(0.5, 0.6, 0.7)
        val material = Lambertian(color)
        val normal = Vector3(1.0, 0.0, 1.0)
        val point = Point3()
        val hitRecord = HitRecord(
            point,
            normal,
            material,
            0.0,
            true
        )

        val rayIn = Ray()
        val (albedo, rayOut) = material.scatter(rayIn, hitRecord)

        assertEquals(albedo, color)
        assertNotEquals(rayIn, rayOut)
        assertEquals(point, rayOut.origin)
        assertNotEquals(normal, rayOut.direction)
    }
}