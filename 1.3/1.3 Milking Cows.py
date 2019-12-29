"""
ID: rishiso1
LANG: PYTHON3
TASK: milk2
"""
f = open('milk2.in', 'r')
w = open('milk2.out', 'w')

cont = f.read()
cont = cont.split("\n")
del cont[0]
del cont[-1]
schedule = []

for i in cont:
    arr = i.split(" ")
    arr[0] = int(arr[0])
    arr[1] = int(arr[1])
    schedule.append(arr)

schedule.sort()
print(schedule)

longest_time = 0
longest_break = 0
cur_span = schedule[0]

for i in range(len(schedule)):
    if schedule[i][0] > cur_span[1]:
        longest_break = max(longest_break, schedule[i][0] - cur_span[1])
        longest_time = max(longest_time, cur_span[1] - cur_span[0])
        cur_span = schedule[i]
    else:
        if schedule[i][1] > cur_span[1]:
            cur_span[1] = schedule[i][1]

longest_time = max(longest_time, cur_span[1] - cur_span[0])

w.write(f"{longest_time} {longest_break}\n")