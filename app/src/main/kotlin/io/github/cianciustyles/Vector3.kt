package io.github.cianciustyles

import kotlin.math.sqrt

open class Vector3(
    open val x: Double = 0.0,
    open val y: Double = 0.0,
    open val z: Double = 0.0
) {
    operator fun unaryMinus(): Vector3 =
        Vector3(-x, -y, -z)

    operator fun plus(other: Vector3): Vector3 =
        Vector3(
            x + other.x,
            y + other.y,
            z + other.z
        )

    operator fun times(i: Int): Vector3 =
        Vector3(x * i, y * i, z * i)

    operator fun times(i: Double): Vector3 =
        Vector3(x * i, y * i, z * i)

    operator fun div(i: Int): Vector3 =
        Vector3(x / i, y / i, z / i)

    operator fun div(i: Double): Vector3 =
        Vector3(x / i, y / i, z / i)

    fun length(): Double =
        sqrt(x * x + y * y + z * z)

    override fun toString(): String =
        "$x $y $z"

    infix fun dot(other: Vector3): Vector3 =
        Vector3(
            x * other.x,
            y * other.y,
            z * other.z
        )

    infix fun cross(other: Vector3): Vector3 =
        Vector3(
            y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x
        )

    fun unit(): Vector3 {
        return this / this.length()
    }
}