"""
ID: rishiso1
LANG: PYTHON3
TASK: friday
"""

f = open('friday.in', 'r')
w = open('friday.out', 'w')

days_of_wk = [0 for e in range(7)]
months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
num_years = int(f.read().rstrip())
starting_day = 2

for year in range(1900, 1900+num_years):
    months[1] = 28
    if year % 400 == 0:
        months[1] = 29
    elif year % 100 != 0 and year % 4 == 0:
        months[1] = 29

    for month in range(12):
        day = (starting_day + 5) % 7
        days_of_wk[day] += 1
        starting_day = (starting_day + months[month]) % 7

for i in range(7):
    days_of_wk[i] = str(days_of_wk[i])

w.write(" ".join(days_of_wk) + "\n")