# Rock Paper Scissors Lizard Spock

A simple http server with a game at the endpoint

## How to Play

Load project into a scala-capable IDE such as IntelliJ IDEA or Eclipse.

Run the server with 

    sbt run
    
choose GameApp

Play with a POST request, e.g.

    curl -i -d "Leonard: Rock - Sheldon: Spock" -X POST http://localhost:8080/play
    
The server will respond with:

    Player Sheldon with symbol Spock wins!
    
If both players select Spock:

    curl -i -d "Leonard: Spock - Sheldon: Spock" -X POST http://localhost:8080/play
    
The server should respond:

    It's a draw!