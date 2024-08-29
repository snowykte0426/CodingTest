class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playerMap = players.withIndex().associate { it.value to it.index }.toMutableMap()
        val playerList = players.toMutableList()
        for (calling in callings) {
            val index = playerMap[calling]!!
            if (index > 0) {
                val prevPlayer = playerList[index - 1]
                playerList[index] = prevPlayer
                playerList[index - 1] = calling
                playerMap[calling] = index - 1
                playerMap[prevPlayer] = index
            }
        }
        return playerList.toTypedArray()
    }
}

fun main() {
    val players: Array<String> = arrayOf("mumu", "soe", "poe", "kai", "mine")
    val callings: Array<String> = arrayOf("kai", "kai", "mine", "mine")
    val result = Solution().solution(players, callings)
    println(result.joinToString(", "))
}
