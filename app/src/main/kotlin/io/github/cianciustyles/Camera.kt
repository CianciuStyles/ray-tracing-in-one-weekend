package io.github.cianciustyles

class Camera {
    private var origin: Point3
    private var horizontal: Vector3
    private var vertical: Vector3
    private var lowerLeftCorner: Point3

    init {
        val aspectRatio = 16.0 / 9.0
        val viewportHeight = 2.0
        val viewportWidth = aspectRatio * viewportHeight
        val focalLength = 1.0

        origin = Point3(0.0, 0.0, 0.0)
        horizontal = Vector3(viewportWidth, 0.0, 0.0)
        vertical = Vector3(0.0, viewportHeight, 0.0)
        lowerLeftCorner = origin - horizontal / 2 - vertical / 2 - Vector3(0.0, 0.0, focalLength)
    }

    fun getRay(u: Double, v: Double) =
        Ray(
            origin,
            lowerLeftCorner + horizontal * u + vertical * v - origin
        )
}