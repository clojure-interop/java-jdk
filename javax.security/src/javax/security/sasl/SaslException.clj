(ns javax.security.sasl.SaslException
  "This class represents an error that has occurred when using SASL."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.sasl SaslException]))

(defn ->sasl-exception
  "Constructor.

  Constructs a new instance of SaslException with a detailed message
   and a root exception.
   For example, a SaslException might result from a problem with
   the callback handler, which might throw a NoSuchCallbackException if
   it does not support the requested callback, or throw an IOException
   if it had problems obtaining data for the callback. The
   SaslException's root exception would be then be the exception thrown
   by the callback handler.

  detail - A possibly null string containing details of the exception. - `java.lang.String`
  ex - A possibly null root exception that caused this exception. - `java.lang.Throwable`"
  (^SaslException [^java.lang.String detail ^java.lang.Throwable ex]
    (new SaslException detail ex))
  (^SaslException [^java.lang.String detail]
    (new SaslException detail))
  (^SaslException []
    (new SaslException )))

(defn get-cause
  "Description copied from class: Throwable

  returns: the cause of this throwable or null if the
            cause is nonexistent or unknown. - `java.lang.Throwable`"
  (^java.lang.Throwable [^SaslException this]
    (-> this (.getCause))))

(defn init-cause
  "Description copied from class: Throwable

  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`

  returns: a reference to this Throwable instance. - `java.lang.Throwable`"
  (^java.lang.Throwable [^SaslException this ^java.lang.Throwable cause]
    (-> this (.initCause cause))))

(defn to-string
  "Returns the string representation of this exception.
   The string representation contains
   this exception's class name, its detailed message, and if
   it has a root exception, the string representation of the root
   exception. This string representation
   is meant for debugging and not meant to be interpreted
   programmatically.

  returns: The non-null string representation of this exception. - `java.lang.String`"
  (^java.lang.String [^SaslException this]
    (-> this (.toString))))

