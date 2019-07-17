(ns javax.naming.InterruptedNamingException
  "This exception is thrown when the naming operation
  being invoked has been interrupted. For example, an application
  might interrupt a thread that is performing a search. If the
  search supports being interrupted, it will throw
  InterruptedNamingException. Whether an operation is interruptible
  and when depends on its implementation (as provided by the
  service providers). Different implementations have different ways
  of protecting their resources and objects from being damaged
  due to unexpected interrupts.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming InterruptedNamingException]))

(defn ->interrupted-naming-exception
  "Constructor.

  Constructs an instance of InterruptedNamingException using an
   explanation of the problem.
   All name resolution-related fields are initialized to null.

  explanation - A possibly null message explaining the problem. - `java.lang.String`"
  ([^java.lang.String explanation]
    (new InterruptedNamingException explanation))
  ([]
    (new InterruptedNamingException )))

