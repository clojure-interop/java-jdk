(ns javax.naming.SizeLimitExceededException
  "This exception is thrown when a method
  produces a result that exceeds a size-related limit.
  This can happen, for example, if the result contains
  more objects than the user requested, or when the size
  of the result exceeds some implementation-specific limit.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming SizeLimitExceededException]))

(defn ->size-limit-exceeded-exception
  "Constructor.

  Constructs a new instance of SizeLimitExceededException using an
   explanation. All other fields default to null.

  explanation - Possibly null detail about this exception. - `java.lang.String`"
  ([explanation]
    (new SizeLimitExceededException explanation))
  ([]
    (new SizeLimitExceededException )))

