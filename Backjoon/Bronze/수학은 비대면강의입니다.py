def math_uncontacted():
    a, b, c, d, e, f = input().split()
    a = int(a)
    b = int(b)
    c = int(c)
    d = int(d)
    e = int(e)
    f = int(f)
    for i in range(-999, 1000):
        for j in range(-999, 1000):
            if a * i + b * j == c and d * i + e * j == f:
                print(f"{i} {j}")
    return None


math_uncontacted()
