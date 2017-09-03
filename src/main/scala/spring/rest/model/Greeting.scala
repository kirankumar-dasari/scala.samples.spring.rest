package spring.rest.model

import java.util.UUID

import scala.beans.BeanProperty

case class Greeting(@BeanProperty var message: String, @BeanProperty val id: Option[UUID] = None) {
  def this() = this(message = "")
}
