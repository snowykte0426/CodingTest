import java.util.*

data class Edge(val u: Int, val v: Int, val len: Int, val lum: Int, val id: Int)

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    
    val edges = mutableListOf<Edge>()
    edges.add(Edge(0, 0, 0, 0, 0))
    
    repeat(m) { i ->
        val (u, v, len, lum) = readLine()!!.split(" ").map { it.toInt() }
        edges.add(Edge(u, v, len, lum, i + 1))
        edges.add(Edge(v, u, len, lum, i + 1))
    }
    
    val edgeCount = edges.size - 1
    val sortedIdx = (1..edgeCount).sortedWith { a, b ->
        if (edges[a].u != edges[b].u) edges[a].u - edges[b].u
        else edges[a].lum - edges[b].lum
    }
    
    val start = Array(n + 1) { IntArray(2) { 1 } }
    val end = Array(n + 1) { IntArray(2) }
    
    for (i in 1..edgeCount) {
        end[edges[sortedIdx[i - 1]].u][0] = i
    }
    for (i in edgeCount downTo 1) {
        start[edges[sortedIdx[i - 1]].u][0] = i
    }
    
    for (i in 1..n) {
        start[i][1] = start[i][0]
        end[i][1] = end[i][0]
    }
    
    val dist = Array(edgeCount + 1) { LongArray(2) { Long.MAX_VALUE } }
    val visited = Array(edgeCount + 1) { BooleanArray(2) }
    val parent = Array(edgeCount + 1) { Array(2) { Pair(0, 0) } }
    
    val pq = PriorityQueue<Triple<Long, Int, Int>>(compareBy { it.first })
    
    fun extend(edgeIdx: Int, phase: Int, newDist: Long, p: Pair<Int, Int>) {
        if (visited[edgeIdx][phase]) return
        val totalDist = newDist + edges[edgeIdx].len
        visited[edgeIdx][phase] = true
        dist[edgeIdx][phase] = totalDist
        parent[edgeIdx][phase] = p
        pq.offer(Triple(totalDist, edgeIdx, phase))
    }
    
    for (i in 1..edgeCount) {
        if (edges[i].u == 1) {
            extend(i, 0, 0, Pair(0, 0))
        }
    }
    
    while (pq.isNotEmpty()) {
        val (d, edgeIdx, phase) = pq.poll()
        
        val targetNode = edges[edgeIdx].v
        
        while (start[targetNode][phase] <= end[targetNode][phase]) {
            val nextIdx = sortedIdx[end[targetNode][phase] - 1]
            if (edges[nextIdx].lum < edges[edgeIdx].lum) break
            extend(nextIdx, phase, d, Pair(edgeIdx, phase))
            end[targetNode][phase]--
        }
        
        if (targetNode == 2 && phase == 0) {
            while (start[targetNode][1] <= end[targetNode][1]) {
                val nextIdx = sortedIdx[end[targetNode][1] - 1]
                if (edges[nextIdx].lum < edges[edgeIdx].lum) break
                extend(nextIdx, 1, d, Pair(edgeIdx, phase))
                end[targetNode][1]--
            }
        }
    }
    
    var ans = Long.MAX_VALUE
    var bestPos = Pair(0, 0)
    
    for (i in 1..edgeCount) {
        if (edges[i].v == 1 && visited[i][1] && dist[i][1] < ans) {
            ans = dist[i][1]
            bestPos = Pair(i, 1)
        }
    }
    
    val path = mutableListOf<Int>()
    var curr = bestPos
    
    while (curr.first != 0) {
        path.add(edges[curr.first].id)
        curr = parent[curr.first][curr.second]
    }
    
    path.reverse()
    
    println(ans)
    println(path.joinToString(" "))
}
