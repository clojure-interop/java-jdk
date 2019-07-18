(ns javax.crypto.ExemptionMechanismException
  "This is the generic ExemptionMechanism exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto ExemptionMechanismException]))

(defn ->exemption-mechanism-exception
  "Constructor.

  Constructs a ExemptionMechanismException with the specified
   detailed message. (A detailed message is a String that describes
   this particular exception.)

  msg - the detailed message. - `java.lang.String`"
  (^ExemptionMechanismException [^java.lang.String msg]
    (new ExemptionMechanismException msg))
  (^ExemptionMechanismException []
    (new ExemptionMechanismException )))

