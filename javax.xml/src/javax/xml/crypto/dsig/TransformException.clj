(ns javax.xml.crypto.dsig.TransformException
  "Indicates an exceptional condition that occurred while executing a
  transform algorithm.

  A TransformException can contain a cause: another
  throwable that caused this TransformException to get thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig TransformException]))

(defn ->transform-exception
  "Constructor.

  Constructs a new TransformException with the
   specified detail message and cause.
   Note that the detail message associated with
   cause is not automatically incorporated in
   this exception's detail message.

  message - the detail message - `java.lang.String`
  cause - the cause (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^TransformException [^java.lang.String message ^java.lang.Throwable cause]
    (new TransformException message cause))
  (^TransformException [^java.lang.String message]
    (new TransformException message))
  (^TransformException []
    (new TransformException )))

(defn get-cause
  "Returns the cause of this TransformException or
   null if the cause is nonexistent or unknown.  (The
   cause is the throwable that caused this
   TransformException to get thrown.)

  returns: the cause of this TransformException or
           null if the cause is nonexistent or unknown. - `java.lang.Throwable`"
  (^java.lang.Throwable [^TransformException this]
    (-> this (.getCause))))

(defn print-stack-trace
  "Prints this TransformException, its backtrace and
   the cause's backtrace to the specified print stream.

  s - PrintStream to use for output - `java.io.PrintStream`"
  ([^TransformException this ^java.io.PrintStream s]
    (-> this (.printStackTrace s)))
  ([^TransformException this]
    (-> this (.printStackTrace))))

