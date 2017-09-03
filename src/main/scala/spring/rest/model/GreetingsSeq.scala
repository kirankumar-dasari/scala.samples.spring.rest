package spring.rest.model

import scala.beans.BeanProperty

case class GreetingsSeq(@BeanProperty greetings: Seq[Greeting])