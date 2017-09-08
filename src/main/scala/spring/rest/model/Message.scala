package spring.rest.model

import scala.beans.BeanProperty

case class Message(@BeanProperty message: String = "")