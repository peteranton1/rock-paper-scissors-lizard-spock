package org.example.game

import cats.effect.IO
import fs2.StreamApp
import org.http4s.HttpService
import org.http4s.server.blaze.BlazeBuilder

import scala.concurrent.ExecutionContext.Implicits.global

object GameApp extends StreamApp[IO] {

  def stream(args: List[String], requestShutdown: IO[Unit]): fs2.Stream[IO, StreamApp.ExitCode] =
    BlazeBuilder[IO]
      .bindHttp(8080, "0.0.0.0")
      .mountService(gameService, "/")
      .serve

  def gameService: HttpService[IO] = (new GameService).service
}
