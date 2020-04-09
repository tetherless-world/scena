package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.{Property, RDFNode, Resource, ResourceFactory}

trait PropertySetters {
  protected val resource: Resource

  protected final def addProperty[RdfNodeT <: RDFNode](property: Property, values: List[RdfNodeT]): Unit = {
    for (value <- values) {
      resource.addProperty(property, value)
    }
  }

  protected final def addPropertyLiterals[T](property: Property, values: List[T]) = {
    addProperty(property, values.map(value => ResourceFactory.createPlainLiteral(value.toString)))
  }

  protected final def addPropertyUris(property: Property, uris: List[String]) = {
    addProperty(property, uris.map(uri => {
      Option(resource.getModel.getResource(uri.toString))
        .getOrElse(ResourceFactory.createResource(uri.toString))
    }))
  }

  protected final def setProperty[RdfNodeT <: RDFNode](property: Property, values: List[RdfNodeT]): Unit = {
    resource.removeAll(property)
    addProperty(property, values)
  }

  protected final def setPropertyLiterals[T](property: Property, values: List[T]) = {
    resource.removeAll(property)
    addPropertyLiterals(property, values)
  }

  protected final def setPropertyUris(property: Property, uris: List[String]) = {
    resource.removeAll(property)
    addPropertyUris(property, uris)
  }
}
