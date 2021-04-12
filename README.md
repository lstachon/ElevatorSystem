# ElevatorSystem
### 
System obsługi wind może działać na dwa sposoby: 
każda winda działa niezależnie i człowiek decyduje którą windę przywołuje (osoba podaje która windą chce pojechac) 
system przydziela windę człowiekowi (osoba tylko podaje piętro na które chce pojechać).

Pierwsze podejście ma bardzo duże wadę, windy nie są równomiernie użytkowane. Moze zdarzyć się tak ze każdy bedzie przywoływać tą samą windę, co byłoby bardzo nieoptymalne oraz wydłuża czas transportu ludzi.

### Algorytm


Winda jedzie w góre zbiera osoby po drodze i je dowozi (zbiera tylko osoby co jadą w gore) i zatrzymuje sie na pietrze gdzie wysadziła ostatnia osobę.
Usprawnienie: Winda zatrzyma się maksymalnie x razy zanim dowiezie osobę do celu (żeby osoby nie spędziły w windzie zbyt dużo czasu). 
Rozszerzenie - dodanie maksymalnej pojemności windy (np. W windzie może maksymalnie przebywać 10 osób naraz).

Winda która jedzie w dol działa analogicznie. 


Gdy osoba przywołuje windę i żadna winda nie jedzie w dobrym kierunku, wybierana jest wina która jest najbliżej.

Jeśli osoba przywołuje windę i jakaś winda już jedzie w jej kierunku to ta osoba wsiada do tej windy.


### Uruchomienie i działanie programu

System ten działa w taki sposób że osoba wybiera z którego piętra będzie jechać na które ale to system wybiera windę którą pojedzie.

Po włączeniu klasy main pojawi instrukcja jakich komend można użyć.
Obsługa programu odbywa się z wiersza poleceń.
Każdą komendę należy kończyć enterem.
By zakończyć program wpisujemy "q".

-Należy zacząć od dodania odpowiedniej ilości wind kazde polecenie add dodaje jedną. Nowo dodane windy mają ustawione jako aktualne piętro: 0.

-Poleceniem pickup przywołujemy windę która jedzie w danym kierunku (np. winda ma jechać z 1 piętra na piętro 10 ale w międzyczasie ktoś wywołuje komendę pickup z piętra 3 na 4 to winda podjedzie w kolejności 1-3-4-10) analogicznie gdy winda jedzie w dół.

-Jeśli nie ma windy która mogłaby nas "podrzucić" to wybierana jest winda która jest najbliżej piętra z którego ją przywołujemy.

-Jeżeli winda nie ruszyła się w danym ruchu to jej cel i aktualne piętro są takie same.

-Komenda update zmienia aktualny cel oraz położenie danej windy na przez nas podane.

-Funkcja status została zaimplementowana ale wyświetlanie jej zawartości umożliwia komenda print.

-Komenda print wypisuje wszystkie windy po kolei z ich aktualnym piętrem oraz kolejnym piętrem na które się winda udaje.
