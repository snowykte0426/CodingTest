class Solution {
    fun solution(num_list: IntArray, n: Int): Int {
        for (i in num_list.indices) {
            if (num_list[i] == n) {
                return 1
            }
        }
        return 0
    }
}
