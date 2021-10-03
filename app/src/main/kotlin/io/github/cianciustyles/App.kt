/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package io.github.cianciustyles

import java.io.File

fun main() {
    // Image
    val imageWidth = 256
    val imageHeight = 256

    // Render
    File("image.ppm").bufferedWriter().use { image ->
        image.write("")
        image.write("P3\n")
        image.write("$imageWidth $imageHeight\n")
        image.write("255\n")

        for (j in (0 until imageHeight).reversed()) {
            System.err.println("Scanlines remaining: $j")

            for (i in 0 until imageWidth) {
                val r = i.toDouble() / (imageWidth - 1)
                val g = j.toDouble() / (imageHeight - 1)
                val b = 0.25

                val ir = (r * 255.999).toInt()
                val ig = (g * 255.999).toInt()
                val ib = (b * 255.999).toInt()

                image.write("$ir $ig $ib\n")
            }
        }
    }

    System.err.println("Done.")
}