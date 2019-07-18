(ns javax.print.attribute.standard.Destination
  "Class Destination is a printing attribute class, a URI, that is used to
  indicate an alternate destination for the spooled printer formatted
  data. Many PrintServices will not support the notion of a destination
  other than the printer device, and so will not support this attribute.

  A common use for this attribute will be applications which want
  to redirect output to a local disk file : eg.`file:out.prn`.
  Note that proper construction of `file:` scheme URI instances should
  be performed using the toURI() method of class
  File.
  See the documentation on that class for more information.

  If a destination URI is specified in a PrintRequest and it is not
  accessible for output by the PrintService, a PrintException will be thrown.
  The PrintException may implement URIException to provide a more specific
  cause.

  IPP Compatibility: Destination is not an IPP attribute."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard Destination]))

(defn ->destination
  "Constructor.

  Constructs a new destination attribute with the specified URI.

  uri - URI. - `java.net.URI`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if uri is null."
  (^Destination [^java.net.URI uri]
    (new Destination uri)))

(defn equals
  "Returns whether this destination attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class Destination.

   This destination attribute's URI and object's URI
   are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this destination
           attribute, false otherwise. - `boolean`"
  (^Boolean [^Destination this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class Destination, the category is class Destination itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^Destination this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class Destination, the category name is `spool-data-destination`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^Destination this]
    (-> this (.getName))))

