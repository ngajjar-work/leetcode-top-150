package com.ngajjarwork.designpatterns.interval

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.math.min

/***
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/description/
 */
class InsertInterval {


    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        //return new interval as a result
        if (intervals.isEmpty()) {
            return arrayOf(newInterval)
        }


        var i = 0
        val result = mutableListOf<IntArray>()


        // Add all intervals that end before the new interval starts
        while (i < intervals.size && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i])
            i++
        }


        // Merge overlapping intervals
        while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = minOf(newInterval[0], intervals[i][0])
            newInterval[1] = maxOf(newInterval[1], intervals[i][1])
            i++
        }

        result.add(newInterval)

        // Add the remaining intervals
        while (i < intervals.size) {
            result.add(intervals[i])
            i++
        }

        return result.toTypedArray()

    }

    fun insert2(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        if (intervals.isEmpty()) {
            return arrayOf(newInterval)
        }


        val result = mutableListOf(intervals[0])

        var lastInterval = result.last()
        var index = 1
        var isNewIntervalAdded = false


        while (index < intervals.size) {
            val currentInterval = intervals[index]

            //new not added and
            if (!isNewIntervalAdded && currentInterval[0] >= newInterval[0]) {
                if (newInterval[1] < lastInterval[0]) {
                    result.add(0, newInterval)
                } else if (lastInterval[1] < newInterval[0]) {
                    result.add(newInterval)
                } else {
                    lastInterval[0] = min(lastInterval[0], newInterval[0])
                    lastInterval[1] = max(lastInterval[1], newInterval[1])
                }
                isNewIntervalAdded = true
            } else if (lastInterval[1] >= currentInterval[0]) {
                lastInterval[1] = max(lastInterval[1], currentInterval[1])
                index++
            } else {
                result.add(currentInterval)
                index++
            }
            lastInterval = result.last()
        }

        if (!isNewIntervalAdded) {
            if (newInterval[1] < lastInterval[0]) {
                result.add(0, newInterval)
            } else if (lastInterval[1] < newInterval[0]) {
                result.add(newInterval)
            } else {
                lastInterval[1] = max(lastInterval[1], newInterval[1])
                lastInterval[0] = min(lastInterval[0], newInterval[0])
            }
        }
        return result.toTypedArray()
    }
}

class InsertIntervalTest {

    val uat = InsertInterval()

    @Test
    fun testInput() {
        Assertions.assertArrayEquals(
            arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
            uat.insert(arrayOf(intArrayOf(1, 3), intArrayOf(8, 10), intArrayOf(15, 18)), intArrayOf(2, 6)),
        )
    }

    @Test
    fun testInput2() {
        Assertions.assertArrayEquals(
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 10), intArrayOf(15, 18)),
            uat.insert(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18)
                ), intArrayOf(4, 8)
            ),
        )
    }

    @Test
    fun testInput3() {
        Assertions.assertArrayEquals(
            arrayOf(intArrayOf(0, 5)),
            uat.insert(arrayOf(intArrayOf(1, 5)), intArrayOf(0, 3)),
        )
    }

    @Test
    fun testInput4() {
        Assertions.assertArrayEquals(
            arrayOf(intArrayOf(0, 0), intArrayOf(1, 5)),
            uat.insert(arrayOf(intArrayOf(1, 5)), intArrayOf(0, 0)),
        )
    }

    //[2,5],[6,7],[8,9] | , [0,1]

    @Test
    fun testInput5() {
        Assertions.assertArrayEquals(
            arrayOf(intArrayOf(0, 9)),
            uat.insert(arrayOf(intArrayOf(1, 5), intArrayOf(6, 8)), intArrayOf(0, 9)),
        )
    }

    @Test
    fun testInput6() {
        Assertions.assertArrayEquals(
            arrayOf(intArrayOf(0, 1), intArrayOf(2, 5), intArrayOf(6, 7), intArrayOf(8, 9)),
            uat.insert(arrayOf(intArrayOf(2, 5), intArrayOf(6, 7), intArrayOf(8, 9)), intArrayOf(0, 1))
        )
    }
}