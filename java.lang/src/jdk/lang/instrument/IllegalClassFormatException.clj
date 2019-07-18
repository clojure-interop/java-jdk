(ns jdk.lang.instrument.IllegalClassFormatException
  "Thrown by an implementation of
  ClassFileTransformer.transform
  when its input parameters are invalid.
  This may occur either because the initial class file bytes were
  invalid or a previously applied transform corrupted the bytes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.instrument IllegalClassFormatException]))

(defn ->illegal-class-format-exception
  "Constructor.

  Constructs an IllegalClassFormatException with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  (^IllegalClassFormatException [^java.lang.String s]
    (new IllegalClassFormatException s))
  (^IllegalClassFormatException []
    (new IllegalClassFormatException )))

