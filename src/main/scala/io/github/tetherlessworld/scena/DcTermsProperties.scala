package io.github.tetherlessworld.scena

import org.apache.jena.rdf.model.ResourceFactory
import org.apache.jena.vocabulary.DCTerms

trait DcTermsProperties extends PropertyGetters with PropertySetters {
  final def identifier: Option[String] = getPropertyObjectStrings(DCTerms.identifier).headOption

  final def identifier_=(value: String): Unit =
    setProperty(DCTerms.identifier, List(ResourceFactory.createPlainLiteral(value)))

}
