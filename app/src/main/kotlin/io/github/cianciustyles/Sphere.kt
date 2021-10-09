package io.github.cianciustyles

import kotlin.math.sqrt

class Sphere(
    private val center: Point3 = Point3(),
    private val radius: Double = 0.0,
    private val material: Material
) : Hittable() {
    override fun hit(ray: Ray, tMin: Double, tMax: Double): HitRecord? {
        val oc = ray.origin - center
        val a = ray.direction.lengthSquared()
        val halfB = oc dot ray.direction
        val c = oc.lengthSquared() - radius * radius

        val discriminant = halfB * halfB - a * c
        if (discriminant < 0) return null
        val sqrtd = sqrt(discriminant)

        // Find the nearest root that lies in the acceptable range.
        var root = (-halfB - sqrtd) / a
        if (root < tMin || tMax < root) {
            root = (-halfB + sqrtd) / a
            if (root < tMin || tMax < root) return null
        }

        return hitRecord(ray, (ray.at(root) - center) / radius, material, root)
    }
}