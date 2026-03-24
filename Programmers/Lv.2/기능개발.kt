class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        if (progresses.isEmpty()) return intArrayOf()
        val days = IntArray(progresses.size) { i ->
            val remain = 100 - progresses[i]
            (remain + speeds[i] - 1) / speeds[i]
        }
        val result = mutableListOf<Int>()
        var current = days[0]
        var count = 1
        for (i in 1 until days.size) {
            if (days[i] <= current) {
                count++
            } else {
                result.add(count)
                current = days[i]
                count = 1
            }
        }
        result.add(count)
        return result.toIntArray()
    }
}
