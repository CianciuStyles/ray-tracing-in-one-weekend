package io.github.cianciustyles

class Metal(
    private val albedo: Color = Color.BLACK,
    private var fuzz: Double
) : Material() {
    init {
        if (fuzz > 1) fuzz = 1.0
    }

    override fun scatter(rayIn: Ray, hitRecord: HitRecord): Pair<Color?, Ray?> {
        val reflected = rayIn.direction.unit().reflect(hitRecord.normal)
        val scattered = Ray(hitRecord.point, reflected + Vector3.randomInUnitSphere() * fuzz)
        return when {
            scattered.direction dot hitRecord.normal > 0 -> Pair(albedo, scattered)
            else -> Pair(null, null)
        }
    }
}