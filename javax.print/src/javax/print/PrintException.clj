(ns javax.print.PrintException
  "Class PrintException encapsulates a printing-related error condition that
  occurred while using a Print Service instance. This base class
  furnishes only a string description of the error. Subclasses furnish more
  detailed information if applicable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print PrintException]))

(defn ->print-exception
  "Constructor.

  Construct a print exception with the given detail message
   and chained exception.

  s - Detail message, or null if no detail message. - `java.lang.String`
  e - Chained exception. - `java.lang.Exception`"
  ([^java.lang.String s ^java.lang.Exception e]
    (new PrintException s e))
  ([^java.lang.String s]
    (new PrintException s))
  ([]
    (new PrintException )))

