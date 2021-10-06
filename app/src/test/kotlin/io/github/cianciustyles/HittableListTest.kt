package io.github.cianciustyles

import org.junit.Assert.*
import org.junit.Test

class HittableListTest {
    @Test
    fun testDefaultConstructor() {
        val hittableList = HittableList()

        assertEquals(0, hittableList.objects.size)
    }

    @Test
    fun testConstructor() {
        val hittableList = HittableList(mutableListOf(Sphere()))

        assertEquals(1, hittableList.objects.size)
    }

    @Test
    fun testAdd() {
        val hittableList = HittableList()
        assertEquals(0, hittableList.objects.size)

        hittableList.add(Sphere())
        assertEquals(1, hittableList.objects.size)
    }

    @Test
    fun testClear() {
        val hittableList = HittableList(mutableListOf(Sphere()))
        assertEquals(1, hittableList.objects.size)

        hittableList.clear()
        assertEquals(0, hittableList.objects.size)
    }
}