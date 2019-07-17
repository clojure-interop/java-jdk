(ns javax.print.attribute.URISyntax
  "Class URISyntax is an abstract base class providing the common
  implementation of all attributes whose value is a Uniform Resource
  Identifier (URI). Once constructed, a URI attribute's value is immutable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute URISyntax]))

(defn get-uri
  "Returns this URI attribute's URI value.

  returns: the URI. - `java.net.URI`"
  ([this]
    (-> this (.getURI))))

(defn hash-code
  "Returns a hashcode for this URI attribute.

  returns: A hashcode value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn equals
  "Returns whether this URI attribute is equivalent to the passed in
   object.
   To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class URISyntax.

   This URI attribute's underlying URI and object's
   underlying URI are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this URI
            attribute, false otherwise. - `boolean`"
  ([this object]
    (-> this (.equals object))))

(defn to-string
  "Returns a String identifying this URI attribute. The String is the
   string representation of the attribute's underlying URI.

  returns: A String identifying this object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

