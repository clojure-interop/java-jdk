(ns javax.management.modelmbean.XMLParseException
  "This exception is thrown when an XML formatted string is being parsed into ModelMBean objects
  or when XML formatted strings are being created from ModelMBean objects.

  It is also used to wrapper exceptions from XML parsers that may be used.

  The serialVersionUID of this class is 3176664577895105181L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean XMLParseException]))

(defn ->xml-parse-exception
  "Constructor.

  Constructor taking a string and an exception.

  e - the nested exception. - `java.lang.Exception`
  s - the detail message. - `java.lang.String`"
  ([e s]
    (new XMLParseException e s))
  ([s]
    (new XMLParseException s))
  ([]
    (new XMLParseException )))

