'''
Nulltunge tall
Nulltunge tall er heltall som har flere nuller i seg enn de andre sifferene til sammen.
For eksempel er 1050006 nulltungt, og 105006 er ikke.

Hva er summen av alle nulltunge tall fra og med 1 til og med 18 163 106?
svaret var:
78650247070

'''
#mye enklere løsning
#print(sum([i for i in range(1,18163106) if len(str(i))/2 < str(i).count('0')]))


sum = 0
for i in range(1,18163106):
    nuller = 0
    for ch in str(i):
        if ch == "0":
            nuller += 1
    if len(str(i))/2 < str(i).count('0'):
        #print(i)
        sum += i
print(sum)
