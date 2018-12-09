#lese inn
dolls = {}

for n in open("input/luke8.txt"):
    color, size = n.rstrip().split(",")
    size = int(size)
    if size in dolls.keys():
        dolls[size].append(color)
    else:
        dolls.update({size:[color]})
    #dolls[color].append(size)
sorted_keys = sorted(dolls.keys())
fjernet = 0
print(sorted_keys[0], dolls[sorted_keys[0]])
for i in range(1,len(sorted_keys)):
    if(dolls[sorted_keys[i]] == dolls[sorted_keys[i-1]]):
        fjernet += 1
        print("****", sorted_keys[i], dolls[sorted_keys[i]])
    else:
        print(sorted_keys[i], dolls[sorted_keys[i]])
#data.sort(key=lambda tup: tup[1])
print(len(sorted_keys)-fjernet)

#finne mulige innpakkninger.
#dollorder = []
#empty = False
#while not empty:
