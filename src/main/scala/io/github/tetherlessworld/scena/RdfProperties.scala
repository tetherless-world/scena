package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.Resource
import org.apache.jena.vocabulary.RDF

trait RdfProperties extends PropertyGetters with PropertySetters {
  final def types = getPropertyObjectResources(RDF.`type`)

  final def types_=(typeResources: List[Resource]): Unit = {
    setProperty(RDF.`type`, typeResources)
  }
}
