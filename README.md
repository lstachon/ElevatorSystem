# ElevatorSystem
Po włączeniu klasy main pojawi instrukcja jakich komend można użyć. <br />
-Obsługa programu odbywa sie z wiersza poleceń.<br />
-Każą komendę nalezy kończyć enterem.<br />
-System obsługi wind może działać na dwa sposoby: każda winda moze działać niezależnie i człowiek decyduje którą windę przywołuje lub to system przydziela windę człowiekowi. Ja zaimplementowałem ten drugi. <br />
-By zakończyć program wpisujemy "q" (i klikamy enter).<br />
-System ten działa w taki sposob że osoba wybiera z którego piętra będzie jechać na które ale to system wybiera windę którą pojedzie. <br />
-Nalezy zacząć od dodania odpowiedniej ilości wind kazde polecenie add dodaje jedną. Nowo dodane windy mają ustawione jako aktualne piętro: 0.<br />
-Poleceniem pickup przywołujemy najbliżej znajdującą się windę (Według pięter).<br />
-Po przybyciu na miejsce nowym celem windy jest piętro które zostało wybrane najdawniej. <br />
-Przykład który jest w testach: pierwsza osoba chce jechać z 1 na 10 piętro a osoba która kliknęła później (w tym samym ruchu tzn bez komendy step) chce jechać z 3 na 4 jezeli nie ma zadnej innej windy dostepnej blizej to winda pojedzie z piętra 1 na 3 a następnie na 10. <br />
-Algorytm ten nie jest idealny ale delikanie usprawnia działanie windy. Działanie można by usprawnić również w ten sposób że winda zatrzymywałaby się  na piętrach które mija a która są w jej "kolejce".<br /> 
-Jeżeli winda nie ruszyła się w danym ruchu to jej cel i aktualne piętro są takie same.<br />
-Komenda update zmienia aktualny cel oraz położenie danej windy na przez nas podane.<br />
-Funkcja status została zaimplementowana ale wyświetlanie jej zawartości umożliwia komenda print.<br />
-Komenda print wypisuje wszystkie windy po kolei z ich aktualnym piętrem oraz kolejnym piętrem na które się winda udaje. <br/>