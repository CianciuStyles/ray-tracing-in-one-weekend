package io.github.cianciustyles

class Ray(
    private val origin: Point3,
    private val direction: Vector3
) {
    private val white = Color(1.0, 1.0, 1.0)
    private val blue = Color(0.5, 0.7, 1.0)

    fun at(t: Double): Point3 =
        origin + direction * t

    fun rayColor(): Color {
        val unitDirection = direction.unit()
        val t: Double = (unitDirection.y + 1.0) * 0.5
        return white * (1.0 - t) + blue * t
    }
}