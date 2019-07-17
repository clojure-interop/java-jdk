(ns javax.xml.crypto.MarshalException
  "Indicates an exceptional condition that occurred during the XML
  marshalling or unmarshalling process.

  A MarshalException can contain a cause: another
  throwable that caused this MarshalException to get thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto MarshalException]))

(defn ->marshal-exception
  "Constructor.

  Constructs a new MarshalException with the
   specified detail message and cause.
   Note that the detail message associated with
   cause is not automatically incorporated in
   this exception's detail message.

  message - the detail message - `java.lang.String`
  cause - the cause (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new MarshalException message cause))
  ([^java.lang.String message]
    (new MarshalException message))
  ([]
    (new MarshalException )))

(defn get-cause
  "Returns the cause of this MarshalException or
   null if the cause is nonexistent or unknown.  (The
   cause is the throwable that caused this
   MarshalException to get thrown.)

  returns: the cause of this MarshalException or
           null if the cause is nonexistent or unknown. - `java.lang.Throwable`"
  ([^javax.xml.crypto.MarshalException this]
    (-> this (.getCause))))

(defn print-stack-trace
  "Prints this MarshalException, its backtrace and
   the cause's backtrace to the specified print stream.

  s - PrintStream to use for output - `java.io.PrintStream`"
  ([^javax.xml.crypto.MarshalException this ^java.io.PrintStream s]
    (-> this (.printStackTrace s)))
  ([^javax.xml.crypto.MarshalException this]
    (-> this (.printStackTrace))))

