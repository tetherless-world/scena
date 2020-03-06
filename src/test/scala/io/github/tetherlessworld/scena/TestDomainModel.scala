package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.{Model, Resource}
import org.apache.jena.vocabulary.RDFS

final case class TestDomainModel(label: String, uri: String)

object TestDomainModel {
  implicit object TestModelRdfReader extends RdfReader[TestDomainModel] {
    override def read(resource: Resource): TestDomainModel =
      TestDomainModel(
        label = resource.getProperty(RDFS.label).getLiteral.getString,
        uri = resource.getURI
      )
  }

  implicit object TestModelRdfWriter extends RdfWriter[TestDomainModel] {
    override def write(model: Model, value: TestDomainModel): Resource = {
      val resource = model.createResource(value.uri)
      resource.addProperty(RDFS.label, value.label)
    }
  }
}
