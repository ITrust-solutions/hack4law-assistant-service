# Moduł Asystenta

## Założenia

Stworzyć elastyczne narzędzie do zarządzania zadaniami składającymi się z kroków, które są wykonywane bez określonej kolejności. Zadania są przydzielane użytkownikom na podstawie "receptur", które stanowią zestaw czynności do wykonania w celu realizacji określonej sprawy.

## Technologia

- Java 17, Spring Boot
- Aplikacja wykonana wg wzorca contract-first, to znaczy, że w pierwszej kolejności powstała dokumentacja usług w formacie OpenApi, a następnie automatycznie wygenerowane zostały interfejsy programistyczne spełniające opisany kontrakt.

## Środowisko developerskie

Za pomocą docker-compose można uruchomić aplikację lokalnie. Obecna konfiguracja jest przygotowana do współpracy z bazą danych w Azure.

## Przykładowe zapytania REST

- plik `client-test.http` zawiera przykładowe żądania w formacie, który można uruchomić w IntelliJ, Visual Studio Code (z odpowiednim pluginem), lub za pomocą narzędzia wiersza poleceń `http`. Konfiguracja jest zawarta w pliku `http-client.env.json`.
