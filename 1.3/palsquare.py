"""
ID: rishiso1
LANG: PYTHON3
TASK: palsquare
"""
f = open("palsquare.in", "r")
w = open("palsquare.out", "w")

base = int(f.readline())

digs = {
    10 : "A",
    11 : "B",
    12 : "C",
    13 : "D",
    14 : "E",
    15 : "F",
    16 : "G",
    17 : "H",
    18 : "I",
    19 : "J"
}

def convert(num, b):
    res = []
    while num:
        x = int(num % b)
        if x > 9:
            x = digs[x]
        res.append(str(x))
        num //= b

    return "".join(res[::-1])


for num in range(1, 300):
    n = convert(num, base)
    n_s = convert(num ** 2, base)
    if n_s[::-1] == n_s:
        w.write(f"{n} {n_s}\n")
