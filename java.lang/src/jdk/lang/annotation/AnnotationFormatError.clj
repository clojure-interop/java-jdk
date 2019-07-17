(ns jdk.lang.annotation.AnnotationFormatError
  "Thrown when the annotation parser attempts to read an annotation
  from a class file and determines that the annotation is malformed.
  This error can be thrown by the java.lang.reflect.API used to read annotations
  reflectively."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.annotation AnnotationFormatError]))

(defn ->annotation-format-error
  "Constructor.

  Constructs a new AnnotationFormatError with the specified
   detail message and cause.  Note that the detail message associated
   with cause is not automatically incorporated in
   this error's detail message.

  message - the detail message - `java.lang.String`
  cause - the cause (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new AnnotationFormatError message cause))
  ([^java.lang.String message]
    (new AnnotationFormatError message)))

