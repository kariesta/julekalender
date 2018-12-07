import urllib.request as ul
import re
grupper = {}

target_url = "https://s3-eu-west-1.amazonaws.com/knowit-julekalender-2018/input-rain.txt"
for line in ul.urlopen(target_url):
    #print(line.rstrip())
    #skill ut alle tallene
    punkter = str(line)[2:-3].split(";")
    for i in range(len(punkter)):
        punkter[i] = punkter[i][1:-1].split(",")
    #print(punkter)
    #regnutstigning
    stigning = abs((int(punkter[1][0])-int(punkter[0][0]))/(int(punkter[1][1])-int(punkter[0][1])))
    #print(stigning)
    #legginn i dict
    if stigning in grupper.keys():
        grupper[stigning] = grupper[stigning] + 1
    else:
        grupper[stigning] = 1
print(grupper)


#finn største verdi i dict
biggest = 0
bigval = 0
#for key in grupper:
#    if grupper[key] > biggest:
#        biggest = []
#skriv ut største verdi
sorted = list(grupper.values())
sorted.sort()
print(sorted[len(grupper)-1])
#for key in grupper:
#    print(key,"\t",grupper[key])
