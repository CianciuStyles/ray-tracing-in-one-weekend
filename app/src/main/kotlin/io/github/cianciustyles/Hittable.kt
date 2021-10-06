package io.github.cianciustyles

abstract class Hittable {
    open fun hit(r: Ray, tMin: Double, tMax: Double): HitRecord? = null

    fun hitRecord(r: Ray, outwardNormal: Vector3, t: Double): HitRecord {
        val frontFace = r.direction dot outwardNormal < 0
        val normal = if (frontFace) outwardNormal else -outwardNormal

        return HitRecord(
            r.at(t),
            normal,
            t,
            frontFace
        )
    }
}