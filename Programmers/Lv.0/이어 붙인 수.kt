class Solution {
    fun solution(num_list: IntArray): Int {
        var beforeAnswer = ""
        num_list.forEach {
            beforeAnswer += if (it % 2 != 0) {
                it.toString()
            } else {
                return@forEach
            }
        }
        var answer = beforeAnswer.toInt()
        beforeAnswer = ""
        num_list.forEach {
            beforeAnswer += if (it % 2 == 0) {
                it.toString()
            } else {
                return@forEach
            }
        }
        answer += beforeAnswer.toInt()
        return answer
    }
}
