"""
ID: rishiso1
LANG: PYTHON3
TASK: barn1
"""
f = open("barn1.in", "r")
w = open("barn1.out", "w")

cont = f.read().split("\n")
del cont[-1]

info = cont[0].split(" ")
num_stalls = int(info[2])
num_boards = int(info[0])
del cont[0]

stalls = [int(e) for e in cont]
stalls.sort()
gaps = []

for i in range(1, num_stalls):
    if stalls[i - 1] + 1 != stalls[i]:
        gaps.append(stalls[i] - stalls[i-1] - 1)


gaps.sort(reverse=True)
filled_empty = sum(gaps[:num_boards - 1])

r = stalls[-1] - stalls[0] + 1

w.write(str(r - filled_empty) + "\n")
