package io.github.tetherlessworld.scena

import org.apache.jena.vocabulary.RDFS

trait RdfsProperties extends PropertyGetters with PropertySetters {
  final def comments = getPropertyObjectStrings(RDFS.comment)

  final def comments_=(comments: List[String]) = setPropertyLiterals(RDFS.comment, comments)

  final def labels = getPropertyObjectStrings(RDFS.label)

  final def labels_=(labels: List[String]) = setPropertyLiterals(RDFS.label, labels)
}
