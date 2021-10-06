package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class SphereTest {
    @Test
    fun testHitBeforeTmin() {
        val sphere = Sphere(
            Point3(0.0, 0.0, 1.0),
            0.5
        )
        val ray = Ray(
            Point3(0.0, 0.0, -1.0),
            Vector3(0.0, 0.0, 1.0)
        )

        assertNull(sphere.hit(ray, 0.9, 1.1))
    }

    @Test
    fun testHitBetweenTminAndTmax() {
        val sphere = Sphere(
            Point3(0.0, 0.0, 1.0),
            0.5
        )
        val ray = Ray(
            Point3(0.0, 0.0, -1.0),
            Vector3(0.0, 0.0, 1.0)
        )

        assertNotNull(sphere.hit(ray, 0.2, 1.8))
    }

    @Test
    fun testHitAfterTmax() {
        val sphere = Sphere(
            Point3(0.0, 0.0, 1.0),
            0.5
        )
        val ray = Ray(
            Point3(0.0, 0.0, -1.0),
            Vector3(0.0, 0.0, 1.0)
        )

        assertNull(sphere.hit(ray, 0.2, 0.3))
    }

    @Test
    fun testHitRecordFrontFace() {
        val sphere = Sphere(
            Point3(0.0, 0.0, 1.0),
            0.5
        )
        val ray = Ray(
            Point3(0.0, 0.0, -1.0),
            Vector3(0.0, 0.0, 1.0)
        )

        val outwardNormal = Vector3(0.0, 0.0, -1.0)
        val hitRecord = sphere.hitRecord(ray, outwardNormal, 0.5)

        assertEquals(outwardNormal, hitRecord.normal)
        assertTrue(hitRecord.frontFace)
    }

    @Test
    fun testHitRecordBackFace() {
        val sphere = Sphere(
            Point3(0.0, 0.0, 1.0),
            0.5
        )
        val ray = Ray(
            Point3(0.0, 0.0, -1.0),
            Vector3(0.0, 0.0, 1.0)
        )

        val outwardNormal = Vector3(0.0, 0.0, 1.0)
        val hitRecord = sphere.hitRecord(ray, outwardNormal, 1.5)

        assertEquals(-outwardNormal, hitRecord.normal)
        assertFalse(hitRecord.frontFace)
    }
}