package io.github.tetherlessworld.scena

import io.lemonlabs.uri.Uri
import org.apache.jena.geosparql.implementation.vocabulary.Geo
import org.apache.jena.rdf.model.{Model, Resource, ResourceFactory}
import org.apache.jena.vocabulary.RDFS

final case class TestDomainModel(label: String, uri: Uri)

object TestDomainModel {
  implicit object TestModelRdfReader extends RdfReader[TestDomainModel] {
    override def read(resource: Resource): TestDomainModel =
      TestDomainModel(
        label = resource.getProperty(RDFS.label).getLiteral.getString,
        uri = Uri.parse(resource.getURI)
      )
  }

  implicit object TestModelRdfWriter extends RdfWriter[TestDomainModel] {
    override def write(model: Model, value: TestDomainModel): Resource = {
      val resource = model.createResource(value.uri.toString)
      resource.addProperty(RDFS.label, value.label)
    }
  }
}
