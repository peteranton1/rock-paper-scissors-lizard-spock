package org.example.game.entities

sealed trait Symbol {
  protected def beats: List[Symbol]

  def wins(other: Symbol): Boolean =
    beats.contains(other)
}

case object Rock extends Symbol {
  protected val beats = List(Lizard, Scissors)
}

case object Paper extends Symbol {
  protected val beats = List(Rock, Spock)
}

case object Scissors extends Symbol {
  protected val beats = List(Paper, Lizard)
}

case object Lizard extends Symbol {
  protected val beats = List(Spock, Paper)
}

case object Spock extends Symbol {
  protected val beats = List(Scissors, Rock)
}

object Symbol {
  def fromString(text: String): Symbol =
    text.trim.toLowerCase match {
      case "rock" => Rock
      case "paper" => Paper
      case "scissors" => Scissors
      case "lizard" => Lizard
      case "spock" => Spock
      case unknown =>
        val errorMsg = s"Unknown symbol $unknown." +
          "Please pick a valid symbol [Rock, Paper, Scissors, Lizard, Spock]"
        throw new IllegalArgumentException(errorMsg)
    }
}
