package io.github.cianciustyles

import kotlin.math.PI
import kotlin.math.tan

class Camera(
    lookFrom: Point3,
    lookAt: Point3,
    vectorUp: Vector3,
    verticalFieldOfView: Double,
    aspectRatio: Double,
    aperture: Double,
    focusDistance: Double
) {
    private val origin: Point3
    private val horizontal: Vector3
    private val vertical: Vector3
    private val lowerLeftCorner: Point3
    private val w: Vector3
    private val u: Vector3
    private val v: Vector3
    private val lensRadius: Double

    init {
        val theta = degreesToRadians(verticalFieldOfView)
        val h = tan(theta / 2)
        val viewportHeight = 2.0 * h
        val viewportWidth = aspectRatio * viewportHeight

        w = (lookFrom - lookAt).unit()
        u = (vectorUp cross w).unit()
        v = w cross u

        origin = lookFrom
        horizontal = u * viewportWidth * focusDistance
        vertical = v * viewportHeight * focusDistance
        lowerLeftCorner = origin - horizontal / 2 - vertical / 2 - w * focusDistance

        lensRadius = aperture / 2.0
    }

    fun getRay(s: Double, t: Double): Ray {
        val rd = Vector3.randomInUnitDisk() * lensRadius
        val offset = u * rd.x + v * rd.y

        return Ray(
            origin + offset,
            lowerLeftCorner + horizontal * s + vertical * t - origin - offset
        )
    }

    private fun degreesToRadians(degrees: Double) =
        degrees * PI / 180.0
}