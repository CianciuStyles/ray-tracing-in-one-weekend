package io.github.cianciustyles

class Lambertian(
    private val albedo: Color = Color.BLACK
) : Material() {
    override fun scatter(rayIn: Ray, hitRecord: HitRecord): Pair<Color, Ray> {
        var scatterDirection = hitRecord.normal + Vector3.randomUnitVector()

        // Catch degenerate scatter direction
        if (scatterDirection.nearZero()) scatterDirection = hitRecord.normal

        return Pair(albedo, Ray(hitRecord.point, scatterDirection))
    }
}