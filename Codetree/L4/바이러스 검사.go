package main

import (
	"bufio"
	"os"
)

var r = bufio.NewReaderSize(os.Stdin, 1<<20)

func ni() int {
	n := 0
	c, _ := r.ReadByte()
	for c < '0' || c > '9' {
		c, _ = r.ReadByte()
	}
	for c >= '0' && c <= '9' {
		n = n*10 + int(c-'0')
		c, _ = r.ReadByte()
	}
	r.UnreadByte()
	return n
}

func itoa(x int64) string {
	if x == 0 {
		return "0"
	}
	b := make([]byte, 0, 20)
	for x > 0 {
		b = append(b, byte(x%10)+'0')
		x /= 10
	}
	for i, j := 0, len(b)-1; i < j; i, j = i+1, j-1 {
		b[i], b[j] = b[j], b[i]
	}
	return string(b)
}

func main() {
	n := ni()
	a := make([]int, n)
	for i := 0; i < n; i++ {
		a[i] = ni()
	}
	b, c := ni(), ni()
	var s int64
	for _, x := range a {
		s++
		if x > b {
			s += int64((x - b + c - 1) / c)
		}
	}
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	w.WriteString(itoa(s))
}
