package io.github.cianciustyles

abstract class Hittable {
    abstract fun hit(ray: Ray, tMin: Double, tMax: Double): HitRecord?

    fun hitRecord(ray: Ray, outwardNormal: Vector3, material: Material, t: Double): HitRecord {
        val frontFace = ray.direction dot outwardNormal < 0
        val normal = if (frontFace) outwardNormal else -outwardNormal

        return HitRecord(
            ray.at(t),
            normal,
            material,
            t,
            frontFace
        )
    }
}