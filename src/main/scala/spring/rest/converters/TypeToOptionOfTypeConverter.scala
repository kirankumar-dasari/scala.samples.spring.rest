package spring.rest.converters

import org.springframework.core.convert.converter.Converter
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

class TypeToOptionOfTypeConverter[T] extends Converter[T, Option[T]] {
  override def convert(source: T): Option[T] = {
    Some(source)
  }
}

class WebConfig extends WebMvcConfigurerAdapter {
  override def addFormatters(registry: FormatterRegistry): Unit = {
    registry.addConverter(classOf[Any], classOf[Option[Any]], new TypeToOptionOfTypeConverter[Any])
  }
}
