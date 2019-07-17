(ns javax.xml.crypto.NoSuchMechanismException
  "This exception is thrown when a particular XML mechanism is requested but
  is not available in the environment.

  A NoSuchMechanismException can contain a cause: another
  throwable that caused this NoSuchMechanismException to get
  thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto NoSuchMechanismException]))

(defn ->no-such-mechanism-exception
  "Constructor.

  Constructs a new NoSuchMechanismException with the
   specified detail message and cause.
   Note that the detail message associated with
   cause is not automatically incorporated in
   this exception's detail message.

  message - the detail message - `java.lang.String`
  cause - the cause (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new NoSuchMechanismException message cause))
  ([^java.lang.String message]
    (new NoSuchMechanismException message))
  ([]
    (new NoSuchMechanismException )))

(defn get-cause
  "Returns the cause of this NoSuchMechanismException or
   null if the cause is nonexistent or unknown.  (The
   cause is the throwable that caused this
   NoSuchMechanismException to get thrown.)

  returns: the cause of this NoSuchMechanismException or
           null if the cause is nonexistent or unknown. - `java.lang.Throwable`"
  ([^javax.xml.crypto.NoSuchMechanismException this]
    (-> this (.getCause))))

(defn print-stack-trace
  "Prints this NoSuchMechanismException, its backtrace and
   the cause's backtrace to the specified print stream.

  s - PrintStream to use for output - `java.io.PrintStream`"
  ([^javax.xml.crypto.NoSuchMechanismException this ^java.io.PrintStream s]
    (-> this (.printStackTrace s)))
  ([^javax.xml.crypto.NoSuchMechanismException this]
    (-> this (.printStackTrace))))

