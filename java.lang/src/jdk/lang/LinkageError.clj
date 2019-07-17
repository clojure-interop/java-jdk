(ns jdk.lang.LinkageError
  "Subclasses of LinkageError indicate that a class has
  some dependency on another class; however, the latter class has
  incompatibly changed after the compilation of the former class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang LinkageError]))

(defn ->linkage-error
  "Constructor.

  Constructs a LinkageError with the specified detail
   message and cause.

  s - the detail message. - `java.lang.String`
  cause - the cause, may be null - `java.lang.Throwable`"
  ([^java.lang.String s ^java.lang.Throwable cause]
    (new LinkageError s cause))
  ([^java.lang.String s]
    (new LinkageError s))
  ([]
    (new LinkageError )))

