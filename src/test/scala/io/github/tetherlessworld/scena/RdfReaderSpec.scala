package io.github.tetherlessworld.scena

import io.lemonlabs.uri.Uri
import org.apache.jena.rdf.model.ModelFactory
import org.scalatest.{Matchers, WordSpec}

import scala.collection.JavaConverters._

class RdfReaderSpec extends WordSpec with Matchers {
  "An RdfReader" can {
    "deserialize a model" in {
      val expectedDomainModel = TestDomainModel("test", Uri.parse("http://example.com/test"))
      val jenaModel = ModelFactory.createDefaultModel()
      val jenaResource = Rdf.write(jenaModel, expectedDomainModel)
      val actualDomainModel = Rdf.read[TestDomainModel](jenaResource)
      actualDomainModel should equal(expectedDomainModel)
    }
  }
}
