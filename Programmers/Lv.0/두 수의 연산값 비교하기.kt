import kotlin.math.max

class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = max(fun1(a, b), fun2(a, b))
        return answer
    }
    
    private fun fun1(a: Int, b: Int): Int {
        return (a.toString() + b.toString()).toInt()
    }
    
    private fun fun2(a: Int, b: Int): Int {
        return 2 * a * b
    }
}
