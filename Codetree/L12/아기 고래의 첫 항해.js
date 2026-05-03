const fs = require('fs');
const input = fs.readFileSync(0, 'utf8').trim().split(/\s+/).map(Number);
let idx = 0;

const N = input[idx++];
let pos = (input[idx++] - 1) * N + (input[idx++] - 1);
let dir = input[idx++];

const size = N * N;
const sea = new Uint8Array(size);
const visited = new Uint8Array(size);

let total = 0;
for (let i = 0; i < size; i++) {
  const x = input[idx++];
  if (x === 0) sea[i] = 1, total++;
}

const dr = [0, -1, 1, 0, 0];
const dc = [0, 0, 0, -1, 1];
const mv = [0, -N, N, -1, 1];
const left = [0, 3, 4, 2, 1];
const right = [0, 4, 3, 1, 2];
const back = [0, 2, 1, 4, 3];
const pathPri = [3, 2, 4, 1];

const dist = new Int32Array(size);
const q = new Int32Array(size);
const ans = [];

const canGo = (p, d) => {
  const r = Math.floor(p / N), c = p % N;
  const nr = r + dr[d], nc = c + dc[d];
  return nr >= 0 && nc >= 0 && nr < N && nc < N;
};

visited[pos] = 1;
let count = 1;
ans.push(`${Math.floor(pos / N) + 1} ${pos % N + 1}`);

while (count < total) {
  let moved = true;

  while (moved) {
    moved = false;
    const order = [dir, left[dir], right[dir], back[dir]];

    for (const nd of order) {
      if (!canGo(pos, nd)) continue;
      const np = pos + mv[nd];
      if (sea[np] && !visited[np]) {
        pos = np;
        dir = nd;
        visited[pos] = 1;
        count++;
        ans.push(`${Math.floor(pos / N) + 1} ${pos % N + 1}`);
        moved = true;
        break;
      }
    }
  }

  if (count === total) break;

  dist.fill(-1);
  let h = 0, t = 0;
  q[t++] = pos;
  dist[pos] = 0;

  let target = -1, bestD = -1;

  while (h < t) {
    const cur = q[h++];
    const cd = dist[cur];

    if (bestD !== -1 && cd > bestD) break;

    if (!visited[cur]) {
      if (target === -1 || cur < target) target = cur;
      bestD = cd;
      continue;
    }

    for (let nd = 1; nd <= 4; nd++) {
      if (!canGo(cur, nd)) continue;
      const np = cur + mv[nd];
      if (sea[np] && dist[np] === -1) {
        dist[np] = cd + 1;
        q[t++] = np;
      }
    }
  }

  dist.fill(-1);
  h = 0, t = 0;
  q[t++] = target;
  dist[target] = 0;

  while (h < t) {
    const cur = q[h++];
    for (let nd = 1; nd <= 4; nd++) {
      if (!canGo(cur, nd)) continue;
      const np = cur + mv[nd];
      if (sea[np] && dist[np] === -1) {
        dist[np] = dist[cur] + 1;
        q[t++] = np;
      }
    }
  }

  while (pos !== target) {
    for (const nd of pathPri) {
      if (!canGo(pos, nd)) continue;
      const np = pos + mv[nd];
      if (sea[np] && dist[np] === dist[pos] - 1) {
        pos = np;
        dir = nd;
        break;
      }
    }
  }

  visited[pos] = 1;
  count++;
  ans.push(`${Math.floor(pos / N) + 1} ${pos % N + 1}`);
}

console.log(ans.join('\n'));
