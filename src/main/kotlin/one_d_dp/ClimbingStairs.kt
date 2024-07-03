package com.ngajjarwork.designpatterns.one_d_dp

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description
 */
class ClimbingStairs {

    private val climbStairsMap = hashMapOf(0 to 1, 1 to 1)

    fun climbStairs(n: Int): Int {
        return if (n < 2) {
            climbStairsMap[n] ?: 0 // Base case: 0 or 1 step
        } else {
            climbStairsMap.getOrPut(n) { // Calculate and cache if not found
                climbStairs(n - 1) + climbStairs(n - 2) // Fibonacci recurrence
            }
        }
    }
}

class ClimbingStairsTest {

    private val uat = ClimbingStairs()

    @Test
    fun testInput1() {
        Assertions.assertEquals(3, uat.climbStairs(3))
    }

    @Test
    fun testInput2() {
        Assertions.assertEquals(4, uat.climbStairs(4))
    }

    @Test
    fun testInput3() {
        Assertions.assertEquals(7, uat.climbStairs(5))
    }

//    @Test
//    fun testInput2(){
//        Assertions.assertEquals(5, 3)
//    }

}