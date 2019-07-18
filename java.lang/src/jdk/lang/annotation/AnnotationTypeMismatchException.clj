(ns jdk.lang.annotation.AnnotationTypeMismatchException
  "Thrown to indicate that a program has attempted to access an element of
  an annotation whose type has changed after the annotation was compiled
  (or serialized).
  This exception can be thrown by the java.lang.reflect.API used to read annotations
  reflectively."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.annotation AnnotationTypeMismatchException]))

(defn ->annotation-type-mismatch-exception
  "Constructor.

  Constructs an AnnotationTypeMismatchException for the specified
   annotation type element and found data type.

  element - the Method object for the annotation element - `java.lang.reflect.Method`
  found-type - the (erroneous) type of data found in the annotation. This string may, but is not required to, contain the value as well. The exact format of the string is unspecified. - `java.lang.String`"
  (^AnnotationTypeMismatchException [^java.lang.reflect.Method element ^java.lang.String found-type]
    (new AnnotationTypeMismatchException element found-type)))

(defn element
  "Returns the Method object for the incorrectly typed element.

  returns: the Method object for the incorrectly typed element - `java.lang.reflect.Method`"
  (^java.lang.reflect.Method [^AnnotationTypeMismatchException this]
    (-> this (.element))))

(defn found-type
  "Returns the type of data found in the incorrectly typed element.
   The returned string may, but is not required to, contain the value
   as well.  The exact format of the string is unspecified.

  returns: the type of data found in the incorrectly typed element - `java.lang.String`"
  (^java.lang.String [^AnnotationTypeMismatchException this]
    (-> this (.foundType))))

