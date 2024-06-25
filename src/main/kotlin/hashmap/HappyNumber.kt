package com.ngajjarwork.designpatterns.hashmap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/description
 */
class HappyNumber {

    fun isHappy(n: Int): Boolean {
        val hasVisited = hashSetOf<Int>()
        var number = n

        while (number != 1 && !hasVisited.contains(number)) {
            hasVisited.add(number)
            number = sumOfSquares(number)
        }
        return number == 1
    }

    private fun sumOfSquares(n: Int): Int {
        var sum = 0
        var num = n
        while (num > 0) {
            val lastDigit = num % 10
            num /= 10
            sum += (lastDigit * lastDigit)
        }
        println("Number $num => Sum = $sum")
        return sum
    }

    fun isHappy3(n: Int): Boolean {
        var slow = n
        var fast = n

        do {
            slow = sumOfSquares(slow)
            fast = sumOfSquares(sumOfSquares(fast))
        } while (slow != fast)

        return slow == 1
    }

    fun isHappy2(n: Int): Boolean {

        val hasVisited = HashMap<Int, Boolean>()
        var number = n
        while (true) {
            if (number < 10) {
                number *= number
            } else {
                val string = number.toString()
                var sum = 0
                for (digit in string) {
                    sum += digit.digitToInt() * digit.digitToInt()
                }
                number = sum
                println("Number $number => Sum = $sum")
            }

            if (number == 1) {
                return true
            } else if (hasVisited[number] == true) {
                return false
            } else {
                hasVisited[number] = true
            }
        }
    }


}


class HappyNumberTest {

    private val uat = HappyNumber()

    @Test
    fun testInput() {
        Assertions.assertTrue(uat.isHappy(19))
    }

    @Test
    fun testInput2() {
        Assertions.assertFalse(uat.isHappy(2))
    }

    @Test
    fun testInput3() {
        Assertions.assertTrue(uat.isHappy(7))
    }

}