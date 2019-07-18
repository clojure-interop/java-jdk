(ns jdk.lang.instrument.UnmodifiableClassException
  "Thrown by an implementation of
  Instrumentation.redefineClasses
  when one of the specified classes cannot be modified."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.instrument UnmodifiableClassException]))

(defn ->unmodifiable-class-exception
  "Constructor.

  Constructs an UnmodifiableClassException with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  (^UnmodifiableClassException [^java.lang.String s]
    (new UnmodifiableClassException s))
  (^UnmodifiableClassException []
    (new UnmodifiableClassException )))

