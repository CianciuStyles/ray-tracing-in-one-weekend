package io.github.cianciustyles

import kotlin.math.sqrt
import kotlin.random.Random

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

    operator fun times(color: Color) =
        Color(
            this.r * color.r,
            this.g * color.g,
            this.b * color.b
        )

    private fun clamp(x: Double) =
        when {
            x < 0.0 -> 0.0
            x > 0.999 -> 0.999
            else -> x
        }

    fun writeColor(samplesPerPixel: Int): String {
        val scale = 1.0 / samplesPerPixel
        val r = (256 * clamp(sqrt(r * scale))).toInt()
        val g = (256 * clamp(sqrt(g * scale))).toInt()
        val b = (256 * clamp(sqrt(b * scale))).toInt()

        return "$r $g $b"
    }

    companion object {
        fun random() =
            Color(
                Random.nextDouble(),
                Random.nextDouble(),
                Random.nextDouble()
            )

        fun random(min: Double, max: Double) =
            Color(
                Random.nextDouble(min, max),
                Random.nextDouble(min, max),
                Random.nextDouble(min, max)
            )

        val BLACK = Color(0.0, 0.0, 0.0)
        val BLUE = Color(0.5, 0.7, 1.0)
        val WHITE = Color(1.0, 1.0, 1.0)
    }
}