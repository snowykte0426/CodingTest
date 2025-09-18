class Solution {
    fun solution(start_num: Int, end_num: Int): IntArray {
        val answer = arrayListOf<Int>()
        for (i in start_num..end_num) {
            answer.add(i)
        }
        return IntArray(answer.size) { answer[it] }
    }
}
