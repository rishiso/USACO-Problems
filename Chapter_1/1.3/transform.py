"""
ID: rishiso1
LANG: PYTHON3
TASK: transform
"""

f = open('transform.in', 'r')
w = open('transform.out', 'w')

cont = f.read()
cont = cont.split("\n")
del cont[-1]

size = int(cont[0])
del cont[0]

original = cont[:size]
del cont[:size]
final = cont

print(final)

def ninety(arr):
    res = []
    for i in range(len(arr)):
        row = ""
        for r in reversed(arr):
            row += r[i]
        res.append(row)
    return res

def oneEighty(arr):
    res = []
    for i in reversed(range(len(arr))):
        res.append(arr[i][::-1])
    return res

def twoSeventy(arr):
    res = []
    for i in reversed(range(len(arr))):
        row = ""
        for r in arr:
            row += r[i]
        res.append(row)
    return res

def horizontal(arr):
    return [e[::-1] for e in arr]

if ninety(original) == final:
    w.write("1\n")
elif oneEighty(original) == final:
    w.write("2\n")
elif twoSeventy(original) == final:
    w.write("3\n")
elif horizontal(original) == final:
    w.write("4\n")
elif ninety(horizontal(original)) == final or oneEighty(horizontal(original)) == final or twoSeventy(horizontal(original)) == final:
    w.write("5\n")
elif original == final:
    w.write("6\n")
else:
    w.write("7\n")
