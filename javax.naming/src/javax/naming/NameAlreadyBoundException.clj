(ns javax.naming.NameAlreadyBoundException
  "This exception is thrown by methods to indicate that
  a binding cannot be added because the name is already bound to
  another object.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming NameAlreadyBoundException]))

(defn ->name-already-bound-exception
  "Constructor.

  Constructs a new instance of NameAlreadyBoundException using the
   explanation supplied. All other fields default to null.

  explanation - Possibly null additional detail about this exception. - `java.lang.String`"
  (^NameAlreadyBoundException [^java.lang.String explanation]
    (new NameAlreadyBoundException explanation))
  (^NameAlreadyBoundException []
    (new NameAlreadyBoundException )))

