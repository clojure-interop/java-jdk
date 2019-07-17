(ns jdk.security.InvalidParameterException
  "This exception, designed for use by the JCA/JCE engine classes,
  is thrown when an invalid parameter is passed
  to a method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security InvalidParameterException]))

(defn ->invalid-parameter-exception
  "Constructor.

  Constructs an InvalidParameterException with the specified
   detail message.  A detail message is a String that describes
   this particular exception.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new InvalidParameterException msg))
  ([]
    (new InvalidParameterException )))

