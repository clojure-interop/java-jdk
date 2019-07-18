(ns jdk.lang.BootstrapMethodError
  "Thrown to indicate that an invokedynamic instruction has
  failed to find its bootstrap method,
  or the bootstrap method has failed to provide a
  java.lang.invoke.call site with a target
  of the correct method type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang BootstrapMethodError]))

(defn ->bootstrap-method-error
  "Constructor.

  Constructs a BootstrapMethodError with the specified
   detail message and cause.

  s - the detail message. - `java.lang.String`
  cause - the cause, may be null. - `java.lang.Throwable`"
  (^BootstrapMethodError [^java.lang.String s ^java.lang.Throwable cause]
    (new BootstrapMethodError s cause))
  (^BootstrapMethodError [^java.lang.String s]
    (new BootstrapMethodError s))
  (^BootstrapMethodError []
    (new BootstrapMethodError )))

