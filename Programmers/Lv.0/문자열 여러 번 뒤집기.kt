class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String {
        val chars = my_string.toCharArray()
        for (query in queries) {
            var s = query[0]
            var e = query[1]
            while (s < e) {
                val temp = chars[s]
                chars[s] = chars[e]
                chars[e] = temp
                s++
                e--
            }
        }
        return String(chars)
    }
}
