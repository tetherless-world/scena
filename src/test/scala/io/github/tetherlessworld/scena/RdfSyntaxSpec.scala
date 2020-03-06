package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.ModelFactory
import org.scalatest.{Matchers, WordSpec}

import scala.collection.JavaConverters._

class RdfSyntaxSpec extends WordSpec with Matchers {
  import RdfSyntax._

  "The Rdf syntax" can {
    "serialize a model" in {
      val domainModel = TestDomainModel("test", "http://example.com/test")
      val jenaModel = ModelFactory.createDefaultModel()
      val jenaResource = domainModel.toRdf(jenaModel)
      jenaResource.listProperties().asScala.toList.size should equal(1)
    }
  }
}
