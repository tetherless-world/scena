package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.ModelFactory
import org.scalatest.{Matchers, WordSpec}

import scala.collection.JavaConverters._

class RdfWriterSpec extends WordSpec with Matchers {
  "An RdfWriter" can {
    "serialize a model" in {
      val domainModel = TestDomainModel("test", "http://example.com/test")
      val jenaModel = ModelFactory.createDefaultModel()
      val jenaResource = Rdf.write(jenaModel, domainModel)
      jenaResource.listProperties().asScala.toList.size should equal(1)
    }
  }
}
