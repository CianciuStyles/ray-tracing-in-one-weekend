package io.github.cianciustyles

class HittableList(
    val objects: MutableList<Hittable> = mutableListOf()
) : Hittable() {
    fun add(obj: Hittable) {
        objects.add(obj)
    }

    fun clear() {
        objects.clear()
    }

    override fun hit(ray: Ray, tMin: Double, tMax: Double): HitRecord? {
        var hitRecord: HitRecord? = null
        var closestSoFar = tMax

        for (obj in objects) {
            obj.hit(ray, tMin, closestSoFar)?.let {
                closestSoFar = it.t
                hitRecord = it
            }
        }

        return hitRecord
    }
}