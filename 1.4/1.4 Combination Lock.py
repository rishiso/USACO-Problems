"""
ID: rishiso1
LANG: PYTHON3
TASK: combo
"""
f = open("combo.in", "r")
w = open("combo.out", "w")

cont = f.read().split("\n")
del cont[-1]

l = int(cont[0])
lock = [e for e in range(1, l + 1)]
combo_one = [int(e) for e in cont[1].split(" ")]
combo_two = [int(e) for e in cont[2].split(" ")]

def permutate(arr, i):
    if i == 3:
        return arr
    else:
        res = []
        for combo in arr:
            ind = combo[i] - 3
            digits = lock[ind:] + lock[:ind]
            digits = digits[:5]
            for num in digits:
                x = combo[:]
                x[i] = num
                res.append(x)

        return permutate(res, i + 1)


x = permutate([combo_one] , 0)
for e in permutate([combo_two], 0):
    if e not in x:
        x.append(e)

w.write(str(len(x)) + "\n")