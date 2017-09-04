package spring.rest.controllers

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestMethod, RestController}

@RestController
@RequestMapping(path = Array("/"))
class Default {

//  @RequestMapping(path = Array("/"), method = Array(RequestMethod.GET))
  @GetMapping
  def get(): String = {
    "Welcome to scala samples and spring-rest application."
  }
}