"""
ID: rishiso1
LANG: PYTHON3
TASK: namenum
"""
f = open("namenum.in", "r")
w = open("namenum.out", "w")
dict = open("dict.txt", "r")

names = dict.read()
names = names.split("\n")

number = f.readline()
number = number.replace("\n", "")
names = [e for e in names if len(e) == len(number)]

num_dict = {
            2: ["A", "B", "C"],
            3: ["D", "E", "F"],
            4: ["G", "H", "I"],
            5: ["J", "K", "L"],
            6: ["M", "N", "O"],
            7: ["P", "R", "S"],
            8: ["T", "U", "V"],
            9: ["W", "X", "Y"]
}

#Recursive function for finding combinations
def combo(arr, i):
    res = []
    if i == len(number):
        return arr
    else:
        letters = num_dict[int(number[i])]
        for name in arr:
            for letter in letters:
                new_word = name[:i] + letter + name[i + 1:]
                res.append(new_word)
        return combo(res, i + 1)


original_word = "".join([num_dict[int(n)][0] for n in number])

count = 0
for word in combo([original_word], 0):
    if word in names:
        count += 1
        w.write(word + "\n")

if count == 0:
    w.write("NONE\n")

