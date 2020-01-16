package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.Resource

object RdfSyntax {
    implicit class RdfWriterOps[A](value: A) {
      def toRdf(implicit w: RdfWriter[A]): Resource =
        Rdf.write(value)(w)
    }
}
