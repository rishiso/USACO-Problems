"""
ID: rishiso1
LANG: PYTHON3
TASK: dualpal
"""
f = open("dualpal.in", "r")
w = open("dualpal.out", "w")

cont = f.readline().rstrip("\n")
cont = cont.split(" ")
p_amount = int(cont[0])
n = int(cont[1]) + 1

print(cont)


def convert(num, b):
    res = []
    while num:
        res.append(str(int(num % b)))
        num //= b
    return "".join(res[::-1])


count_of_p = 0

while p_amount != count_of_p:
    count = 0
    for b in range(2, 11):
        x = convert(n, b)
        if x == x[::-1]:
            count += 1
            if count == 2:
                count_of_p += 1
                w.write(str(n) + "\n")
    n += 1

