(ns javax.naming.directory.NoSuchAttributeException
  "This exception is thrown when attempting to access
  an attribute that does not exist.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory NoSuchAttributeException]))

(defn ->no-such-attribute-exception
  "Constructor.

  Constructs a new instance of NoSuchAttributeException using
   an explanation. All other fields are set to null.

  explanation - Additional detail about this exception. Can be null. - `java.lang.String`"
  ([^java.lang.String explanation]
    (new NoSuchAttributeException explanation))
  ([]
    (new NoSuchAttributeException )))

