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

    private fun clamp(x: Double) =
        when {
            x < 0.0 -> 0.0
            x > 0.999 -> 0.999
            else -> x
        }

    fun writeColor(samplesPerPixel: Int): String {
        val scale = 1.0 / samplesPerPixel
        val r = (256 * clamp(r * scale)).toInt()
        val g = (256 * clamp(g * scale)).toInt()
        val b = (256 * clamp(b * scale)).toInt()

        return "$r $g $b"
    }
}