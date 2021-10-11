package io.github.cianciustyles

import kotlin.math.PI
import kotlin.math.tan

class Camera(
    lookFrom: Point3,
    lookAt: Point3,
    vectorUp: Vector3,
    verticalFieldOfView: Double,
    aspectRatio: Double
) {
    private val origin: Point3
    private val horizontal: Vector3
    private val vertical: Vector3
    private val lowerLeftCorner: Point3

    init {
        val theta = degreesToRadians(verticalFieldOfView)
        val h = tan(theta / 2)
        val viewportHeight = 2.0 * h
        val viewportWidth = aspectRatio * viewportHeight

        val w = (lookFrom - lookAt).unit()
        val u = (vectorUp cross w).unit()
        val v = w cross u

        origin = lookFrom
        horizontal = u * viewportWidth
        vertical = v * viewportHeight
        lowerLeftCorner = origin - horizontal / 2 - vertical / 2 - w
    }

    fun getRay(u: Double, v: Double) =
        Ray(
            origin,
            lowerLeftCorner + horizontal * u + vertical * v - origin
        )

    private fun degreesToRadians(degrees: Double) =
        degrees * PI / 180.0
}