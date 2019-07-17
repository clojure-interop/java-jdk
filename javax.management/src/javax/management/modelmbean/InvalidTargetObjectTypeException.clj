(ns javax.management.modelmbean.InvalidTargetObjectTypeException
  "Exception thrown when an invalid target object type is specified.


  The serialVersionUID of this class is 1190536278266811217L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean InvalidTargetObjectTypeException]))

(defn ->invalid-target-object-type-exception
  "Constructor.

  Constructor taking an exception and a string.

  e - Exception that we may have caught to reissue as an InvalidTargetObjectTypeException. The message will be used, and we may want to consider overriding the printStackTrace() methods to get data pointing back to original throw stack. - `java.lang.Exception`
  s - String value that will be incorporated in message for this exception. - `java.lang.String`"
  ([e s]
    (new InvalidTargetObjectTypeException e s))
  ([s]
    (new InvalidTargetObjectTypeException s))
  ([]
    (new InvalidTargetObjectTypeException )))

