package io.github.cianciustyles

import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

class Dielectric(
    private val indexOfRefraction: Double
) : Material() {
    override fun scatter(rayIn: Ray, hitRecord: HitRecord): Pair<Color, Ray> {
        val refractionRatio = if (hitRecord.frontFace) (1.0 / indexOfRefraction) else indexOfRefraction

        val unitDirection = rayIn.direction.unit()
        val cosTheta = min(-unitDirection dot hitRecord.normal, 1.0)
        val sinTheta = sqrt(1.0 - cosTheta * cosTheta)

        val cannotRefract = refractionRatio * sinTheta > 1.0
        val direction = if (cannotRefract || reflectance(cosTheta, refractionRatio) > Random.nextDouble()) {
            unitDirection.reflect(hitRecord.normal)
        } else {
            unitDirection.refract(hitRecord.normal, refractionRatio)
        }

        return Pair(Color.WHITE, Ray(hitRecord.point, direction))
    }

    private fun reflectance(cosine: Double, refractionRatio: Double): Double {
        // Use Schlick's approximation for reflectance.
        var r0 = (1.0 - refractionRatio) / (1.0 + refractionRatio)
        r0 *= r0
        return r0 + (1.0 - r0) * (1.0 - cosine).pow(5.0)
    }
}