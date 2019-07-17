(ns javax.naming.PartialResultException
  "This exception is thrown to indicate that the result being returned
  or returned so far is partial, and that the operation cannot
  be completed.  For example, when listing a context, this exception
  indicates that returned results only represents some of the bindings
  in the context.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming PartialResultException]))

(defn ->partial-result-exception
  "Constructor.

  Constructs a new instance of the exception using the explanation
   message specified. All other fields default to null.

  explanation - Possibly null detail explaining the exception. - `java.lang.String`"
  ([explanation]
    (new PartialResultException explanation))
  ([]
    (new PartialResultException )))

