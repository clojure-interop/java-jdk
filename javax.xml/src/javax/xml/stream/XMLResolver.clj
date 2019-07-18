(ns javax.xml.stream.XMLResolver
  "This interface is used to resolve resources during an XML parse.  If an application wishes to
  perform custom entity resolution it must register an instance of this interface with
  the XMLInputFactory using the setXMLResolver method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream XMLResolver]))

(defn resolve-entity
  "Retrieves a resource.  This resource can be of the following three return types:
   (1) java.io.InputStream (2) javax.xml.stream.XMLStreamReader (3) java.xml.stream.XMLEventReader.
   If this method returns null the processor will attempt to resolve the entity using its
   default mechanism.

  public-id - The public identifier of the external entity being referenced, or null if none was supplied. - `java.lang.String`
  system-id - The system identifier of the external entity being referenced. - `java.lang.String`
  base-uri - Absolute base URI associated with systemId. - `java.lang.String`
  namespace - The namespace of the entity to resolve. - `java.lang.String`

  returns: The resource requested or null. - `java.lang.Object`

  throws: javax.xml.stream.XMLStreamException - if there was a failure attempting to resolve the resource."
  (^java.lang.Object [^XMLResolver this ^java.lang.String public-id ^java.lang.String system-id ^java.lang.String base-uri ^java.lang.String namespace]
    (-> this (.resolveEntity public-id system-id base-uri namespace))))

