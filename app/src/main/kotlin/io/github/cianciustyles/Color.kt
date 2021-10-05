package io.github.cianciustyles

class Color(
    private val r: Double,
    private val g: Double,
    private val b: Double
) : Vector3(r, g, b) {
    override fun toString(): String {
        val r = (255.999 * r).toInt()
        val g = (255.999 * g).toInt()
        val b = (255.999 * b).toInt()

        return "$r $g $b"
    }
}