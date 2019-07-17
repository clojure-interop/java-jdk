(ns jdk.lang.OutOfMemoryError
  "Thrown when the Java Virtual Machine cannot allocate an object
  because it is out of memory, and no more memory could be made
  available by the garbage collector.

  OutOfMemoryError objects may be constructed by the virtual
  machine as if suppression were disabled and/or the stack trace was not
  writable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang OutOfMemoryError]))

(defn ->out-of-memory-error
  "Constructor.

  Constructs an OutOfMemoryError with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new OutOfMemoryError s))
  ([]
    (new OutOfMemoryError )))

