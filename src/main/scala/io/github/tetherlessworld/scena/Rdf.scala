package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.{Model, Resource}

object Rdf {
  def read[A](resource: Resource)(implicit r: RdfReader[A]): A =
    r.read(resource)

  def write[A](model: Model, value: A)(implicit w: RdfWriter[A]): Resource =
    w.write(model, value)
}
