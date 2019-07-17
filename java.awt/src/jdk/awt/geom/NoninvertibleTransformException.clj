(ns jdk.awt.geom.NoninvertibleTransformException
  "The NoninvertibleTransformException class represents
  an exception that is thrown if an operation is performed requiring
  the inverse of an AffineTransform object but the
  AffineTransform is in a non-invertible state."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom NoninvertibleTransformException]))

(defn ->noninvertible-transform-exception
  "Constructor.

  Constructs an instance of
   NoninvertibleTransformException
   with the specified detail message.

  s - the detail message - `java.lang.String`"
  ([s]
    (new NoninvertibleTransformException s)))

