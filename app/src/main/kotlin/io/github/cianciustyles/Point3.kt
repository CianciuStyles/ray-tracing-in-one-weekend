package io.github.cianciustyles

data class Point3(
    val x: Double = 0.0,
    val y: Double = 0.0,
    val z: Double = 0.0
) {
    operator fun plus(other: Vector3): Point3 =
        Point3(
            x + other.x,
            y + other.y,
            z + other.z
        )

    operator fun minus(vector: Vector3): Point3 =
        plus(-vector)

    operator fun minus(point: Point3): Vector3 =
        Vector3(
            x - point.x,
            y - point.y,
            z - point.z
        )
}