(ns jdk.lang.annotation.IncompleteAnnotationException
  "Thrown to indicate that a program has attempted to access an element of
  an annotation type that was added to the annotation type definition after
  the annotation was compiled (or serialized).  This exception will not be
  thrown if the new element has a default value.
  This exception can be thrown by the java.lang.reflect.API used to read annotations
  reflectively."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.annotation IncompleteAnnotationException]))

(defn ->incomplete-annotation-exception
  "Constructor.

  Constructs an IncompleteAnnotationException to indicate that
   the named element was missing from the specified annotation type.

  annotation-type - the Class object for the annotation type - `java.lang.annotation.Annotation>`
  element-name - the name of the missing element - `java.lang.String`

  throws: java.lang.NullPointerException - if either parameter is null"
  ([annotation-type element-name]
    (new IncompleteAnnotationException annotation-type element-name)))

(defn annotation-type
  "Returns the Class object for the annotation type with the
   missing element.

  returns: the Class object for the annotation type with the
       missing element - `java.lang.Class<? extends java.lang.annotation.Annotation>`"
  ([this]
    (-> this (.annotationType))))

(defn element-name
  "Returns the name of the missing element.

  returns: the name of the missing element - `java.lang.String`"
  ([this]
    (-> this (.elementName))))

