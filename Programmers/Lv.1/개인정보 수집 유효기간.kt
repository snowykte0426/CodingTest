class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val todayDate = today.split(".").map { it.toInt() }
        val termsMap = mutableMapOf<String, Int>()
        for (term in terms) {
            val (termType, termDuration) = term.split(" ")
            termsMap[termType] = termDuration.toInt()
        }
        val expiredList = mutableListOf<Int>()
        for (i in privacies.indices) {
            val (privacyDate, privacyTerm) = privacies[i].split(" ")
            val (year, month, day) = privacyDate.split(".").map { it.toInt() }
            val duration = termsMap[privacyTerm] ?: 0
            var newMonth = month + duration
            var newYear = year
            while (newMonth > 12) {
                newYear += 1
                newMonth -= 12
            }
            if (newYear < todayDate[0] ||
                (newYear == todayDate[0] && newMonth < todayDate[1]) ||
                (newYear == todayDate[0] && newMonth == todayDate[1] && day <= todayDate[2])) {
                expiredList.add(i + 1)
            }
        }
        return expiredList.toIntArray()
    }
}
