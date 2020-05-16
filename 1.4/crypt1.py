"""
ID: rishiso1
LANG: PYTHON3
TASK: crypt1
"""
f = open("crypt1.in", "r")
w = open("crypt1.out", "w")

cont = f.read().split("\n")

digits = [e for e in cont[1].split(" ")]

def permutate(arr, i, l):
    if i == l:
        return arr
    else:
        res = []
        for num in arr:
            for digit in digits:
                new_num = num[:i] + digit + num[i + 1:]
                res.append(new_num)
        return(permutate(res, i + 1, l))


i_word = digits[0] * 2
two_digit = permutate([i_word], 0, 2)

i_word = digits[0] * 3
three_digit = permutate([i_word], 0, 3)

count = 0
for num in three_digit:
    for num2 in two_digit:
        string = ""
        string += str(int(num) * int(num2))
        string += str(int(num) * int(num2[0]))
        string += str(int(num) * int(num2[1]))
        boo = [e in digits for e in string]
        if all(boo) and len(string) == 10:
            count += 1

w.write(str(count) + "\n")
