package io.github.tetherlessworld.scena

import java.util.Date

import org.apache.jena.rdf.model.{Literal, Property, RDFNode, Resource}

import scala.collection.JavaConverters._

trait PropertyGetters {
  protected final def getPropertyObjects(property: Property): List[RDFNode] =
    resource.listProperties(property).asScala.toList.map(statement => statement.getObject)

  protected final def getPropertyObjectDates(property: Property): List[Date] = {
    val dateFormatter = new java.text.SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy")
    getPropertyObjectStrings(property).map(date => dateFormatter.parse(date))
  }

  protected final def getPropertyObjectFloats(property: Property): List[Float] =
    getPropertyObjectLiterals(property).map(literal => literal.getFloat)

  protected final def getPropertyObjectInts(property: Property): List[Int] =
    getPropertyObjectLiterals(property).map(literal => literal.getInt)

  protected final def getPropertyObjectLiterals(property: Property): List[Literal] =
    getPropertyObjects(property).filter(object_ => object_.isLiteral).map(object_ => object_.asLiteral())

  protected final def getPropertyObjectLongs(property: Property): List[Long] =
    getPropertyObjectLiterals(property).map(literal => literal.getLong)

  protected final def getPropertyObjectResources(property: Property): List[Resource] =
    getPropertyObjects(property).filter(object_ => object_.isResource).map(object_ => object_.asResource())

  protected final def getPropertyObjectResourceUris(property: Property): List[String] =
    getPropertyObjects(property).filter(object_ => object_.isURIResource).map(object_ => object_.asResource().getURI)

  protected final def getPropertyObjectStrings(property: Property): List[String] =
    getPropertyObjectLiterals(property).map(literal => literal.getString)

  protected val resource: Resource
}
