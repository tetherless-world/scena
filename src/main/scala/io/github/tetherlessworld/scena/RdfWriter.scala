package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.Resource

trait RdfWriter[A] {
  def write(value: A): Resource
}
