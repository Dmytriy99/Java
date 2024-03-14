# Travel
In questa applicazione Java è possibile tramite appositi tasti  [1]visuallizare tutte le attività,[2]prenotare un'attività,[3] disdire una prenotazione,
[4]aggiungere un nuovo utente,[5] esportare generenado un file le attività ancora disponibili e in fino [0] terminare il programma

## Requisiti
[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/).
[Maven](https://maven.apache.org/download.cgi).

## Verifica le versioni:
Per verificare la giusta versione di java eseguire il seguente comando: 
`java -version`

Per verificare la giusta installazione e versione di Maven eseguire il seguente comando:
`mvn -v`

## Inizializzazione

### Clonare il Repository
Puoi clonare il repository eseguendo il seguente comando:

`git clone https://github.com/Dmytriy99/Java.git`

## Eseguire l'applicazione

1. Una volta clonato il progetto eseguire il seguente comando: 
`mvn clean package`
Eseguendo questo comando verranno compilati tutti i file nella cartella "target" e verrà creato il file .jar
2. Lanciare l'applicazione
Per lanciare l'applicazione attraverso il file .jar appena generato all'interno della cartella "target" eseguire il seguente comando:
`java -jar target/NOME-DEL-JAR.jar`

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

run `ng test --no-watch --code-coverage` to see the coverage of the test.

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
