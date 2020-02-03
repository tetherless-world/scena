package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.{Model, Resource}

object RdfSyntax {
    implicit class RdfWriterOps[A](value: A) {
      def toRdf(model: Model)(implicit w: RdfWriter[A]): Resource =
        Rdf.write(model, value)(w)
    }
}
