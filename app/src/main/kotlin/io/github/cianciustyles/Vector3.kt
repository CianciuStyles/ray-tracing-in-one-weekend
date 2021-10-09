package io.github.cianciustyles

import kotlin.math.sqrt
import kotlin.random.Random

data class Vector3(
    val x: Double = 0.0,
    val y: Double = 0.0,
    val z: Double = 0.0
) {
    operator fun unaryMinus(): Vector3 =
        Vector3(-x, -y, -z)

    operator fun plus(other: Vector3): Vector3 =
        Vector3(
            x + other.x,
            y + other.y,
            z + other.z
        )

    operator fun minus(other: Vector3): Vector3 =
        plus(-other)

    operator fun times(i: Int): Vector3 =
        Vector3(x * i, y * i, z * i)

    operator fun times(i: Double): Vector3 =
        Vector3(x * i, y * i, z * i)

    operator fun div(i: Int): Vector3 =
        Vector3(x / i, y / i, z / i)

    operator fun div(i: Double): Vector3 =
        Vector3(x / i, y / i, z / i)

    fun length(): Double =
        sqrt(lengthSquared())

    fun lengthSquared(): Double =
        x * x + y * y + z * z

    override fun toString(): String =
        "$x $y $z"

    infix fun dot(other: Vector3): Double =
        x * other.x + y * other.y + z * other.z

    infix fun cross(other: Vector3): Vector3 =
        Vector3(
            y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x
        )

    fun unit(): Vector3 {
        return this / this.length()
    }

    companion object {
        fun random(): Vector3 =
            Vector3(
                Random.nextDouble(),
                Random.nextDouble(),
                Random.nextDouble()
            )

        fun random(min: Double, max: Double) =
            Vector3(
                Random.nextDouble(min, max),
                Random.nextDouble(min, max),
                Random.nextDouble(min, max)
            )

        fun randomInUnitSphere(): Vector3 {
            while (true) {
                val vector = random(-1.0, 1.0)
                if (vector.lengthSquared() >= 1) continue
                return vector
            }
        }

        fun randomUnitVector() =
            randomInUnitSphere().unit()
    }
}