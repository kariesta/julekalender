import urllib.request

listelista = {}
print(listelista)
#print(len(listelista))
#print(listelista[0])
count = 0

def leggtilsombarn(tallet):
    for n in sorted(list(listelista.keys())):
        if tallet < n:
            return
        else:
            #listelista.get(n).append(tallet)
            listelista[n] += 1


for n in open("input/luke7.txt"):
    #ta alle keys
    #sorter dem
    #legg til i alle under current
    #hent lengde på lengste liste.
    leggtilsombarn(n)
    #listelista.update({n:[0]})
    listelista.update({n:1})
    if count%50000 == 0:
        print(n.strip() , "\t", count)
        with open('somefile.txt', 'a') as the_file:
            the_file.write(str(listelista))
    count+=1

longest = 0
for n in listelista.keys():
    if longest < listelista[n]:
        longest = listelista[n]
        #print(n, listelista[n])
print(longest)
'''
    if int(n) > listelista[outin][inin]:
        inin +=1
        listelista[outin].append(int(n))
    else:
        inin = 0
        outin +=1
        listelista.append([int(n)])
for n in listelista:
    print(n)
'''
