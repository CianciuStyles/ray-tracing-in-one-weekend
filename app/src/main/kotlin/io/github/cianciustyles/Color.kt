package io.github.cianciustyles

data class Color(
    val r: Double,
    val g: Double,
    val b: Double
) {
    operator fun plus(other: Color): Color =
        Color(
            r + other.r,
            g + other.g,
            b + other.b
        )

    operator fun times(i: Double): Color =
        Color(r * i, g * i, b * i)

    operator fun times(i: Int): Color =
        Color(r * i, g * i, b * i)

    override fun toString(): String {
        val r = (255.999 * r).toInt()
        val g = (255.999 * g).toInt()
        val b = (255.999 * b).toInt()

        return "$r $g $b"
    }
}