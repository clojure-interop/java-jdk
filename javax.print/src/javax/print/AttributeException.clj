(ns javax.print.AttributeException
  "Interface AttributeException is a mixin interface which a subclass of
  PrintException can implement to report an error condition
  involving one or more printing attributes that a particular Print
  Service instance does not support. Either the attribute is not supported at
  all, or the attribute is supported but the particular specified value is not
  supported. The Print Service API does not define any print exception
  classes that implement interface AttributeException, that being left to the
  Print Service implementor's discretion."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print AttributeException]))

(defn get-unsupported-attributes
  "Returns the array of printing attribute classes for which the Print
   Service instance does not support the attribute at all, or null if
   there are no such attributes. The objects in the returned array are
   classes that extend the base interface
   Attribute.

  returns: unsupported attribute classes - `java.lang.Class[]`"
  ([^javax.print.AttributeException this]
    (-> this (.getUnsupportedAttributes))))

(defn get-unsupported-values
  "Returns the array of printing attributes for which the Print Service
   instance supports the attribute but does not support that particular
   value of the attribute, or null if there are no such attribute values.

  returns: unsupported attribute values - `javax.print.attribute.Attribute[]`"
  ([^javax.print.AttributeException this]
    (-> this (.getUnsupportedValues))))

