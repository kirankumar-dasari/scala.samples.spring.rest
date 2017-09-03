package spring.rest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

@SpringBootApplication
@RestController
class Application {

  @RequestMapping(path = Array("/"), method = Array(RequestMethod.GET))
  def get(): String = {
    "Welcome to scala samples and spring-rest application."
  }
}

object Application {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Application])
  }
}

//object Application {
//  def main(args: Array[String]): Unit = {
//    println("Hello!")
//  }
//}

//object Application extends App {
//  println("Hello..")
//}
