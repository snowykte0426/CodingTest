class Solution {
    fun solution(n: Int): IntArray {
        var n = n
        val answer: ArrayList<Int> = arrayListOf<Int>()
        answer.add(n)
        while (n != 1) {
            if (n % 2 == 0) {
                answer.add(n / 2)
                n /= 2
            } else {
                answer.add(3 * n + 1)
                n = 3 * n + 1
            }
        }
        return IntArray(answer.size) { answer[it] }
    }
}
