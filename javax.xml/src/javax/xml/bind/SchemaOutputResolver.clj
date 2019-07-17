(ns javax.xml.bind.SchemaOutputResolver
  "Controls where a JAXB implementation puts the generates
  schema files.


  An implementation of this abstract class has to be provided by the calling
  application to generate schemas.


  This is a class, not an interface so as to allow future versions to evolve
  without breaking the compatibility."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind SchemaOutputResolver]))

(defn ->schema-output-resolver
  "Constructor."
  ([]
    (new SchemaOutputResolver )))

(defn create-output
  "Decides where the schema file (of the given namespace URI)
   will be written, and return it as a Result object.


   This method is called only once for any given namespace.
   IOW, all the components in one namespace is always written
   into the same schema document.

  namespace-uri - The namespace URI that the schema declares. Can be the empty string, but never be null. - `java.lang.String`
  suggested-file-name - A JAXB implementation generates an unique file name (like `schema1.xsd`) for the convenience of the callee. This name can be used for the file name of the schema, or the callee can just ignore this name and come up with its own name. This is just a hint. - `java.lang.String`

  returns: a Result object that encapsulates the actual destination
        of the schema.

        If the Result object has a system ID, it must be an
        absolute system ID. Those system IDs are relativized by the caller and used
        for <xs:import> statements.

        If the Result object does not have a system ID, a schema
        for the namespace URI is generated but it won't be explicitly
        <xs:import>ed from other schemas.

        If null is returned, the schema generation for this
        namespace URI will be skipped. - `javax.xml.transform.Result`

  throws: java.io.IOException"
  (^javax.xml.transform.Result [^javax.xml.bind.SchemaOutputResolver this ^java.lang.String namespace-uri ^java.lang.String suggested-file-name]
    (-> this (.createOutput namespace-uri suggested-file-name))))

