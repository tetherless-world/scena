package io.github.tetherlessworld.scena

import org.apache.jena.vocabulary.DCTerms

trait DcTermsProperties extends PropertyGetters with PropertySetters {
  final def identifiers: List[String] = getPropertyObjectStrings(DCTerms.identifier)

  final def identifiers_=(values: List[String]): Unit =
    setPropertyLiterals(DCTerms.identifier, values)
}
