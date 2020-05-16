"""
ID: rishiso1
LANG: PYTHON3
TASK: gift1
"""

f = open("gift1.in", "r")
w = open("gift1.out", "w")

cont = f.read().split("\n")
numFriends = int(cont[0])
friends = {e: 0 for e in cont[1:numFriends + 1]}
cont = cont[numFriends + 1:]

for peep in friends:
    person = cont[0]
    nums = cont[1].split(" ")
    money = int(nums[0])
    gifts = int(nums[1])
    if gifts > 0:
        amount = money // gifts
    else:
        amount = 0
    friends[person] -= amount * gifts

    for gift in cont[2:2+gifts]:
        friends[gift] += amount

    del cont[:2 + gifts]


for index, value in friends.items():
    w.write(index + " " + str(value) + "\n")
