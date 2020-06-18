package org.example.time

import java.time.format.DateTimeFormatter
import cats.effect.IO
import org.http4s.HttpService
import org.http4s.dsl.Http4sDsl

class TimeService extends Http4sDsl[IO] {
  private val printer = //#A
    new TimePrinter(DateTimeFormatter.RFC_1123_DATE_TIME)
  val service = HttpService[IO] {
    case GET -> Root / "datetime" / country =>
      try {
        Ok(printer.now(country)) //#B
      } catch {
        case ex: IllegalStateException => //#C
          NotFound(ex.getMessage)
      }
  }
}
