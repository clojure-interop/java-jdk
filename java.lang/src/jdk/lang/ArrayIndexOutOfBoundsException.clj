(ns jdk.lang.ArrayIndexOutOfBoundsException
  "Thrown to indicate that an array has been accessed with an
  illegal index. The index is either negative or greater than or
  equal to the size of the array."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ArrayIndexOutOfBoundsException]))

(defn ->array-index-out-of-bounds-exception
  "Constructor.

  Constructs a new ArrayIndexOutOfBoundsException
   class with an argument indicating the illegal index.

  index - the illegal index. - `int`"
  ([^Integer index]
    (new ArrayIndexOutOfBoundsException index))
  ([]
    (new ArrayIndexOutOfBoundsException )))

