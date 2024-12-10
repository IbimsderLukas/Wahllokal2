# Wahllokal2
DEZSYS_GK71_ELECTION_REST

## Beschreibung
Es steht die Nationalratswahl vor der Tür und um die Wahlergebnisse möglichst rasch vom Wahllokal an die nächste Bezirksstelle übertragen zu können, soll eine REST Schnittstelle implementiert werden, wo die Ergebnisses (Anzahl der Stimmen pro Partei) dieses Wahllokals ausgegeben werden. Um die Möglichkeiten der Anbindung flexibel zu gestalten, sollen die Datenformate JSON und XML unterstützt werden.

## Theorie
Es werden mit Rest Schnittstellen erschaffen die bei einem Aufruf eines bestimmten Pfades der Adresse localhost:8080/vote eine Java Methode aufruft die diese Frage mit einer Html Seite beantwortet. Des weiteren gibt es die /vote/{regionID}/json: die region ID wird mit der Hilfe von @PathVariable String regionID aus der URL gefiltert. Dann kann man sich aussuchen ob es der Format JSON oder XML sein soll.

## Was war neu?
HTML in Java:


	`@RequestMapping("/vote")    
	    public String voteMain() {
	        String mainPage = "Welcome to the Voting Application! <br/><br/>" +
 	               "<a href='http://localhost:8080/vote/33123/json'>Link to vote/33123/json</a><br/>" +
 	               "<a href='http://localhost:8080/vote/33123/xml'>Link to vote/33123/xml</a>";
 	       return mainPage;
	    }`

  Hier wird beim Aufruf der URL localhost:8080 (Springboot adresse) /vote, die Methode voteMain()
 aufgerufen und ausgeführt die einen Strin mit HTML code zurückgibt der dann auf der Website als html code angeführt wird



Path Variablen und ID´s;


	`@RequestMapping(value = "/vote/{regionID}/json", produces = MediaType.APPLICATION_JSON_VALUE)
	    public String getVoteDataAsJSON(@PathVariable String regionID) {
 	       VoteData data = service.getVoteData(regionID);
 	       return data.toJSON();
	    }`
    

  Hier wird wie oben beim aufruf der /vote/.../json beim Aufruf dieser URL die angegebene Methode aufgerufen, mit einem unterschied:
    Die region ID ist kein fixer Wert und wird als parameter in einem String gespeichert mit der hilfe von @PathVariable. Mit der Hilfe der region ID kann dann die passende JSON oder XML seite aufgerufen werden.
    MediaType.APPLICATION_JSON_VALUE bewirkt das die Seite als JSON angibt.



    `public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}`


 Hier ist die Application die als Main interagiert oder anders gesagt die springboot statet.
 
## Quellen
https://spring.io/projects/spring-boot
https://spring.io/guides/gs/rest-service

