package spring.rest.model

import java.util.UUID

import scala.beans.BeanProperty

case class Id(@BeanProperty id: UUID)