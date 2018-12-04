'''
Vekksort
Vi definerer Vekksort (O(n)) til å være den lineære sorteringsalgoritmen som:

Traverserer en liste fra første element.
Eliminerer hvert element som er mindre enn det forrige.
Inndata er en tekstfil med ett positivt heltall per linje.

Oppgaven er å finne summen til tallene i en liste sortert ved "hjelp" av Vekksort.

Eksempel input:

5
4
3
6
7
5
2
7
5
1
1
10
Eksempel output: 35 (fordi 5 + 6 + 7 + 7 + 10 = 35)

Innputfila finner du her.
'''

list_of_numbers = open("input/luke1.txt")
cur_value = int(list_of_numbers.readline())
sum = cur_value

for n in list_of_numbers:
    if int(n) >= cur_value:
        cur_value = int(n)
        sum += cur_value
print(sum)
