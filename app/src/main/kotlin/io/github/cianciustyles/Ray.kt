package io.github.cianciustyles

class Ray(
    val origin: Point3 = Point3(),
    val direction: Vector3 = Vector3()
) {
    fun at(t: Double): Point3 =
        origin + direction * t

    fun rayColor(world: Hittable, depth: Int): Color {
        // If we've exceeded the ray bounce limit, no more light is gathered.
        if (depth <= 0) return Color.BLACK

        val hitRecord = world.hit(this, 0.001, Double.POSITIVE_INFINITY)
        if (hitRecord != null) {
            val (attenuation, scatteredRay) = hitRecord.material.scatter(this, hitRecord)
            return if (attenuation != null && scatteredRay != null)
                scatteredRay.rayColor(world, depth - 1) * attenuation
            else
                Color.BLACK
        }

        val unitDirection = direction.unit()
        val t: Double = (unitDirection.y + 1.0) * 0.5
        return Color.WHITE * (1.0 - t) + Color.BLUE * t
    }
}