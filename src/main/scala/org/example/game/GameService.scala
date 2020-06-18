package org.example.game

import cats.effect.IO
import org.example.game.entities.Game
import org.http4s.HttpService
import org.http4s.dsl.Http4sDsl

/**
 * Run server and play with a command such as :
 *
 * curl -i -d "Leonard: Rock - Sheldon: Spock" -X POST http://localhost:8080/play
 */
class GameService extends Http4sDsl[IO] {
  val service: HttpService[IO] = HttpService[IO] {
    case req@POST -> Root / "play" =>
      for {
        text <- req.as[String]
        response <- Ok(Game(text).result)
      } yield response
  }
}
