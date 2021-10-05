package io.github.cianciustyles

class Ray(
    private val origin: Point3,
    private val direction: Vector3
) {
    private val white = Color(1.0, 1.0, 1.0)
    private val blue = Color(0.5, 0.7, 1.0)
    private val red = Color(1.0, 0.0, 0.0)

    fun at(t: Double): Point3 =
        origin + direction * t

    fun rayColor(): Color {
        if (hitSphere(Point3(0.0, 0.0, -1.0), 0.5))
            return red

        val unitDirection = direction.unit()
        val t: Double = (unitDirection.y + 1.0) * 0.5
        return white * (1.0 - t) + blue * t
    }

    private fun hitSphere(center: Point3, radius: Double): Boolean {
        val oc = origin - center
        val a = direction dot direction
        val b = oc dot direction * 2.0
        val c = (oc dot oc) - radius * radius
        val discriminant = b * b - 4 * a * c
        return discriminant > 0
    }
}