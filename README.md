# Wahllokal2
DEZSYS_GK71_ELECTION_REST

## Beschreibung
Es steht die Nationalratswahl vor der Tür und um die Wahlergebnisse möglichst rasch vom Wahllokal an die nächste Bezirksstelle übertragen zu können, soll eine REST Schnittstelle implementiert werden, wo die Ergebnisses (Anzahl der Stimmen pro Partei) dieses Wahllokals ausgegeben werden. Um die Möglichkeiten der Anbindung flexibel zu gestalten, sollen die Datenformate JSON und XML unterstützt werden.

## Theorie
Es werden mit Rest Schnittstellen erschaffen die bei einem Aufruf eines bestimmten Pfades der Adresse localhost:8080/vote eine Java Methode aufruft die diese Frage mit einer Html Seite beantwortet. Des weiteren gibt es die /vote/{regionID}/json: die region ID wird mit der Hilfe von @PathVariable String regionID aus der URL gefiltert. Dann kann man sich aussuchen ob es der Format JSON oder XML sein soll.

## Quellen
https://spring.io/projects/spring-boot
https://spring.io/guides/gs/rest-service

