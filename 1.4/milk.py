"""
ID: rishiso1
LANG: PYTHON3
TASK: milk
"""
f = open("milk.in", "r")
w = open("milk.out", "w")

cont = f.read().split("\n")
del cont[-1]

needs = cont[0].split(" ")
needs = int(needs[0])
del cont[0]

farmers = []
for farmer in cont:
    x = farmer.split(" ")
    x[0] = int(x[0])
    x[1] = int(x[1])
    farmers.append(x)

farmers.sort()

current_milk = 0
cost = 0

for farmer in farmers:
    if current_milk == needs:
        break
    else:
        milk_bought = min(farmer[1], needs - current_milk)
        current_milk += milk_bought
        cost += farmer[0] * milk_bought


w.write(str(cost) + "\n")
