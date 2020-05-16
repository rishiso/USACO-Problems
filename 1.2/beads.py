"""
ID: rishiso1
LANG: PYTHON3
TASK: beads
"""
f = open('beads.in', 'r')
w = open('beads.out', 'w')

cont = f.read().split("\n")
num_beads = int(cont[0])
seq = cont[1]
seq_r = seq[::-1]
res = 0


def blue(sequence):
    return len(sequence[:sequence.find("r")])


def red(sequence):
    return len(sequence[:sequence.find("b")])


for bead in range(num_beads):
    right = seq[bead:] + seq[:bead]
    left = seq_r[-bead:] + seq_r[:-bead]
    left_high = max(blue(left), red(left))
    right_high = max(blue(right), red(right))
    s = right_high + left_high
    if s > res:
        res = s

if res > num_beads:
    res = num_beads

w.write(str(res) + "\n")
