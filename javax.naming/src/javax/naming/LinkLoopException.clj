(ns javax.naming.LinkLoopException
  "This exception is thrown when
  a loop was detected will attempting to resolve a link, or an implementation
  specific limit on link counts has been reached.

  Synchronization and serialization issues that apply to LinkException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming LinkLoopException]))

(defn ->link-loop-exception
  "Constructor.

  Constructs a new instance of LinkLoopException with an explanation
   All the other fields are initialized to null.

  explanation - A possibly null string containing additional detail about this exception. - `java.lang.String`"
  (^LinkLoopException [^java.lang.String explanation]
    (new LinkLoopException explanation))
  (^LinkLoopException []
    (new LinkLoopException )))

