(ns javax.xml.crypto.dsig.XMLSignatureException
  "Indicates an exceptional condition that occurred during the XML
  signature generation or validation process.

  An XMLSignatureException can contain a cause: another
  throwable that caused this XMLSignatureException to get thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig XMLSignatureException]))

(defn ->xml-signature-exception
  "Constructor.

  Constructs a new XMLSignatureException with the
   specified detail message and cause.
   Note that the detail message associated with
   cause is not automatically incorporated in
   this exception's detail message.

  message - the detail message - `java.lang.String`
  cause - the cause (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^XMLSignatureException [^java.lang.String message ^java.lang.Throwable cause]
    (new XMLSignatureException message cause))
  (^XMLSignatureException [^java.lang.String message]
    (new XMLSignatureException message))
  (^XMLSignatureException []
    (new XMLSignatureException )))

(defn get-cause
  "Returns the cause of this XMLSignatureException or
   null if the cause is nonexistent or unknown.  (The
   cause is the throwable that caused this
   XMLSignatureException to get thrown.)

  returns: the cause of this XMLSignatureException or
           null if the cause is nonexistent or unknown. - `java.lang.Throwable`"
  (^java.lang.Throwable [^XMLSignatureException this]
    (-> this (.getCause))))

(defn print-stack-trace
  "Prints this XMLSignatureException, its backtrace and
   the cause's backtrace to the specified print stream.

  s - PrintStream to use for output - `java.io.PrintStream`"
  ([^XMLSignatureException this ^java.io.PrintStream s]
    (-> this (.printStackTrace s)))
  ([^XMLSignatureException this]
    (-> this (.printStackTrace))))

