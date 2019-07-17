(ns javax.print.attribute.UnmodifiableSetException
  "Thrown to indicate that the requested operation cannot be performed
  because the set is unmodifiable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute UnmodifiableSetException]))

(defn ->unmodifiable-set-exception
  "Constructor.

  Constructs an UnmodifiableSetException with the specified
   detail message.

  message - the detail message - `java.lang.String`"
  ([message]
    (new UnmodifiableSetException message))
  ([]
    (new UnmodifiableSetException )))

