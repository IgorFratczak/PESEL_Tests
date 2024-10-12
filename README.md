# PESEL_Tests
Laboratory 1 of advanced object-oriented programming

CASE:
Zaprojektuj aplikację konsolową do sprawdzania numeru PESEL podanego z linii poleceń. Jeśli nie podamy parametru, program pyta o numer PESEL.

Program wykonaj w IntelliJ w JDK 23

Zastanów się, w jaki sposób należy przechować PESEL, aby można go było analizować. Program w przypadku prawidłowego numeru powinien mieć możliwość obliczenia daty urodzenia i podania płci. Obsłuż daty urodzin zarówno przed rokiem 2000 jak i późniejsze.

Testy jednostkowe
Przygotuj strukturę obiektową tak, aby program mógł być w łatwy sposób testowany z wykorzystaniem testów jednostkowych JUnit 5. Zalecenia:

Testujemy tylko funkcje publiczne (czyli API). Nie testujemy funkcji prywatnych klasy
Jedna funkcja (metoda klasy) powinna wykonywać jedną konkretną czynność (algorytm).
Funkcja powinna być możliwa do wywołania w środowisku izolowanym mimo, że jest składową klasy
Funkcja powinna: pobierać parametr (najlepiej jeden), zwracać wartość, może rzucać wyjątek
Wykonaj klasy dla testów jednostkowych przy użyciu JUnit. Testy mają sprawdzić następujące warunki

wprowadzamy ciąg znaków o niewłaściwym formacie - funkcja ma rzucić wyjątek
wprowadzamy właściwy PESEL - funkcja sprawdzająca poprawność ma zwrócić prawdę. Funkcja nie może rzucić wyjątku
wprowadzamy błędny PESEL (ale we właściwym formacie) - funkcja sprawdzająca poprawność ma zwrócić fałsz. Funkcja nie może rzucić wyjątku
wprowadzamy numer dla kobiety/mężczyzny - funkcja ma zwrócić K lub M
wprowadzamy poprawny numer - funkcja sprawdza, czy zgadza się data urodzenia oraz płcią
Wsadowe przetwarzanie testów jednostkowych

Zakładamy, że mamy plik CSV, zawierający numery PESEL i odpowiadające im wyniki (Kobieta, mężczyzna, data urodzenia, numer niepoprawny).

Przygotuj testy jednostkowe umożliwiające zaczytanie tego pliku i wykonanie wszystkich zawartym w nim testów.


Obsługa wyjątków

Wyjątek, który może generować metoda jest to wyjście awaryjne, które nastąpi przy niewłaściwym formacie danych wejściowych przykładowo:

ciąg znaków czyli numer PESEL zawiera nie tylko cyfry, ale inne znaki
ciąg znaków jest niezainicjowany (null)
ciąg znaków ma niewłaściwą długość
Program wykonaj tak, aby zminimalizować użycie warunków if, while na rzecz wyjątków.

W programie wykorzystaj:

obsługę wyjątków w metodzie, w której nastąpiła instrukcja generująca wyjątek
przesyłanie wyjątku do wywołania funkcji (klauzula throws w nagłówku funkcji)
użycie catch (kilka wyjątków, ważna jest kolejność + obsługa kilku wyjątków w jednym catch)
użycie finally
użycie throw
JavaDOC

Utwórz dokumentację javadoc i wygeneruj odpowiadające jej pliki html.

Dokumentacja powinna zawierać:

opis wszystkich klas i pól łącznie z prywatnymi (dołącz komentarze dokumentacyjne do wszystkich klas i pól na wzór tego co widzisz w kodzie źródłowym bibliotek)
opis wszystkich metod (z użyciem @param i @return), użyj słów @author, @version @since itp.
wypróbować przełączniki polecenia javadoc, np. --private
wypróbuj znaczniki HTML w komentarzach