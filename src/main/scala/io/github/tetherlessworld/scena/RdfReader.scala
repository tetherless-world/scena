package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.Resource

trait RdfReader[A] {
  def read(resource: Resource): A
}
