(ns jdk.lang.ClassFormatError
  "Thrown when the Java Virtual Machine attempts to read a class
  file and determines that the file is malformed or otherwise cannot
  be interpreted as a class file."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ClassFormatError]))

(defn ->class-format-error
  "Constructor.

  Constructs a ClassFormatError with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new ClassFormatError s))
  ([]
    (new ClassFormatError )))

