"""
ID: rishiso1
LANG: PYTHON3
TASK: test
"""
with open("test.in", "r") as fin:
    arr = fin.readline().split()
    s = sum([int(e) for e in arr])
    with open("test.out", "w") as fout:
        fout.write(str(s) + "\n")