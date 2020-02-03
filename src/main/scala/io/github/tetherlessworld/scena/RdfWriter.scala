package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.{Model, Resource}

trait RdfWriter[A] {
  def write(model: Model, value: A): Resource
}
