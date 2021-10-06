package io.github.cianciustyles

class Ray(
    val origin: Point3 = Point3(),
    val direction: Vector3 = Vector3()
) {
    private val white = Color(1.0, 1.0, 1.0)
    private val blue = Color(0.5, 0.7, 1.0)

    fun at(t: Double): Point3 =
        origin + direction * t

    fun rayColor(world: Hittable): Color {
        val hitRecord = world.hit(this, 0.0, Double.POSITIVE_INFINITY)
        if (hitRecord != null) {
            return Color(hitRecord.normal.x + 1, hitRecord.normal.y + 1, hitRecord.normal.z + 1) * 0.5
        }

        val unitDirection = direction.unit()
        val t: Double = (unitDirection.y + 1.0) * 0.5
        return white * (1.0 - t) + blue * t
    }
}