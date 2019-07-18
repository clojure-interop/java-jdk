(ns javax.naming.OperationNotSupportedException
  "This exception is thrown when a context implementation does not support
  the operation being invoked.
  For example, if a server does not support the Context.bind() method
  it would throw OperationNotSupportedException when the bind() method
  is invoked on it.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming OperationNotSupportedException]))

(defn ->operation-not-supported-exception
  "Constructor.

  Constructs a new instance of OperationNotSupportedException using an
   explanation. All other fields default to null.

  explanation - Possibly null additional detail about this exception - `java.lang.String`"
  (^OperationNotSupportedException [^java.lang.String explanation]
    (new OperationNotSupportedException explanation))
  (^OperationNotSupportedException []
    (new OperationNotSupportedException )))

