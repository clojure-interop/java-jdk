(ns javax.naming.directory.AttributeInUseException
  "This exception is thrown when an operation attempts
  to add an attribute that already exists.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory AttributeInUseException]))

(defn ->attribute-in-use-exception
  "Constructor.

  Constructs a new instance of AttributeInUseException with
   an explanation. All other fields are set to null.

  explanation - Possibly null additional detail about this exception. - `java.lang.String`"
  (^AttributeInUseException [^java.lang.String explanation]
    (new AttributeInUseException explanation))
  (^AttributeInUseException []
    (new AttributeInUseException )))

