(ns javax.management.openmbean.InvalidOpenTypeException
  "This runtime exception is thrown to indicate that the open type of an open data value
  is not the one expected."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean InvalidOpenTypeException]))

(defn ->invalid-open-type-exception
  "Constructor.

  An InvalidOpenTypeException with a detail message.

  msg - the detail message. - `java.lang.String`"
  (^InvalidOpenTypeException [^java.lang.String msg]
    (new InvalidOpenTypeException msg))
  (^InvalidOpenTypeException []
    (new InvalidOpenTypeException )))

