package spring.rest.processors

import java.util.UUID

import org.springframework.stereotype.Service
import spring.rest.model.Greeting

@Service
class GreetingProcessor {
  def process(greeting: Greeting): Option[UUID] = {
    greeting.id = Some(UUID.randomUUID())
    println(greeting)
    greeting.id
  }
}
