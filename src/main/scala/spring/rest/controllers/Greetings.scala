package spring.rest.controllers

import java.util
import java.util.UUID

import org.springframework.http.{HttpStatus, MediaType, ResponseEntity}
import org.springframework.web.bind.annotation._
import spring.rest.model.{ErrorMessage, Greeting, Id}

// TODO: Try with Option/None parameter..

@RestController
@RequestMapping(path = Array("/v1/greetings"), produces = Array(MediaType.APPLICATION_JSON_VALUE), consumes = Array(MediaType.APPLICATION_JSON_VALUE))
class Greetings {
  //  @RequestMapping(method = Array(RequestMethod.GET))
  @GetMapping
  def hello(): Greeting = {
    Greeting("Hello..!")
  }

  //  @RequestMapping(path = Array("/{name}"), method = Array(RequestMethod.GET))
  @GetMapping(path = Array("/{name}"))
  def hello(@PathVariable("name") name: String): Greeting = {
    Greeting(s"Hello..! $name")
  }

  //  @RequestMapping(path = Array("/2"), method = Array(RequestMethod.GET))
  @GetMapping(path = Array("/2"))
  def hello2(@RequestParam("name") name: String): Greeting = {
    Greeting("Hello..! " + name)
  }

  //  @RequestMapping(path = Array("/3"), method = Array(RequestMethod.GET))
  @GetMapping(path = Array("/3"))
  def hello3(@RequestParam("name") name: String, @RequestHeader("User-Agent") userAgent: String): Greeting = {
    Greeting("Hello..! " + name + ". Your User-Agent is " + userAgent)
  }

  //  @RequestMapping(path = Array("/{firstName}/{lastName}"), method = Array(RequestMethod.GET))
  @GetMapping(path = Array("/{firstName}/{lastName}"))
  def hello(@PathVariable("firstName") firstName: String, @PathVariable("lastName") lastName: String): ResponseEntity[Greeting] = {
    new ResponseEntity(Greeting("Hello..! " + firstName + " " + lastName), HttpStatus.OK)
  }

  //  @RequestMapping(method = Array(RequestMethod.POST))
  @PostMapping
  def hello(@RequestBody greeting: Greeting): ResponseEntity[Any] = {
    if (greeting.message.toLowerCase().contains("kiran")) {
      new ResponseEntity(ErrorMessage(greeting.message + " already existed!"), HttpStatus.CONFLICT)
    }

    new ResponseEntity(Id(UUID.randomUUID()), HttpStatus.CREATED)
  }

  //  @RequestMapping(path = Array("/all"), method = Array(RequestMethod.GET))
  @RequestMapping(path = Array("/all"))
  def all(): ResponseEntity[util.Collection[Greeting]] = {
    import scala.collection.JavaConverters._
    new ResponseEntity(Seq(Greeting("Hello"), Greeting("Bye", Some(UUID.randomUUID()))).toList.asJavaCollection, HttpStatus.OK)
  }

}
