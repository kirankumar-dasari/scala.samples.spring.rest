package spring.rest.model

import java.util.UUID

import scala.beans.BeanProperty

case class Greeting(@BeanProperty var message: String, @BeanProperty var id: Option[UUID] = None)