package main

import (
"bufio"
"fmt"
"os"
"sort"
)

func main() {
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer func(w *bufio.Writer) {
		err := w.Flush()
		if err != nil {
			panic(err)
		}
	}(w)
	var n int
	_, _ = fmt.Fscan(r, &n)
	a := make([]int, n)
	for i := 0; i < n; i++ {
		_, _ = fmt.Fscan(r, &a[i])
	}
	sort.Ints(a)
	p := make([]int, n+1)
	for i := 0; i < n; i++ {
		p[i+1] = p[i] + a[i]
	}
	var k int
	_, _ = fmt.Fscan(r, &k)
	o := 0
	for i := 0; i < k; i++ {
		var x int
		_, _ = fmt.Fscan(r, &x)
		o += x
		l, h := 0, n
		for l < h {
			m := (l + h) / 2
			if a[m]+o < 0 {
				l = m + 1
			} else {
				h = m
			}
		}
		s := 0
		if l > 0 {
			s -= p[l] + o*l
		}
		if l < n {
			s += (p[n] - p[l]) + o*(n-l)
		}
		_, _ = fmt.Fprintln(w, s)
	}
}
