class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for (query in queries) {
            val s = query[0]
            val e = query[1]
            val k = query[2]
            for (i in s..e) {
                if (i % k == 0 || i == 0) {
                    arr[i] += 1
                }
            }
        }
        return arr
    }
}
