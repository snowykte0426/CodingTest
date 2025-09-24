func solution(arr [][]int) [][]int {
    rows := len(arr)
    cols := len(arr[0])
    maxSize := rows
    if cols > maxSize {
        maxSize = cols
    }
    result := make([][]int, maxSize)
    for i := 0; i < maxSize; i++ {
        result[i] = make([]int, maxSize)
        if i < rows {
            copy(result[i][:min(cols, maxSize)], arr[i])
        }
    }
    return result
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
