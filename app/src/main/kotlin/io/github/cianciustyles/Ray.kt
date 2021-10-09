package io.github.cianciustyles

class Ray(
    val origin: Point3 = Point3(),
    val direction: Vector3 = Vector3()
) {
    private val white = Color(1.0, 1.0, 1.0)
    private val blue = Color(0.5, 0.7, 1.0)

    fun at(t: Double): Point3 =
        origin + direction * t

    fun rayColor(world: Hittable, depth: Int): Color {
        // If we've exceeded the ray bounce limit, no more light is gathered.
        if (depth <= 0) return Color(0.0, 0.0, 0.0)

        val hitRecord = world.hit(this, 0.001, Double.POSITIVE_INFINITY)
        if (hitRecord != null) {
            val target = hitRecord.point + hitRecord.normal + Vector3.randomUnitVector()
            val newRay = Ray(hitRecord.point, target - hitRecord.point)
            return newRay.rayColor(world, depth - 1) * 0.5
        }

        val unitDirection = direction.unit()
        val t: Double = (unitDirection.y + 1.0) * 0.5
        return white * (1.0 - t) + blue * t
    }
}