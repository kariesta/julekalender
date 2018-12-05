

#ta listen med tall, i akkuratt den rekkefølgen.
#enten slå sammen tall, eller put + eller - mellom dem.
#gå gjennom listen med alle tre muligheter per plass, finn hvilke variasjoner som gir svaret 42
#returner teller av 42 svar.
#ingen komboer blir gjenntatt, så ikke tenk på det.

lista = [1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2, 1]
str_lista = "123456787654321"
svar = 42


'''def teller(oppsamlet, index):
    if index == len(lista):
        return [oppsamlet]
    else:
        nestepluss = teller(oppsamlet + lista[index],index + 1)
        nesteminus = teller(oppsamlet - lista[index],index +1)
        #nestesamlet =
        return nestepluss.extend(nesteminus)
        '''

def generer_ny_liste(gammel_liste,indeks):
    ny_liste = []
    for elem in gammel_liste:
        ny_liste.append(elem + "+" + str(lista[indeks]))
        ny_liste.append(elem + "-" + str(lista[indeks]))
        ny_liste.append(elem + str(lista[indeks]))
    return ny_liste

print(str_lista)
print(eval(str_lista))
svarlista = ["1"]
for i in range(1,len(lista)):
    svarlista = generer_ny_liste(svarlista,i)
    #str_lista = str_lista[:i]+"+"+str_lista[i:]
    #print(str_lista)
    #print(eval(str_lista))
    print(len(svarlista))
teller = 0
for elem in svarlista:
    if eval(elem) == 42:
        print(elem)
        teller+=1
print(teller)



#sum = 0
#regnestykker = teller(0,0)
#for r in regnestykker:
#    if :
#        print(r)
