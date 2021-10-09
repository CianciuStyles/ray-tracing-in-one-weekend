package io.github.cianciustyles

abstract class Material {
    abstract fun scatter(rayIn: Ray, hitRecord: HitRecord): Pair<Color?, Ray?>
}