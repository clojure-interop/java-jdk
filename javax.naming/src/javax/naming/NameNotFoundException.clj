(ns javax.naming.NameNotFoundException
  "This exception is thrown when a component of the name cannot be resolved
  because it is not bound.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming NameNotFoundException]))

(defn ->name-not-found-exception
  "Constructor.

  Constructs a new instance of NameNotFoundException using the
   explanation supplied. All other fields default to null.

  explanation - Possibly null additional detail about this exception. - `java.lang.String`"
  (^NameNotFoundException [^java.lang.String explanation]
    (new NameNotFoundException explanation))
  (^NameNotFoundException []
    (new NameNotFoundException )))

