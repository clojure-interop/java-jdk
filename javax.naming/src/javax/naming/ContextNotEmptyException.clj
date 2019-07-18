(ns javax.naming.ContextNotEmptyException
  "This exception is thrown when attempting to destroy a context that
  is not empty.

  If the program wants to handle this exception in particular, it
  should catch ContextNotEmptyException explicitly before attempting to
  catch NamingException. For example, after catching ContextNotEmptyException,
  the program might try to remove the contents of the context before
  reattempting the destroy.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming ContextNotEmptyException]))

(defn ->context-not-empty-exception
  "Constructor.

  Constructs a new instance of ContextNotEmptyException using an
   explanation. All other fields default to null.

  explanation - Possibly null string containing additional detail about this exception. - `java.lang.String`"
  (^ContextNotEmptyException [^java.lang.String explanation]
    (new ContextNotEmptyException explanation))
  (^ContextNotEmptyException []
    (new ContextNotEmptyException )))

