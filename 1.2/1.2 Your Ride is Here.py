"""
ID: rishiso1
LANG: PYTHON3
TASK: ride
"""
f = open('ride.in', 'r')
w = open('ride.out', 'w')

alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

prod1 = 1
prod2 = 1
arr = (f.read()).split("\n")
for i in arr[0]:
    prod1 *= alpha.find(i) + 1
for i in arr[1]:
    prod2 *= alpha.find(i) + 1


if prod1 % 47 == prod2 % 47:
    w.write("GO\n")

else:
    w.write("STAY\n")